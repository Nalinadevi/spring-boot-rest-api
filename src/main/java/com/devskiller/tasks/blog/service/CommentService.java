package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostService postService;

	public CommentService(CommentRepository commentRepository, PostService postService) {
		this.commentRepository = commentRepository;
		this.postService = postService;
	}

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent first
	 */
	public List<CommentDto> getCommentsForPost(Long postId) {
		return commentRepository.getAllByPostId(postId)
			.stream().map(comment -> new CommentDto(
			comment.getId(),
			comment.getComment(),
			comment.getAuthor(),
			comment.getCreationDate()))
			.sorted(Comparator.comparing(CommentDto::getCreationDate).reversed()).collect(Collectors.toList());
	}

	/**
	 * Creates a new comment
	 *
	 * @param newCommentDto data of new comment
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
	 */
	public Long addComment(NewCommentDto newCommentDto) {
		postService.getPostEntity(newCommentDto.getPostId());
		Comment comment = new Comment(newCommentDto.getPostId(), newCommentDto.getAuthor(), newCommentDto.getContent(), LocalDateTime.now());
		return commentRepository.save(comment).getId();
	}
}

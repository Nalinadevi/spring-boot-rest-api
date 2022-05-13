package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.CommentService;
import com.devskiller.tasks.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	private final CommentService commentService;

	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
		return ResponseEntity.ok(postService.getPost(id));
	}

	@PostMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public Long savePostComment(@PathVariable("id") Long id, @RequestBody NewCommentDto newComment) {
		newComment.setPostId(id);
		return commentService.addComment(newComment);
	}

	@GetMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<CommentDto>> getPostComments(@PathVariable("id") Long id) {
		return ResponseEntity.ok(commentService.getCommentsForPost(id));
	}
}

package com.devskiller.tasks.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	private Long postId;

	@Column(length = 4096)
	private String comment;

	private String author;

	private LocalDateTime creationDate;

	public Comment(Long postId, String author, String content, LocalDateTime creationDate) {
		this.postId = postId;
		this.author = author;
		this.comment = content;
		this.creationDate = creationDate;
	}

	public Comment() {

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setAuthor(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}

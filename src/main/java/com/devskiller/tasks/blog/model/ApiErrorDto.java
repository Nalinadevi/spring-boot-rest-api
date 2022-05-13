package com.devskiller.tasks.blog.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiErrorDto {
	HttpStatus status;
	Integer statusCode;
	LocalDateTime timeStamp;
	String message;

	public ApiErrorDto(HttpStatus status, Integer statusCode, String message) {
		this.status = status;
		this.statusCode = statusCode;
		this.timeStamp = LocalDateTime.now();
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}
}

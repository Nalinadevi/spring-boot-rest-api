package com.devskiller.tasks.blog.advicer;

import com.devskiller.tasks.blog.model.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = ex.getMessage() != null ? ex.getMessage() : "The given parameter is not valid";
		return ResponseEntity.status(status).body(
			new ApiErrorDto(status, status.value(), message)
		);
	}
}

package com.devskiller.tasks.blog.exception;

public class NotAPostIdException extends RuntimeException {
	public NotAPostIdException() {super("The given post id does not exists.");}
}

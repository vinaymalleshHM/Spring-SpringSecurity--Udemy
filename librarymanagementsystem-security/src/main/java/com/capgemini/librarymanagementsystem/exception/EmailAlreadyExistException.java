package com.capgemini.librarymanagementsystem.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
}

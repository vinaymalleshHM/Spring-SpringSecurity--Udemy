package com.capgemini.airlinereservationsystemadmin.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExitsException extends RuntimeException {
	public EmailAlreadyExitsException(String msg) {
		super(msg);
	}
}

package com.capgemini.airlinereservationsystemadmin.exception;

@SuppressWarnings("serial")
public class FlightNameAlreadyExitsException extends RuntimeException {
	public FlightNameAlreadyExitsException (String msg) {
		super(msg);
	}
}

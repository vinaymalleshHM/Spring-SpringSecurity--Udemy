package com.capgemini.airlinereservationsystempassenger.exception;

@SuppressWarnings("serial")
public class FlightNameAlreadyExitsException extends RuntimeException {
	public FlightNameAlreadyExitsException (String msg) {
		super(msg);
	}
}

package com.capgemini.airlinereservationsystempassenger.dataresponse;

import java.util.List;

import com.capgemini.airlinereservationsystempassenger.dao.BookingDao;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketResponse {

	private int statusCode;
	private String message;
	private String description;
	
	private BookingDao ticketbean;
	private List<BookingDao> TicketList;
}

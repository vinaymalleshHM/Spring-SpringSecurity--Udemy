package com.capgemini.airlinereservationsystempassenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.airlinereservationsystempassenger.beans.BookingBean;
import com.capgemini.airlinereservationsystempassenger.dataresponse.BookingResponse;
import com.capgemini.airlinereservationsystempassenger.service.BookingServieImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class PassengerController {

	@Autowired
	private BookingServieImpl service;
	
	@PostMapping(path = "/bookingFlights",produces = MediaType.APPLICATION_JSON_VALUE,
			     consumes = MediaType.APPLICATION_JSON_VALUE)
	 public BookingResponse booking(@RequestBody BookingBean booking) {
		BookingResponse response = new BookingResponse();
		
		if(service.bookingFlights(booking)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Booking succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user registration failed");
		}
		return response;
	}
	
	@GetMapping(path = "/getTicket/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse getTicket(@PathVariable("bookingId") int bookingId) {
		List<BookingBean> bookingBean = service.getTicket(bookingId);
		BookingResponse response = new BookingResponse();
		
		if (bookingBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setBookingList(bookingBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
			response.setBookingList(null);
		}
		return response;
	}

	
	@DeleteMapping(path = "/deleteTicket/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse deleteTicket(@PathVariable("bookingId") int bookingId) {
		BookingResponse response = new BookingResponse();
		if (service.deleteTicket(bookingId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data deleted in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Deleted in DB");
		}
		return response;
	}
}

package com.capgemini.airlinereservationsystemadmin.dao;

import java.util.List;

import com.capgemini.airlinereservationsystemadmin.beans.BookingBean;


public interface BookingDao {

	public boolean bookingFlights(BookingBean booking);
	
	public List<BookingBean> getTicket(int bookingId);
	
	public boolean deleteTicket(int bookingId);
	
}

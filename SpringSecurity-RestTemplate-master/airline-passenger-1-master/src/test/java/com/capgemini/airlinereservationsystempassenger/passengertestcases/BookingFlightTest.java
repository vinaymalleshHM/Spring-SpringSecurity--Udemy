package com.capgemini.airlinereservationsystempassenger.passengertestcases;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystempassenger.beans.BookingBean;
import com.capgemini.airlinereservationsystempassenger.dao.BookingDao;

import junit.framework.TestCase;

@SpringBootTest
public class BookingFlightTest {

	@Autowired
	private BookingDao dao;
	
	public void bookingFlightTest() throws ParseException{
		BookingBean bean = new BookingBean();
		bean.setDestination("Bangalore");
		bean.setSource("chennai");
		bean.setNumOfSeats(200);
		TestCase.assertTrue(dao.bookingFlights(bean));
	}
}

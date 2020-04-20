package com.capgemini.airlinereservationsystempassenger.passengertestcases;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystempassenger.beans.BookingBean;
import com.capgemini.airlinereservationsystempassenger.dao.BookingDao;

@SpringBootTest
public class GetTicketTest {

	@Autowired
	private BookingDao dao;
	
	@Test
	public void getTicketTest() throws ParseException{
		BookingBean bean = new BookingBean();
		List<BookingBean> booking = dao.getTicket(bean.getBookingId());
		assertNotNull(booking);
	}
}

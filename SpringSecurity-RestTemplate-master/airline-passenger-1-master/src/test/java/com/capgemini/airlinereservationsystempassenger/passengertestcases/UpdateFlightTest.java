package com.capgemini.airlinereservationsystempassenger.passengertestcases;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystempassenger.beans.FlightBean;
import com.capgemini.airlinereservationsystempassenger.dao.FlightDao;

import junit.framework.TestCase;

@SpringBootTest
public class UpdateFlightTest {

	@Autowired
	private FlightDao dao;
	
	public void updateUserTest() throws ParseException{
		FlightBean bean = new FlightBean();
		bean.setFlightId(1);
		bean.setFlightName("kignfisher");
		bean.setActive(true);
		bean.setSource("Bangalore");
		bean.setDestination("Bombay");
        bean.setTicketPrice(20000);
        bean.setClassType("bussiness");
        TestCase.assertTrue(bean.getFlightName(),true);
	}
}

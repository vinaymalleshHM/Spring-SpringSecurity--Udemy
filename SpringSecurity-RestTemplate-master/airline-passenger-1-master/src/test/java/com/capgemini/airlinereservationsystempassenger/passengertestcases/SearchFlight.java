package com.capgemini.airlinereservationsystempassenger.passengertestcases;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystempassenger.beans.FlightBean;
import com.capgemini.airlinereservationsystempassenger.dao.FlightDao;

@SpringBootTest
public class SearchFlight {

	@Autowired
	private FlightDao dao;
	
	public void search() throws ParseException{
		FlightBean bean = new FlightBean();
		List<FlightBean> flight = dao.searchFlight(bean.getFlightName());
		assertNotNull(flight);
	}
}

package com.capgemini.airlinereservationsystempassenger.passengertestcases;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystempassenger.beans.FlightBean;
import com.capgemini.airlinereservationsystempassenger.dao.FlightDao;


@SpringBootTest
public class GetAllFlights {

	@Autowired
	private FlightDao doa;
	
	public void getAllFlightstest() throws ParseException{
		List<FlightBean> bean = doa.getAllFlights();
		assertNotNull(bean);

	}
}

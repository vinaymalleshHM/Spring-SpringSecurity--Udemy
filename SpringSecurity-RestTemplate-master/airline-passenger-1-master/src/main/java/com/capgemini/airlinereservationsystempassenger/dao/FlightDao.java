package com.capgemini.airlinereservationsystempassenger.dao;

import java.util.List;

import com.capgemini.airlinereservationsystempassenger.beans.FlightBean;


public interface FlightDao {

	public boolean flightRegister(FlightBean flightbean);
	
	public List<FlightBean> searchFlight(String flightName);

	public List<FlightBean> getAllFlights();
	
	public boolean deleteFlight(int flightId);
	
	public boolean updateFlight(FlightBean bean);
}

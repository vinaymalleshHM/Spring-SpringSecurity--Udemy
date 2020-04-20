package com.capgemini.airlinereservationsystemangularfinal.dao;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.FlightBean;


public interface FlightDao {

	public boolean flightRegister(FlightBean flightbean);
	
	public List<FlightBean> searchFlight(String flightName);

	public List<FlightBean> getAllFlights();
	
	public boolean deleteFlight(int flightId);
	
	public boolean updateFlight(FlightBean bean);
}

package com.capgemini.airlinereservationsystemadmin.service;

import java.util.List;

import com.capgemini.airlinereservationsystemadmin.beans.FlightBean;

public interface FlightService {
	
	public boolean flightRegister(FlightBean flightbean);

	public List<FlightBean> searchFlight(String flightName);

	public List<FlightBean> getAllFlights();

	public boolean deleteFlight(int flightId);

	public boolean updateFlight(FlightBean bean);
}

package com.capgemini.airlinereservationsystemadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.airlinereservationsystemadmin.beans.FlightBean;
import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemadmin.dataresponse.FlightResponse;
import com.capgemini.airlinereservationsystemadmin.dataresponse.UserResponse;
import com.capgemini.airlinereservationsystemadmin.service.FlightServiceImpl;
import com.capgemini.airlinereservationsystemadmin.service.UserServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true",exposedHeaders = "Access-Control-Allow-Origin")
public class AdminController {
	@Autowired
	private UserServiceImpl service;

	@Autowired
	private FlightServiceImpl flightservice;

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody UserInfoBean userInfoBean) {
		UserResponse response = new UserResponse();
		
		if (service.register(userInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user registered succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user registration failed");
		}
		return response;
	}

	@PostMapping(path = "/flightRegister", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse flightRegisteration(@RequestBody FlightBean flightbean) {
		FlightResponse response = new FlightResponse();
		
		if (flightservice.flightRegister(flightbean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight Registered SuccessFully!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Flight Registered Failed");
		}
		return response;
	}
	
	@GetMapping(path = "/getUser/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getUser(@PathVariable("userName") String userName) {
		List<UserInfoBean> userInfoBean = service.getuser(userName);
		UserResponse response = new UserResponse();

		if (userInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setUserList(userInfoBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
			response.setUserList(null);
		}
		return response;
	}

	@GetMapping(path = "/getFlightDetails/{flightName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse getFlightDetails(@PathVariable("flightName") String flightName) {
		List<FlightBean> flightBean = flightservice.searchFlight(flightName);
		FlightResponse response = new FlightResponse();

		if (flightBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setFlightList(flightBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
			response.setFlightList(null);
		}
		return response;
	}

	@DeleteMapping(path = "/deleteFlight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse deleteFlight(@PathVariable("flightId") int flightId) {
		FlightResponse response = new FlightResponse();
		if (flightservice.deleteFlight(flightId)) {
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

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {
		List<UserInfoBean> userList = service.getAllUsers();
		UserResponse response = new UserResponse();
		if (userList != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setUserList(userList);

		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
		}
		return response;
	}

	@GetMapping(path = "/getAllFlights", produces = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse getAllFlights() {
		List<FlightBean> flightList = flightservice.getAllFlights();
		FlightResponse response = new FlightResponse();
		if (flightList != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user record found");
			response.setFlightList(flightList);

		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("user record not found");
			response.setFlightList(null);
		}
		return response;
	}

	@PutMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody UserInfoBean userInfoBean) {
		UserResponse response = new UserResponse();

		if (service.updateUser(userInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Updated in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not Updated in  db");
		}
		return response;
	}

	@PutMapping(path = "/updateFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlightResponse updateFlight(@RequestBody FlightBean flightBean) {
		FlightResponse response = new FlightResponse();

		if (flightservice.updateFlight(flightBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Updated in DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not Updated in  db");
		}
		return response;
	}


}
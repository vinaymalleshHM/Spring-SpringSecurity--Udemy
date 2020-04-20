package com.capgemini.airlinereservationsystempassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AirlinereservationsystempassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinereservationsystempassengerApplication.class, args);
	}

}

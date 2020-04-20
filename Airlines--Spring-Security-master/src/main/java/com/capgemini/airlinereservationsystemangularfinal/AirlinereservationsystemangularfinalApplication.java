package com.capgemini.airlinereservationsystemangularfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AirlinereservationsystemangularfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinereservationsystemangularfinalApplication.class, args);
	}
}

package com.udemy.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";

	}
	
	//Add Request Mapping for / access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDeneid() {
		return "access-denied";

	}

}

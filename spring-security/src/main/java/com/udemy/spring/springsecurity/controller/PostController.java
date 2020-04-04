package com.udemy.spring.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/posts") 
public class PostController {

	//	@Secured("ROLE_ADMIN")
	@Secured("ROLE_GUEST")
//	@RequestMapping("/list")
	public String list() {
		return "list post...";
	}

	@Secured("ROLE_USER")
//	@RequestMapping("/drafts")
	public String viewDrafts() {
		return "view draft...";
	}

	//	@Secured("ROLE_ADMIN")
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/add")
	public String addPost() {
		return "add post...";
	}
	
}

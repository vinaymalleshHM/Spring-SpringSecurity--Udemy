package com.udemy.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBaseController {
	@RequestMapping("/posts/")
	public String list(){
		return "list posts...";
	}
	
	@RequestMapping("/admin/posts/create")
	public String addPost(){
		return "add posts...";
	}

}

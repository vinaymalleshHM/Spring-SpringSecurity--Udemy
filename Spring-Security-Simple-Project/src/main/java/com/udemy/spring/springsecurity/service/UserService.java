package com.udemy.spring.springsecurity.service;

import com.udemy.spring.springsecurity.domain.User;

public interface UserService {
	public User findByEmail(String email);
}

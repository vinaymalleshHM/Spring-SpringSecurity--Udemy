package com.udemy.spring.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.udemy.spring.springsecurity.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}

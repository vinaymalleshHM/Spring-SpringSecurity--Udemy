package com.udemy.spring.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth); //  No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken error

		//add our users for in memory Authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
		.withUser(users.username("prince").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("Winay").password("Aa@123456").roles("MANAGER"))
		.withUser(users.username("vinay").password("Aa@123456").roles("ADMIN"));

	}

	
}

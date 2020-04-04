package com.udemy.spring.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	//there is no passwordencoder mapped for the id null to over come this 
	//1.solution - password("{noop}Aa@123456")

	@Autowired
	public void cinfigureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("prince")
		.password("{noop}Aa@123456")
		.roles("ADMIN")
		.and()
		.withUser("Winay")
		.password("{noop}Aa@123456")
		.roles("USER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/posts/list").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}


	//there is no passwordencoder mapped for the id null to over come this 
	//2.solution

	//	 @Bean
	//	    public UserDetailsService userDetailsService() {
	//
	//	        User.UserBuilder users = User.withDefaultPasswordEncoder();
	//	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	//	        manager.createUser(users.username("user").password("password").roles("USER").build());
	//	        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
	//	        return manager;
	//
	//	    }




}

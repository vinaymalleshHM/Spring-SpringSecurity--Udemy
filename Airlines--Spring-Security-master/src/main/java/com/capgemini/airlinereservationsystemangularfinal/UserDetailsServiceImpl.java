package com.capgemini.airlinereservationsystemangularfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.capgemini.airlinereservationsystemangularfinal.dao.UserDao;
import com.capgemini.airlinereservationsystemangularfinal.security.UserDetailsImpl;

@Component
public class UserDetailsServiceImpl<GrantedAuthority> implements UserDetailsService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setUserInfoBean(dao.getUser(userName));
		return userDetailsImpl;
		
	}
}

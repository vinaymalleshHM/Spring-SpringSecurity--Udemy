package com.capgemini.airlinereservationsystemadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemadmin.dao.UserDaoImpl;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean register(UserInfoBean userInfoBean) {
		userInfoBean.setPassword(passwordEncoder.encode(userInfoBean.getPassword()));
		return dao.register(userInfoBean);
	}

	@Override
	public boolean updateUser(UserInfoBean bean) {
		return dao.updateUser(bean);
	}

	@Override
	public List<UserInfoBean> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public List<UserInfoBean> getuser(String userName) {
		return dao.getuser(userName);
	}

	@Override
	public UserInfoBean getUser(String userName) {
		return dao.getUser(userName);
	}
}

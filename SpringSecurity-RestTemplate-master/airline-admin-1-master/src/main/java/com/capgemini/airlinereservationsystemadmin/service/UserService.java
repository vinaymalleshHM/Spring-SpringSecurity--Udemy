package com.capgemini.airlinereservationsystemadmin.service;

import java.util.List;

import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;



public interface UserService {
	public boolean register(UserInfoBean userInfoBean);

	public List<UserInfoBean> getuser(String userName);

	public List<UserInfoBean> getAllUsers();

	public boolean updateUser(UserInfoBean bean);
	
	public UserInfoBean getUser(String userName);
}

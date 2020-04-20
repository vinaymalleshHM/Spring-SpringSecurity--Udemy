package com.capgemini.airlinereservationsystempassenger.dao;

import java.util.List;

import com.capgemini.airlinereservationsystempassenger.beans.UserInfoBean;

public interface UserDao {
	
	public boolean register(UserInfoBean userInfoBean);

	public List<UserInfoBean> getuser(String userName);

	public boolean updateUser(UserInfoBean bean);

	public List<UserInfoBean> getAllUsers();
	
	public UserInfoBean getUser(String userName);
	
}

package com.capgemini.airlinereservationsystemadmin.admintest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.tomcat.util.json.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemadmin.dao.UserDao;


public class AdminTestCaseUpdateUser {
	@Autowired
	private UserDao dao;
	
	@Test
	public void updateUserTest() throws ParseException{
		UserInfoBean user = new UserInfoBean();
		user.setUserId(1);
		user.setUserName("raj");
		user.setEmailId("raj@gmail.com");
		user.setMobile(1234567890);
		user.setAddress("qwertyuiop");
		user.setNationality("Indian");
		try {
			boolean expectedFlag = dao.updateUser(user);
			assertEquals(expectedFlag, user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

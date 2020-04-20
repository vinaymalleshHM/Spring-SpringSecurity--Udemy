package com.capgemini.airlinereservationsystemadmin.admintest;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemadmin.dao.UserDao;

import junit.framework.TestCase;

@SpringBootTest
public class AdminTestCases {

	@Autowired
	private UserDao dao;
	
	public void testRegister() throws ParseException{
		UserInfoBean bean = new UserInfoBean();
		bean.setUserName("raj");
		bean.setEmailId("raj@gmail.com");
		bean.setPassword("Raj2019$");
		bean.setMobile(1234567890);
		bean.setAddress("qwertyuiop");
		bean.setNationality("Indian");
		TestCase.assertTrue(dao.register(bean));
	}
}

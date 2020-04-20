package com.capgemini.airlinereservationsystemadmin.admintest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.airlinereservationsystemadmin.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemadmin.dao.UserDao;

@SpringBootTest
public class AdminTestGetUser {

	@Autowired
	private UserDao dao;
	
	@Test
	public void getUser() throws ParseException{
		UserInfoBean user = new UserInfoBean();
		List<UserInfoBean> bean = dao.getuser(user.getUserName());
		assertNotNull(bean);
	}
}

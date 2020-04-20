package com.capgemini.librarymanagementsystem.response;

import java.util.List;


import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.BookRegister;
import com.capgemini.librarymanagementsystem.dto.Issue;
import com.capgemini.librarymanagementsystem.dto.UserInfoBean;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LibraryManagementSystemResponse {
	private int statusCode;
	private String message;
	private String decription;
	private Issue issue;
	public List<BookInfo> book;
	public List<UserInfoBean> users;
	public List<BookRegister> register;
	
}

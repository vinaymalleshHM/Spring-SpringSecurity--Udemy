package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.BookRegister;
import com.capgemini.librarymanagementsystem.dto.Issue;
import com.capgemini.librarymanagementsystem.dto.UserInfoBean;

public interface AdminDAO {


	public boolean addBook(int userId,BookInfo bookInfo);

	public boolean addUser(UserInfoBean userInfoBean);

	public boolean deleteUser(int userId);

	public boolean deleteBook(int bookId);

	public boolean updateUser(UserInfoBean userInfoBean);

	public List<UserInfoBean> showAllUser();

	public List<UserInfoBean> getByUserId(int userId);

	public UserInfoBean getUser(String userName);
	
	public List<BookRegister> requestView();
	
	public Issue acceptRequest(int registerId, String username, int bookId);
	
	public Boolean requestDeny(int registerId);
	
	public List<Issue> issuedBooks();
	

}

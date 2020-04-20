package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.Issue;

public interface UserDAO {

	public List<BookInfo> searchBook(BookInfo bookInfo);
	
	public int requestBook(int bookId, String username);
	
//	public Issue requestBook(BookInfo book, int userId);
	
	public void bookReturn(String username, int bookId, String returnDate);
	
}

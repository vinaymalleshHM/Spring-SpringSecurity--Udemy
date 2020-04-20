package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.BookRegister;
import com.capgemini.librarymanagementsystem.dto.Issue;

public interface UserService {

	// public Issue requestBook(BookInfo book, int userId);
	//
	// public boolean borrow(int userId, String bookName);

	public List<BookInfo> searchBook(BookInfo bookInfo);

	public int requestBook(int bookId, String username);

}

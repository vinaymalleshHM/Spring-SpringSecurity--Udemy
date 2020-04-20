package com.capgemini.librarymanagementsystem.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.BookRegister;
import com.capgemini.librarymanagementsystem.dto.Issue;
import com.capgemini.librarymanagementsystem.dto.UserInfoBean;
import com.capgemini.librarymanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.librarymanagementsystem.service.UserService;

import lombok.extern.java.Log;
import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Factory;

@Log
@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Autowired
	private BCryptPasswordEncoder encoder;

	Random random = new Random();

	@Override
	public boolean addUser(UserInfoBean userInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		try {
			userInfoBean.setUserPassword(encoder.encode(userInfoBean.getUserPassword()));
			manager.persist(userInfoBean);
			transcation.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			throw new EmailAlreadyExistException("mail id already exists");
		}

	}

	@Override
	public boolean deleteUser(int userId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserInfoBean bean = manager.find(UserInfoBean.class, userId);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		BookInfo bean = manager.find(BookInfo.class, bookId);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateUser(UserInfoBean userInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		trans.begin();
		UserInfoBean bean = manager.find(UserInfoBean.class, userInfoBean.getUserId());
		bean.setUsername(userInfoBean.getUsername());
		manager.persist(bean);
		trans.commit();
		return true;
	}

	@Override
	public List<UserInfoBean> showAllUser() {
		String jpql = "select u from UserInfoBean u";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		return query.getResultList();
	}

	@Override
	public List<UserInfoBean> getByUserId(int userId) {
		String jpql = "from UserInfoBean u where u.userId=:userId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		query.setParameter("userId", userId);
		return query.getResultList();

	}

	@Override
	public UserInfoBean getUser(String username) {
		String jpql = "select u from UserInfoBean u where u.username=:email";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		query.setParameter("email", username);
		return query.getSingleResult();
	}

	@Override
	public boolean addBook(int userId, BookInfo bookInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		try {
			bookInfo.setUserId(userId);
			manager.persist(bookInfo);
			transcation.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return false;
	}

	@Override
	public List<BookRegister> requestView() {
		List<BookRegister> bookRegisters = null;
		try {
			EntityManager entityManager = factory.createEntityManager();
			TypedQuery<BookRegister> typedQuery = entityManager.createQuery("from BookRegister", BookRegister.class);
			bookRegisters = typedQuery.getResultList();
			entityManager.close();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return bookRegisters;
	}

	@Override
	public Issue acceptRequest(int registerId, String userName, int book) {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<UserInfoBean> query = entityManager.createQuery("From UserInfoBean  where username =: userName", UserInfoBean.class);
		query.setParameter("userName", userName);
		UserInfoBean  user= query.getSingleResult();
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<BookInfo> typedQuery = manager.createQuery("From BookInfo  where bookId =: book", BookInfo.class);
		query.setParameter("book", book);
		BookInfo  books= typedQuery.getSingleResult();
		
		Issue issue = new Issue();
		LocalDate issueDate = LocalDate.now();
		LocalDate returnDate = issueDate.plusDays(15);
//		issue.setIssueId(random.nextInt(5000));
		 issue.setIssueId(issue.getIssueId());
		issue.setIssueDate(issueDate);
		issue.setRegisterId(registerId);
		issue.setReturnDate(returnDate);
		issue.setUsers(user);
//		issue.setBooks(book);
		

		//issue.setUserId(userInfoBean.getUserId());
		try {
			EntityTransaction transcation = entityManager.getTransaction();
			transcation.begin();
			entityManager.persist(issue);
			transcation.commit();
			entityManager.close();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return issue;
	}

	@Override
	public Boolean requestDeny(int registerId) {
		boolean isDenyed = false;
		try {
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			BookRegister bookRegister = entityManager.find(BookRegister.class, registerId);
			entityManager.remove(bookRegister);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return isDenyed;
	}

	@Override
	public List<Issue> issuedBooks() {
		List<Issue> booksTransactions = null;
		try {
			EntityManager manager = factory.createEntityManager();
			TypedQuery<Issue> typedQuery = manager.createQuery("FROM Issue", Issue.class);
			booksTransactions = typedQuery.getResultList();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return booksTransactions;
	}// end of issuedBook()

	// @Override
	// public Issue addFine(int issueId, Date returnDate) {
	// EntityManager manager = factory.createEntityManager();
	// EntityTransaction transaction = manager.getTransaction();
	// transaction.begin();
	// String viewDetails = "from Issue where issueId=:issueId";
	// Query query = manager.createQuery(viewDetails);
	// query.setParameter("issueId", issueId);
	// Issue book = (Issue) query.getSingleResult();
	// Date rn = book.getReturnDate();
	//
	// Issue booksPresent = manager.find(Issue.class, book.getTransactionId());
	// int days = (int) ((returnDate.getTime() - rn.getTime()) / (1000 * 60 * 60 *
	// 24));
	// if ((days - 15) > 0) {
	// booksPresent.setFine((days - 15) * 1);
	// } else {
	// booksPresent.setFine(book.getFine());
	// }
	//
	// booksPresent.setIssueDate(book.getIssueDate());
	// booksPresent.setBookId(book.getBookId());
	// booksPresent.setIssueId(book.getIssueId());
	// ;
	// booksPresent.setReturnDate(book.getReturnDate());
	// booksPresent.setUserId(book.getUserId());
	//
	// transaction.commit();
	// System.out.println(booksPresent.getFine());
	// return book;
	//
	// }

	// @Override
	// public Issue acceptRequest(int issueId) {
	// EntityManagerFactory entityManagerFactory =
	// Persistence.createEntityManagerFactory("TestPersistence");
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// EntityTransaction transaction = entityManager.getTransaction();
	// transaction.begin();
	//
	// String viewDetails = "select from BooksRegistration where
	// registrationId=:registrationId";
	// Query query = entityManager.createQuery(viewDetails);
	// query.setParameter("issueId", issueId);
	//
	// Issue books = (Issue) query.getSingleResult();
	// Random random = new Random();
	// int transactionId = random.nextInt();
	//
	// if (transactionId < 0) {
	// transactionId = transactionId * (-1);
	// }
	// Issue trans = new Issue();
	// trans.setIssueId(books.getIssueId());
	// trans.setTransactionId(transactionId);
	// trans.setIssueDate(books.getIssueDate());
	// trans.setFine(0);
	//
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(books.getIssueDate());
	// calendar.add(Calendar.DATE, 15);
	// trans.setReturnDate(calendar.getTime());
	//
	// entityManager.persist(trans);
	// transaction.commit();
	//
	// return trans;
	// }
	//

}

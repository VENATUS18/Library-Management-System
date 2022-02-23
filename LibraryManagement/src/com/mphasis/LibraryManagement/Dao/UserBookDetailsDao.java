package com.mphasis.LibraryManagement.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.mphasis.LibraryManagement.model.UserBookDetails;


@Repository 
public class UserBookDetailsDao {
	SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
	
	public UserBookDetails getByUserId(String bookIsbn) { 
		UserBookDetails u=null; 
		List<UserBookDetails> li=getAllUserBookDetails(); 
		for(UserBookDetails us:li) { 
			if(us.getBookIsbn().equals(bookIsbn)) { 
				u=new UserBookDetails(us.getUserId(),us.getBookIsbn(),us.getIssueDate(),us.getFine()); 
			} 
		}
		return u;
}
	@SuppressWarnings("unchecked") 
	public List<UserBookDetails> getAllUserBookDetails(){ 
		List<UserBookDetails> al=new ArrayList<UserBookDetails>(); 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		al=s.createQuery("from userBookDetails").list(); 
		s.close(); 
		 
		return al; 
	} 
	 
	public boolean insertUserBookDetails(UserBookDetails u) { 
		System.out.println("Inside the DAO Class - Insert Method"); 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		 
		s.persist(u); 
		t1.commit(); 
		s.close(); 
	 
		return false; 
	} 


	
}

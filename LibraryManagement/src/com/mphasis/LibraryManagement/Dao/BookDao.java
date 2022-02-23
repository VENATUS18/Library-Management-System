package com.mphasis.LibraryManagement.Dao;
import java.util.ArrayList; 
import java.util.List; 


import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration; 
//import org.springframework.stereotype.Repository; 
import org.springframework.stereotype.Repository;

import com.mphasis.LibraryManagement.model.Book; 


@Repository 
public class BookDao { 


	 
	SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
	 
	public boolean updateBook(Book b) { 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		s.merge(b); 
		t1.commit(); 
		s.close(); 
		return false; 
	} 
	 
	public Book getById(String bookIsbn) { 
		Book b=null; 
		List<Book> li=getAllBooks(); 
		for(Book bk:li) { 
			if(bk.getBookIsbn().equals(bookIsbn)) { 
				b=new Book(bk.getBookIsbn(),bk.getBookName(),bk.getAuthorName(),bk.getEdition(),bk.getNumberOfCopies(),bk.getDescription()); 
			} 
		} 
		/*Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		//e=s.get(Exam.class, examId); 
		e=(Exam) s.byId(examId); 
		s.close();*/ 
		return b; 
	} 
	 
	@SuppressWarnings("unchecked") 
	public List<Book> getAllBooks(){ 
		List<Book> al=new ArrayList<Book>(); 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		al=s.createQuery("from Book").list(); 
		s.close(); 
		 
		return al; 
	} 
	 
	public boolean insertBook(Book b) { 
		System.out.println("Inside the DAO Class - Insert Method"); 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		 
		s.persist(b); 
		t1.commit(); 
		s.close(); 
	 
		return false; 
	}

	
} 





package com.mphasis.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import com.mphasis.LibraryManagement.model.Issue;
@Repository 
public class IssueDao{
SessionFactory sf=new Configuration().configure().buildSessionFactory(); 

public boolean updateIssue(Issue i) { 
	Session s=sf.openSession(); 
	Transaction t1=s.beginTransaction(); 
	s.merge(i); 
	t1.commit(); 
	s.close(); 
	return false; 
} 
 
public Issue getById(int userId) { 
	/*Issue i=null; 
	List<Issue> li=getAllIssues(); 
	for(Issue ik:li) { 
		if(ik.getUserId()==(userId)) { 
			i=new Issue(ik.getUserId(),ik.getBookISBN(),ik.getIssueDate(),ik.getTransactionId()); 
		} */
	
	Issue i=null; 
	Session s=sf.openSession(); 
	Transaction t1=s.beginTransaction(); 
	i=s.get(Issue.class, userId); 
 
	s.close();

	return i; 
} 
 


@SuppressWarnings("unchecked") 
public List<Issue> getAllIssues(){ 
	List<Issue> al=new ArrayList<Issue>(); 
	Session s=sf.openSession(); 
	Transaction t1=s.beginTransaction(); 
	al=s.createQuery("from Issue").list();
	/*String hql="SELECT * FROM ISSUE WHERE userId=2368097";
	Query query=Session.createQuery(hql);
	List<Issue> results=query.list();*/
	s.close(); 
	 
	return al; 
} 
 
public boolean insertIssue(Issue i) { 
	System.out.println("Inside the DAO Class - Insert Method"); 
	Session s=sf.openSession(); 
	Transaction t1=s.beginTransaction(); 
	 
	s.persist(i); 
	t1.commit(); 
	s.close(); 
 
	return false; 
}

/*public List count()
{
//String query=("select *"+"from Issue");
preparedStatement ps=con.preparedStatement("select *"+"from Issue");
//ResultSet rs=ps.executeQuery("select *"+"from Issue");
List<Issue> als=new ArrayList<>();
while(ps.next()) {
Issue al=new Issue();
al.setBookISBN(ps.getInt("BookISBN"));
al.setIssueDate(ps.getString("IssueDate"));
al.setTransactionId(ps.getInt("TransationId"));
al.setUserId(ps.getInt("UserId"));
als.add(al);
}
return als;	
}*/
/*public List<Issue> getAllIssuesById(int i) {
	List<Issue> al=getAllIssues();
	List<Issue> li=new ArrayList<Issue>();
	for(Issue m:al)
	{
		if(i==m.getUserId()) {
			li.add(new Issue(m.getUserId(),m.getBookISBN(),m.getIssueDate(),m.getTransactionId()));
		}
	}
	
	
	
	return li;
	
}*/
	
}









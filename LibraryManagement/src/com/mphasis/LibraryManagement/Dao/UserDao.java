package com.mphasis.LibraryManagement.Dao;

import java.util.ArrayList; 
import java.util.List; 


import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration; 
import org.springframework.stereotype.Repository; 


import com.mphasis.LibraryManagement.model.User; 


@Repository 
public class UserDao { 


	SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
	 
	@SuppressWarnings({ "unchecked", "deprecation" }) 
	public List<User> getAllUsers(){ 
		List<User> li=new ArrayList<User>(); 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
	//	li=s.createQuery("from User").list();
	//	Query q=s.createQuery("from User");
		
		/*Session session = entityManagerFactory.openSession();
		Query query = session.createQuery();*/
		
		li=s.createCriteria(User.class).list();
		s.close(); 
	//	sf.close();
		 
		return li; 
	} 
	public User getById(int id) { 
		User u=null; 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		u=s.get(User.class, id); 
		s.close(); 
		return u; 
	} 
	public boolean insertUser(User u) { 
		Session s=sf.openSession(); 
		Transaction t1=s.beginTransaction(); 
		 
		s.persist(u); 
		t1.commit();
		s.close();
		//sf.close();
		return false; 

}
}

package com.mphasis.LibraryManagement.Dao;
	import java.util.ArrayList; 
	import java.util.List; 


	import org.hibernate.Session; 
	import org.hibernate.SessionFactory; 
	import org.hibernate.Transaction; 
	import org.hibernate.cfg.Configuration; 
	//import org.springframework.stereotype.Repository; 
	import org.springframework.stereotype.Repository;

	import com.mphasis.LibraryManagement.model.Journal; 


	@Repository 



	public class JournalDao {
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		 
		public boolean updateJournals(Journal j) { 
			Session s=sf.openSession(); 
			Transaction t1=s.beginTransaction(); 
			s.merge(j); 
			t1.commit(); 
			s.close(); 
			return false; 
		} 
		 
		public Journal getById(String jIsbn) { 
			Journal j=null; 
			List<Journal> li=getAllJournals(); 
			for(Journal jn:li) { 
				if(jn.getjIsbn().equals(jIsbn)) { 
					j=new Journal(jn.getjIsbn(),jn.getjName(),jn.getJauthorName(),jn.getJedition(),jn.getJnumberOfCopies(),jn.getJdescription()); 
				} 
			} 
			/*Session s=sf.openSession(); 
			Transaction t1=s.beginTransaction(); 
			//e=s.get(Exam.class, examId); 
			e=(Exam) s.byId(examId); 
			s.close();*/ 
			return j; 
		} 
		 
		@SuppressWarnings("unchecked") 
		public List<Journal> getAllJournals(){ 
			List<Journal> al=new ArrayList<Journal>(); 
			Session s=sf.openSession(); 
			Transaction t1=s.beginTransaction(); 
			al=s.createQuery("from Journal").list(); 
			s.close(); 
			 
			return al; 
		} 
		 
		public boolean insertJournal(Journal j) { 
			System.out.println("Inside the DAO Class - Insert Method"); 
			Session s=sf.openSession(); 
			Transaction t1=s.beginTransaction(); 
			 
			s.persist(j); 
			t1.commit(); 
			s.close(); 
		 
			return false; 
		} 
	} 







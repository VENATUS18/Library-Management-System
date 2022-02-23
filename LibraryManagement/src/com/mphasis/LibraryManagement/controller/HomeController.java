package com.mphasis.LibraryManagement.controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
//import javax.transaction.Transaction;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.LibraryManagement.Dao.BookDao;
import com.mphasis.LibraryManagement.Dao.IssueDao;
import com.mphasis.LibraryManagement.Dao.UserDao;
import com.mphasis.LibraryManagement.model.Book;
import com.mphasis.LibraryManagement.model.User;
import com.mphasis.LibraryManagement.model.Issue;
import com.mphasis.LibraryManagement.model.UserBookDetails;
import com.mphasis.LibraryManagement.Dao.JournalDao;
import com.mphasis.LibraryManagement.Dao.UserBookDetailsDao;
import com.mphasis.LibraryManagement.model.Journal;

@Controller
public class HomeController {
	
	@Autowired
	BookDao bd;
	@Autowired
	UserDao ud;
	@Autowired
	JournalDao jd;
	@Autowired
	UserBookDetailsDao udb;
	@Autowired
	IssueDao id;
	
	private ServletRequest req;
	
	
	@RequestMapping("/")
	public ModelAndView firstMethod() {
		return new ModelAndView("index");
	}
	
	 
		@RequestMapping("/home") 
		public ModelAndView homeMethod() { 
			return new ModelAndView("home"); 
		} 
	
	@RequestMapping("/addbook")
	public ModelAndView secondMethod() {
		return new ModelAndView("addBooks");
	}
	
	@RequestMapping("/addbookdetails")
	public ModelAndView thirdMethod(HttpServletRequest req) {
		ModelAndView mv=null;
		String bisbn=req.getParameter("bisbn");
		String bname=req.getParameter("bname"); 
		String author=req.getParameter("author"); 
		String edition=req.getParameter("edition"); 
		int noc=Integer.parseInt(req.getParameter("bnoc")); 
		String des=req.getParameter("bdes"); 
		Book b=new Book(bisbn,bname,author,edition,noc,des); 
		 
		//WebApplicationContext wb=WebApplicationContextUtils.getWebApplicationContext(Book.class, "bk"); 
		boolean b1=bd.insertBook(b); 
		 
		if(b1==false) { 
			mv=new ModelAndView("success"); 
			//String value="Sucessfully Inserted"; 
			mv.addObject("value","Sucessfully Inserted"); 
		} 
		else { 
			mv=new ModelAndView("error"); 
		} 
		return mv; 
	
	}
	
	/*@RequestMapping("/issue")
	public ModelAndView issueMethod(HttpServletRequest req) {
		ModelAndView mv=null; 
		String bname=req.getParameter("bookname"); 
		int bisbn=Integer.parseInt(req.getParameter("bookisbn")); 
		int userid=Integer.parseInt(req.getParameter("userid")); 
		String issuedate=req.getParameter("issuedate");
		String duedate=req.getParameter("duedate");
		Issue i=new Issue(bname,bisbn,userid,issuedate,duedate); 
		boolean b1=id.issue(i); 
		if(b1==true) { 
			mv=new ModelAndView("error"); 
		} 
		else { 
			mv=new ModelAndView("success"); 
		} 
		 
		return mv; 
	}*/
	
	
	
	@RequestMapping("/addjournals")
	public ModelAndView journalMethod() {
		return new ModelAndView("addjournals");
	}
	
	@RequestMapping("/addjournaldetails")
	public ModelAndView journalDetailsMethod(HttpServletRequest req) {
		ModelAndView mv=null;
		String jisbn=req.getParameter("jisbn");
		String jname=req.getParameter("jname"); 
		String jauthor=req.getParameter("jauthor"); 
		String jedition=req.getParameter("jedition"); 
		int jnoc=Integer.parseInt(req.getParameter("jnoc")); 
		String jdes=req.getParameter("jdes"); 
		Journal j=new Journal(jisbn,jname,jauthor,jedition,jnoc,jdes); 
		 
		//WebApplicationContext wb=WebApplicationContextUtils.getWebApplicationContext(Book.class, "bk"); 
		boolean b1=jd.insertJournal(j); 
		 
		if(b1==false) { 
			mv=new ModelAndView("success"); 
			//String value="Sucessfully Inserted"; 
			mv.addObject("value","Sucessfully Inserted"); 
		} 
		else { 
			mv=new ModelAndView("error"); 
		} 
		return mv; 
	
	}
	
	/*@RequestMapping("/viewuserbooks") 
	public ModelAndView viewAllUserBooks() { 
		ModelAndView mv=new ModelAndView("viewuserbooks"); 
		List<Book> al=bd.getAllBooks(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	*/
	@RequestMapping("/viewFacultyBooks") 
	public ModelAndView viewAllFacultyBooks() { 
		ModelAndView mv=new ModelAndView("viewFacultyBooks"); 
		List<Book> al=bd.getAllBooks(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 

	@RequestMapping("/viewAllBooks") 
	public ModelAndView viewBooks() { 
		ModelAndView mv=new ModelAndView("viewAllBooks"); 
		List<Book> al=bd.getAllBooks(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	@RequestMapping("/viewbooks") 
	public ModelAndView viewAllBooks() { 
		ModelAndView mv=new ModelAndView("viewbooks"); 
		List<Book> al=bd.getAllBooks(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	
	@RequestMapping("/viewUsers") 
	public ModelAndView viewAllUsers() { 
		ModelAndView mv=new ModelAndView("viewUsers"); 
		List<User> al=ud.getAllUsers(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	
	@RequestMapping("/viewjournals") 
	public ModelAndView viewAllJournals() { 
		ModelAndView mv=new ModelAndView("viewjournals"); 
		List<Journal> al=jd.getAllJournals(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	
	@RequestMapping("/viewadminjournals") 
	public ModelAndView viewadminJournals() { 
		ModelAndView mv=new ModelAndView("viewadminjournals"); 
		List<Journal> al=jd.getAllJournals(); 
		System.out.println("Inside Controller"+al); 
		mv.addObject("al", al); 
		return mv; 
	} 
	@RequestMapping("/editjournal") 
	public ModelAndView editJournalIssue(HttpServletRequest request)throws Exception { 
		ModelAndView mv=null; 
		String id=request.getParameter("id");
		System.out.println(id);
		Journal j=jd.getById(id); 
		 
		System.out.println("Inside Controller: "+j); 
		mv=new ModelAndView("editjournal"); 
		mv.addObject("journal",j); 
		return mv; 
	} 
	 
	@RequestMapping("/updatejournals") 
	public ModelAndView updateJournalIssue(HttpServletRequest request)throws Exception { 
	 
		ModelAndView mv=null; 
		String jisbn=request.getParameter("jisbn"); 
		String jname=request.getParameter("jname"); 
		String jauthor=request.getParameter("jauthor");
		String jedition=request.getParameter("jedition");
		int jnoc=Integer.parseInt(request.getParameter("jnoc")); 
	    String jdesc=request.getParameter("jdes"); 
		Journal j=new Journal(jisbn,jname,jauthor,jedition,jnoc,jdesc); 
		boolean b1=jd.updateJournals(j); 
		if(b1==true) { 
			mv=new ModelAndView("error"); 
		} 
		else { 
			mv=new ModelAndView("success"); 
		} 
		 
		return mv; 
	}
	@RequestMapping("/editbook") 
	public ModelAndView editIssue(HttpServletRequest request)throws Exception { 
		ModelAndView mv=null; 
		String id=request.getParameter("id");
		System.out.println(id);
		Book b=bd.getById(id); 
		 
		System.out.println("Inside Controller: "+b); 
		mv=new ModelAndView("editbook"); 
		mv.addObject("book",b); 
		return mv; 
	} 
	
@RequestMapping("/searchById")
public ModelAndView IdSearch(HttpServletRequest request)throws Exception { 
	ModelAndView mv=null; 
	String id=request.getParameter("bid");
	System.out.println(id);
	Book b=bd.getById(id); 
	 
	System.out.println("Inside Controller: "+b); 
	mv=new ModelAndView("searchView"); 
	mv.addObject("book",b); 
	return mv; 
} 
	 
	@RequestMapping("/updatebook") 
	public ModelAndView updateIssue(HttpServletRequest request)throws Exception { 
	 
		ModelAndView mv=null; 
		String bisbn=request.getParameter("bookisbn"); 
		String bname=request.getParameter("bookname"); 
		String author=request.getParameter("author");
		String edition=request.getParameter("edition");
		int noc=Integer.parseInt(request.getParameter("booknoc")); 
	    String desc=request.getParameter("bdes"); 
		Book b=new Book(bisbn,bname,author,edition,noc,desc); 
		boolean b1=bd.updateBook(b); 
		if(b1==true) { 
			mv=new ModelAndView("error"); 
		} 
		else { 
			mv=new ModelAndView("success"); 
		} 
		 
		return mv; 
	}
	
	@RequestMapping("/login") 
	public ModelAndView loginMethod() { 
		return new ModelAndView("login"); 
	} 
	
	@RequestMapping("/register") 
	public ModelAndView registerMethod() { 
		return new ModelAndView("register"); 
	}
	@RequestMapping("/search") 
	public ModelAndView searchMethod() { 
		return new ModelAndView("search"); 
	}
	
	@RequestMapping(value="adduser", method = RequestMethod.POST) 
	public ModelAndView addUser(HttpServletRequest req)
	{ 
		ModelAndView mv=null; 
		int userId=Integer.parseInt(req.getParameter("userId")); 
		String  uname= req.getParameter("uname"); 
		String password= req.getParameter("password"); 
		String emailId= req.getParameter("emailId"); 
		String mobile= req.getParameter("mobile"); 
		int n=(req.getParameter("userId")).length();
		String userType = null;
		if(n==8)
		{
			 userType="Student";
		}
		else if(n==7)
		{
			userType="Faculty";
		}
		else if(n==9)
		{
			userType="Admin";
		}
		
		
		User u=new User(userId,uname,password,emailId,mobile,userType); 
		boolean b1=ud.insertUser(u); 
		if(b1==true) { 
		 mv= new ModelAndView("success"); 
		 } 
		 else { 
			 mv=new ModelAndView("error"); 
		 } 
		 
		return mv; 
	} 
	@RequestMapping(value="checkuser", method = RequestMethod.POST) 
	public ModelAndView checkUser(HttpServletRequest req) throws Exception 
	{ 
		ModelAndView mv=null; 
		 
		int id=Integer.parseInt(req.getParameter("uname")); 
		String password=req.getParameter("password"); 
		 
		//List<User> li=ud.getAllUsers();
		User u=ud.getById(id);
		
	    if(u.equals(null)) {
	    	mv=new ModelAndView("error");
	    }
	    else {
		System.out.println(u);
		int n=(req.getParameter("uname")).length();
		
		//int flag=0; 
		if ((id==u.getUserId())) {
		
			if((id==u.getUserId())&&(password.equals(u.getPassword()))) { 
				
				//flag=1;
				if(n==9) {
				mv= new ModelAndView("adminHeader"); 
				mv.addObject("name", id);
		} 
				else if(n==7) {
					mv= new ModelAndView("facultyHeader"); 
					mv.addObject("name", id);
				}

				else if(n==8) {
					mv= new ModelAndView("studentHeader"); 
					mv.addObject("name", id);
				}
				//return mv;	
			}
		}
			else
			{

				mv=new  ModelAndView("error");
			
			}
	 
	    }
			return mv;
	}
	
	@RequestMapping("/entryDetail")
	public ModelAndView UserEntryMethod() {
		return new ModelAndView("entryDetails");
	}
	
	@RequestMapping("/userBookDetails")
	public ModelAndView UserBookDetailsMethod() {
		return new ModelAndView("userBookDetails");
	}
	/*@RequestMapping("/adduserbookdetails")
	public ModelAndView journalDetailsMethod(HttpServletRequest req) {
		ModelAndView mv=null;
		String jisbn=req.getParameter("jisbn");
		String jname=req.getParameter("jname"); 
		String jauthor=req.getParameter("jauthor"); 
		String jedition=req.getParameter("jedition"); 
		int jnoc=Integer.parseInt(req.getParameter("jnoc")); 
		String jdes=req.getParameter("jdes"); 
		Journal j=new Journal(jisbn,jname,jauthor,jedition,jnoc,jdes); 
		 
		//WebApplicationContext wb=WebApplicationContextUtils.getWebApplicationContext(Book.class, "bk"); 
		boolean b1=jd.insertJournal(j); 
		 
		if(b1==false) { 
			mv=new ModelAndView("success"); 
			//String value="Sucessfully Inserted"; 
			mv.addObject("value","Sucessfully Inserted"); 
		} 
		else { 
			mv=new ModelAndView("error"); 
		} 
		return mv; 
	
	}*/
	
	@RequestMapping("/issue") 
	public ModelAndView editIssue1(HttpServletRequest request)throws Exception { 
		ModelAndView mv=null; 
		String id=request.getParameter("id");
		System.out.println(id);
		Book b=bd.getById(id); 
		List<Issue> ilist=this.id.getAllIssues();
		
		
		List<User> luser=ud.getAllUsers();
		System.out.println("Inside issue Controller: "+b); 
		mv=new ModelAndView("issue"); 
		mv.addObject("users", luser);
		mv.addObject("book",b); 
		return mv; 
	} 
	
	/*@RequestMapping("/viewuserbook") 
	public ModelAndView viewUserBook(HttpServletRequest request)throws Exception { 
		ModelAndView mv=null; 
		
		 
		int uid=Integer.parseInt(req.getParameter("uid")); 
		int bid=Integer.parseInt(req.getParameter("bookisbn")); 
		System.out.println(""+bid);
		Issue i=id.getById("bookisbn");
		 
		System.out.println("Inside Controller: "+b); 
		mv=new ModelAndView("viewuserbooks"); 
		mv.addObject("i",b); 
		
		
		
		
		mv=new ModelAndView("viewuserbooks"); 
		
		return mv; 
		
	} */
	
	@RequestMapping("/insertissue")
	public ModelAndView insertissueMethod(HttpServletRequest req) {
		ModelAndView mv=null;

		int userid=Integer.parseInt(req.getParameter("uid"));
		int bisbn=Integer.parseInt(req.getParameter("bookisbn"));
		String issuedate=req.getParameter("issuedate");  
		int transactionid=Integer.parseInt(req.getParameter("transid")); 
		Issue i=new Issue(userid,bisbn,issuedate,transactionid); 
		 
		//WebApplicationContext wb=WebApplicationContextUtils.getWebApplicationContext(Book.class, "bk"); 
		boolean b1=id.insertIssue(i); 
		 
		if(b1==false) { 
			mv=new ModelAndView("success"); 
			String value="Sucessfully Inserted";
			/*int uid=Integer.parseInt(req.getParameter("uid"));
			System.out.println(uid);
			Issue r=id.getById(uid); 
			List<Issue> al=id.getAllIssues(); 
			List<Issue> booklistbyuser = null;
			int i1=0;
			for(Issue il:al) {
				System.out.println(uid);
				System.out.println(il.getUserId());
				if (uid==il.getUserId()) { 
					System.out.println("Inside add");
					booklistbyuser.addAll((Collection<? extends Issue>) al.get(i1));
					
					
				}
				i1++;
			}
			System.out.println("Inside Controller: "+r); 
			System.out.println("Inside Controller: "+booklistbyuser); 
			mv=new ModelAndView("viewuserbooks"); 
			mv.addObject("issue",booklistbyuser);*/
			
			
		}
		else { 
			mv=new ModelAndView("error"); 
		} 
		return mv; 
	
	}
	
	//@SuppressWarnings("null")
	@RequestMapping("/viewuserbookdetails")
	public ModelAndView userbookdetailsearch(HttpServletRequest request)throws Exception { 
		ModelAndView mv=null; 
		int uid=Integer.parseInt(request.getParameter("userId"));
		//System.out.println(uid);
		//System.out.println("Inside Controller: "); 
		List<Issue> al=id.getAllIssues();
		List<Issue> booklistbyuser = null;
		String s="";
		List<String> blbusers=new ArrayList<String>();
		for(Issue il:al) {
			//System.out.println(uid);
			//System.out.println(il.getUserId());
			if (uid==(il.getUserId())) { 
				System.out.println("Inside add");
				/*String s1="";
				s1=s1.valueOf(uid);
				String s2="";
				s2=s2.valueOf(il.getBookISBN());
				String s3="";
				s3=s3.valueOf(il.getIssueDate());
				String s4="";
				s4=s4.valueOf(il.getTransactionId());
				s=s1+"#"+s2+"#"+s3+"#"+s4;
				blbusers.add(s);*/
				
				booklistbyuser.add(new Issue(il.getUserId(),il.getBookISBN(),il.getIssueDate(),il.getTransactionId()));
			
				
			}
		}
		System.out.println(blbusers);
		mv=new ModelAndView("userBookDetails"); 
		//mv.addObject("issue",blbusers); 
	
		mv.addObject("issue", booklistbyuser);
		/*for (String st:blbusers) {
			String [] st1 = st.split("#");
			System.out.println(st1[0]);
		}*/
		return mv; 
	} 
	
	
	
}

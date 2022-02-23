package com.mphasis.LibraryManagement.model;
import java.io.Serializable;

import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table; 


@Entity 
@Table(name="myUsers")
public class User implements Serializable{ 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	private int userId; 
	private String uname; 
	private String password; 
	private String emailId; 
	private String mobile; 
	private String userType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
		
		
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User(int userId, String uname, String password, String emailId, String mobile,String userType) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.password = password;
		this.emailId = emailId;
		this.mobile = mobile;
		this.userType = userType;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User userId=" + userId + ", uname=" + uname + ", password=" + password + ", emailId=" + emailId
				+ ", mobile=" + mobile + ", userType=" + userType ;
	} 
	

}

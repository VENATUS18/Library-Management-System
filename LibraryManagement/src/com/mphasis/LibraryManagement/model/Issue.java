package com.mphasis.LibraryManagement.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Issue")
public class Issue {
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;
private int bookISBN;
private String issueDate;
@Id
private int transactionId;

public Issue(int userId, int bookISBN, String issueDate, int transactionId) {
	super();
	this.userId = userId;
	this.bookISBN = bookISBN;
	this.issueDate = issueDate;
	this.transactionId = transactionId;
}
public Issue() {
	super();
	// TODO Auto-generated constructor stub
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getBookISBN() {
	return bookISBN;
}
public void setBookISBN(int bookISBN) {
	this.bookISBN = bookISBN;
}
public String getIssueDate() {
	return issueDate;
}
public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
@Override
public String toString() {
	return "Issue userId=" + userId + ", bookISBN=" + bookISBN + ", issueDate=" + issueDate + ", transactionId="
			+ transactionId;
}

/*public String toString() {
	return userId +  " " + bookISBN + " " + issueDate +  " " + transactionId;
}*/

}
package com.mphasis.LibraryManagement.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
@Entity
//@Cache(usage = )
public class UserBookDetails {
	@Id 
private int userId;
private String bookIsbn;
private LocalDate issueDate;
private long fine;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getBookIsbn() {
	return bookIsbn;
}
public void setBookIsbn(String bookIsbn) {
	this.bookIsbn = bookIsbn;
}
public LocalDate getIssueDate() {
	return issueDate;
}
public void setIssueDate(LocalDate issueDate) {
	this.issueDate = issueDate;
}
public long getFine() {
	return fine;
}
public void setFine(long fine) {
	this.fine = fine;
}
public UserBookDetails(int userId, String bookIsbn, LocalDate issueDate, long fine) {
	super();
	this.userId = userId;
	this.bookIsbn = bookIsbn;
	this.issueDate = issueDate;
	this.fine = fine;
}
public UserBookDetails() {
	super();
	// TODO Auto-generated constructor stub
}

}

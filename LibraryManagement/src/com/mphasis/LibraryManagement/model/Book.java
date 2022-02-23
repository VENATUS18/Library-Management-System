package com.mphasis.LibraryManagement.model;


	import javax.persistence.Entity;
	import javax.persistence.Id; 
	
@Entity 
public class Book {

		@Id 
		private String bookIsbn; 
		private String bookName; 
		private String authorName;
		private String edition;
		private int numberOfCopies; 
		private String description;
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Book(String bookIsbn, String bookName, String authorName, String edition, int numberOfCopies,
				String description) {
			super();
			this.bookIsbn = bookIsbn;
			this.bookName = bookName;
			this.authorName = authorName;
			this.edition = edition;
			this.numberOfCopies = numberOfCopies;
			this.description = description;
		}
		public String getBookIsbn() {
			return bookIsbn;
		}
		public void setBookIsbn(String bookIsbn) {
			this.bookIsbn = bookIsbn;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public String getEdition() {
			return edition;
		}
		public void setEdition(String edition) {
			this.edition = edition;
		}
		public int getNumberOfCopies() {
			return numberOfCopies;
		}
		public void setNumberOfCopies(int numberOfCopies) {
			this.numberOfCopies = numberOfCopies;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		} 
	
		
		
		
		
	}
		


package com.mphasis.LibraryManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journal {
	@Id
	private String jIsbn; 
	private String jName; 
	private String jauthorName;
	private String jedition;
	private int jnumberOfCopies; 
	private String jdescription;
	public String getjIsbn() {
		return jIsbn;
	}
	public void setjIsbn(String jIsbn) {
		this.jIsbn = jIsbn;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	public String getJauthorName() {
		return jauthorName;
	}
	public void setJauthorName(String jauthorName) {
		this.jauthorName = jauthorName;
	}
	public String getJedition() {
		return jedition;
	}
	public void setJedition(String jedition) {
		this.jedition = jedition;
	}
	public int getJnumberOfCopies() {
		return jnumberOfCopies;
	}
	public void setJnumberOfCopies(int jnumberOfCopies) {
		this.jnumberOfCopies = jnumberOfCopies;
	}
	public String getJdescription() {
		return jdescription;
	}
	public void setJdescription(String jdescription) {
		this.jdescription = jdescription;
	}
	public Journal(String jIsbn, String jName, String jauthorName, String jedition, int jnumberOfCopies,
			String jdescription) {
		super();
		this.jIsbn = jIsbn;
		this.jName = jName;
		this.jauthorName = jauthorName;
		this.jedition = jedition;
		this.jnumberOfCopies = jnumberOfCopies;
		this.jdescription = jdescription;
	}
	public Journal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

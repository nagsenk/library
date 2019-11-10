package com.telusko.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Issue")

public class Issue {

	private Integer MemId;
	
	private Integer isbn;
	private
	 long millis; 
	java.sql.Date issuedate =    new java.sql.Date(millis);  


	public Issue() {
		super();
	}

	public Integer getMemId() {
		return MemId;
	}
	public void setMemId(Integer memId) {
		MemId = memId;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}


	
}

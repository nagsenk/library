package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
	private int employeeID;
	public String employee;
	private int memberid;
	private int bookid;
	private
	long millis=System.currentTimeMillis();  
	java.sql.Date date =    new java.sql.Date(millis);
	private String Action;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public long getMillis() {
		return millis;
	}
	public void setMillis(long millis) {
		this.millis = millis;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

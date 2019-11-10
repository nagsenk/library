package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	
private int empid;
	private String firstname;
	private String lastname;
	private String usname;
	private String address;
	private
	 long millis; 
	java.sql.Date joindate =    new java.sql.Date(millis);  
public Employee(int empid) {
		super();
		this.empid = empid;
	}
public java.sql.Date getJoindate() {
	return joindate;
}
public void setJoindate(java.sql.Date joindate) {
	this.joindate = joindate;
}
public Employee() {
		super();
		
	}
public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}

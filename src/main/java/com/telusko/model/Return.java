package com.telusko.model;

import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Returninfo")
public class Return {
	
private  int mID;

private  int isbn;
private
long millis=System.currentTimeMillis();  
java.sql.Date returndate =    new java.sql.Date(millis);  
public Return() {
	super();
}
public Return(int isbn)
{
	super();
	this.isbn=isbn;
}

public int getmID() {
	return mID;
}
public void setmID(int mID) {
	this.mID = mID;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public Date getReturndate() {
	return returndate;
}
public void setReturndate(Date returndate) {
	this.returndate = returndate;
}


}

package com.telusko.model;

import java.time.LocalDate;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Reserve {

	private  int MID;
    
	private  String title;
     private 
     long millis=System.currentTimeMillis();  
    Date reservedate =    new Date(millis);
     public Reserve() {
    		super();
    	}
     public Reserve(int MID)
     {
    	 this.MID=MID;
     }
	public int getMID() {
		return MID;
	}
	public void setMID(int mID) {
		MID = mID;
	}
	
	public Reserve(int mID, String title) {
		super();
		this.MID = mID;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReservedate() {
		return reservedate;
	}
	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}
	
}

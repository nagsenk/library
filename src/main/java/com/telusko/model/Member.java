package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String address;
	
	private String memusername;
	private Integer count;
	public Member() {
		super();
	}
	
	public Member (int id) {
		super();
		this.id = id;
	}

	public Member (String username) {
		super();
		this.memusername = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemusername() {
		return memusername;
	}
	public void setMemusername(String memusername) {
		this.memusername = memusername;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@OneToOne(mappedBy = "members")
    private Authenticate authenticate;
	
}

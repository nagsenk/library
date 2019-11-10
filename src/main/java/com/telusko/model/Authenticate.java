package com.telusko.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="authentication")
public class Authenticate {
@Id

private String username;

private String password;
private String role;

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Authenticate()
{
	super();
}
public Authenticate (String username) {
	super();
	this.username = username;
}
public String getUsername() {
	return username;
}
public void setUsername(String  username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "memusername", referencedColumnName = "username")
private Member member;

}

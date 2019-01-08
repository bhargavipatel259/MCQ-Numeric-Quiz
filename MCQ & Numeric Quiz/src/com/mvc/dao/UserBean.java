package com.mvc.dao;

public class UserBean {
	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String role;
		
	public int getUserid() {
	return userid;
	}
	public void setUserid(int userid) {
	this.userid = userid;
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
	public String getUsername() {
	return username;
	}
	public void setUsername(String username) {
	this.username = username;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public String getRole() {
	return role;
	}
	public void setRole(String role) {
	this.role = role;
	}
}

package com.example.user.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	public int id;
	public String Username;
	public long ContactNumber;
	public String emailId;
	public User(){
		
	}
	
	public User(int id, String username, long contactNumber, String emailId) {
		super();
		this.id = id;
		Username = username;
		ContactNumber = contactNumber;
		this.emailId = emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", ContactNumber=" + ContactNumber + ", emailId=" + emailId
				+ "]";
	}
	
	

}

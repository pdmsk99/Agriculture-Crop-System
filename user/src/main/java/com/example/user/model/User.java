package com.example.user.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User implements Serializable{
	

	private static final long serialVersionUID = 1L;

@Id
	private String emailId;
	
	private long mobileNo;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String homeAddress;
	
	private String district;
	
	private String city;
	
	private String state;
	
	private int pincode;
	
	private String role;
	
	

	public User() {
		
	}

	public User(String emailId, long mobileNo, String firstName, String lastName, String password,String homeAddress,
			    String district,String city, String state,int pincode, String role) {
		
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.homeAddress = homeAddress;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;	
		this.role = role;

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long string) {
		this.mobileNo = string;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int string) {
		this.pincode = string;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
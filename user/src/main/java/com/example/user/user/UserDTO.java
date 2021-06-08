package com.example.user.user;

import java.io.Serializable;
import com.mongodb.lang.NonNull;


public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String emailId;
	
	@NonNull
	private long mobileNo;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
	
	@NonNull
	private String password;
	
	@NonNull
    private String homeAddress;
	
	@NonNull
	private String district;
	
	@NonNull
	private String city;
	
	@NonNull
	private String state;
	
	@NonNull
	private int pincode;
	
	@NonNull
	private String role;
	
	

	

	public UserDTO() {
		
	}

	public UserDTO(String emailId, long mobileNo, String firstName, String lastName, String password,String homeAddress,
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

	public void setPincode(int pincode) {
		this.pincode = pincode;
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

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
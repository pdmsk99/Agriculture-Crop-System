package com.example.address;

import java.io.Serializable;


public class AddressDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int addressId;
		
	private String country;
	
	
	private String state;
	
	
	private String district;
	
	
	private String pinCode;

	public AddressDTO() {
		
	}


	public AddressDTO(int addressId, String country, String state, String district, String pinCode) {
		super();
		this.addressId = addressId;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pinCode = pinCode;
	}



	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}



	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", country=" + country + ", state=" + state + ", district="
				+ district + ", pinCode=" + pinCode + "]";
	}

}
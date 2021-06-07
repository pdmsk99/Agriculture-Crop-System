package com.example.address.address;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class address {
	
	@Id
	public String id;
	public String hello;
	public address() {
		
	}
		
	public address(String id, String hello) {
		super();
		this.id = id;
		this.hello = hello;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}

	@Override
	public String toString() {
		return "address [id=" + id + ", hello=" + hello + "]";
	}

	
	
}

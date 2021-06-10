package com.example.product.product;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	

	
	@Id
@NonNull
	private String productName;

@NonNull
	private int price;
	
@NonNull
	private String description;
	
@NonNull
	private int quantity;
	

//	private byte[] image;
	
	public Product() {
		
	}
	 
	public Product(String productName, int price, String description, int quantity) {
		
		
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
//		this.image = image;
	}




	public String getproductName() {
		return productName;
	}


	public void setproductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getBrand() {
		return quantity;
	}


	public void setBrand(int quantity) {
		this.quantity = quantity;
	}


//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
	
	@Override
	public String toString() {
		return "Product [ productName=" + productName + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}

	


	

	
	
	
}
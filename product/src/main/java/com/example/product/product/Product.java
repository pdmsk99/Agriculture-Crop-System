package com.example.product.product;

import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;


@Document
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	

	
@Id
//@NonNull
	private String name;

//@NonNull
	private String price;
	
//@NonNull
	private String description;
	
@NonNull
	private String quantity;
	

//	private byte[] image;
	
	public Product() {
		
	}
	 
	public Product(String name, String price, String description, String quantity) {
			
		
	
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		
	}







	

//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", quantity=" + quantity
				+ "]";
	}


	
	
	
}
package com.example.product.dto;




import java.io.Serializable;

import org.springframework.lang.NonNull;





public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	@NonNull
	private String name;
	
	@NonNull
	private String price;
	
	@NonNull
	private String description;
	
	@NonNull
	private String quantity;
	
//	private byte[] image; 
	
	
	
	public ProductDTO() {
		
	}
	 
	public ProductDTO(String name, String price, String description, String quantity) {
			
		
		
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
//		this.image = image;
	}



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
	
//	public byte[] getImage() {
//	return image;
//}
//
//public void setImage(byte[] image) {
//	this.image = image;
//}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", description=" + description + ", quantity="
				+ quantity + "]";
	}


	
}
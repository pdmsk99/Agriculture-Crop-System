package com.example.product.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	public int id;
	public String ProductName;
	public int ProductId;
	public String FarmerName;
	public Product() {
		
	}
	
	public Product(int id, String productName, int productId, String farmerName) {
		super();
		this.id = id;
		ProductName = productName;
		ProductId = productId;
		FarmerName = farmerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getFarmerName() {
		return FarmerName;
	}

	public void setFarmerName(String farmerName) {
		FarmerName = farmerName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", ProductName=" + ProductName + ", ProductId=" + ProductId + ", FarmerName="
				+ FarmerName + "]";
	}
	
	
	
	

}

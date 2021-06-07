package com.example.order.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orders {
	
	@Id
	public int id;
	public String OrderName;
	public int price;
	public String Discription;
	
	public Orders(){
		
	}
	
	public Orders(int id, String orderName, int price, String discription) {
		super();
		this.id = id;
		OrderName = orderName;
		this.price = price;
		Discription = discription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", OrderName=" + OrderName + ", price=" + price + ", Discription=" + Discription
				+ "]";
	}
	
	

}

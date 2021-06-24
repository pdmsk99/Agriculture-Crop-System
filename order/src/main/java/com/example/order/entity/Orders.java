package com.example.order.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document
public class Orders {

	@Id
	private Integer orderId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	private Integer amount;

	private String products;

	private String user;

	public Orders() {

	}

	public Orders(Integer orderId, LocalDate date, Integer amount, String products, String user) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.amount = amount;
		this.products = products;
		this.user = user;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer integer) {
		this.orderId = integer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", date=" + date + ", amount=" + amount + ", products=" + products
				+ ", user=" + user + "]";
	}

}

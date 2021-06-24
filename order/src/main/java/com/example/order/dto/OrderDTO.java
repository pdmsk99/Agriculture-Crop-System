package com.example.order.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.lang.NonNull;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orderId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NonNull
	private Integer amount;

	@NonNull
	private String products;

	@NonNull
	private String user;

	public OrderDTO() {

	}

	public OrderDTO(Integer orderId, LocalDate date, Integer amount, String products, String user) {
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

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
		return "OrderDTO [orderId=" + orderId + ", date=" + date + ", amount=" + amount + ", products=" + products
				+ ", user=" + user + "]";
	}

}

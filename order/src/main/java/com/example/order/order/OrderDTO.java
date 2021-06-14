package com.example.order.order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.lang.NonNull;

public class OrderDTO implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@NonNull
	private Integer amount;
	
	@NonNull
	private Set<ProductDTO > products = new HashSet<>();

	@NonNull
	private UserDTO user;
	
	public OrderDTO() {
		
	}

	public OrderDTO(LocalDate date, Set<ProductDTO> products, UserDTO user) {
		this.date = date;
		this.products = products;
		this.user = user;
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Set<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", date=" + date + ", amount=" + amount + ", products=" + products
				+ ", user=" + user +  "]";
	}	
}


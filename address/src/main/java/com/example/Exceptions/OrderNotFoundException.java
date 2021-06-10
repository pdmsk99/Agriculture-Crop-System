package com.example.Exceptions;



//@ResponseStatus(value = HttpStatus.NOT_FOUND , reason ="Order does not exist. Please enter valid order details! ")
public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	public OrderNotFoundException() {
		
	}
	
	public OrderNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "Order does not exist.";
	}
	
}

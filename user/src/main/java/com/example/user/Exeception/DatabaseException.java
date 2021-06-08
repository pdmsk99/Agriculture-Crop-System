package com.example.user.Exeception;

public class DatabaseException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseException() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Sorry!No Orders details available.";
	}
}

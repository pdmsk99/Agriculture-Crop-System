package com.example.user.Exeception;

public class DuplicateRecordFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DuplicateRecordFoundException(String message) {
		super(message);
	}
}

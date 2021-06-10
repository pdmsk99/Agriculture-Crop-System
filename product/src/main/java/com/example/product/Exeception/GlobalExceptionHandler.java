package com.example.product.Exeception;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		
		body.put("errors", errors);
		
		return new ResponseEntity<> (body, headers, status);
	}
	
//	@ExceptionHandler(OrderNotFoundException.class)
//    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException exception, WebRequest webRequest) {
//		
//		System.out.println(webRequest.toString());
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setStatus(404);
//        exceptionResponse.setTime(LocalDateTime.now());
//        exceptionResponse.setMessage(exception.toString());
//  
//        return new ResponseEntity<Object> (exceptionResponse, HttpStatus.NOT_FOUND);
//        
//    }
//	
//	@ExceptionHandler(DatabaseException.class)
//    public ResponseEntity<Object> handleDatabaseException(DatabaseException exception, WebRequest webRequest) {
//		
//		System.out.println(webRequest.toString());
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setStatus(404);
//        exceptionResponse.setTime(LocalDateTime.now());
//        exceptionResponse.setMessage(exception.getMessage());
//  
//        return new ResponseEntity<Object> (exceptionResponse, HttpStatus.NOT_FOUND);
//        
//    }
}






























	/*
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<Object> resouceNotFoundException(DatabaseException ex, WebRequest request)
	{
		ExceptionResponse exceptionDetails = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globleExceptionHandler(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionDetails = new ExceptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> resouceAlreadyExistsException(RecordNotFoundException ex, WebRequest request)
	{
		ExceptionResponse exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(DuplicateRecordFoundException.class)
	public ResponseEntity<Object> resouceAlreadyExistsException(DuplicateRecordFoundException ex, WebRequest request)
	{
		ExceptionResponse exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
   */


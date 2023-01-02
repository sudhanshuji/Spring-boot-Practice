package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	public CustomerRestExceptionHandler() {

	}

	// Add an exception handler for cutsomerNotFoundException

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleNotFoundException(CustomerNotFoundException exc){
		
		// create customer error respnse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(), System.currentTimeMillis());
		
		//return responseENtity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	
	}

	// Add another exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAnyException(Exception exc){
		
		// create customer error respnse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(), System.currentTimeMillis());
		
		//return responseENtity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	
	}

}

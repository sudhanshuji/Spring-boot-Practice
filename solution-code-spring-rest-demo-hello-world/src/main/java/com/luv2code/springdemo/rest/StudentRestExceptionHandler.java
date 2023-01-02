package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	// add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

			// create a studentERRorResponse

			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessgae(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return responseEntity
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);

		}

		// add another exception handler to handle any kind of exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleAnyException(Exception exc) {

			// create a studentERRorResponse

			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessgae(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return responseEntity
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);

		}
}

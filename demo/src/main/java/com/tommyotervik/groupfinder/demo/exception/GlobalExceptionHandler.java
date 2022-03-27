package com.tommyotervik.groupfinder.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//global advice interceptor

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Exception handler method, CustomerErrorResponse = Type of the response body,     CustomerNotFoundException = Exception type to handle / catch
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException exception)  {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
		
		// error = body, status code
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler to catch any exception (catch all)
	
	// global handler
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception)  {
		
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
		// error = body, status code
		
		error.setMessage("Bad request.");
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

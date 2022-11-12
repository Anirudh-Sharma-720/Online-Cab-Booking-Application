package com.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends Exception {

	/**
	 * postman acts as client 
	 * request
	 * 
	 * response
	 * rest service acts as server
	 */
	private static final long serialVersionUID = 914569459626622748L;
	
	public DriverNotFoundException(String errorMsg) {
		super(errorMsg);
	}


}
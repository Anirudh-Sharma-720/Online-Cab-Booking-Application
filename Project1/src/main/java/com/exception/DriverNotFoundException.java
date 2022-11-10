package com.exception;

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
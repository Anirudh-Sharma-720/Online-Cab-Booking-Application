package com.exception;

public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1970762601225780363L;
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}

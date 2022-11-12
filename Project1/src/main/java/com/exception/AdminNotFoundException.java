package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5595964428948080655L;

	
	
	public AdminNotFoundException(String msg) {
		super(msg);
	}
}

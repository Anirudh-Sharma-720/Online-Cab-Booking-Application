package com.exception;

public class TripBookingNotFoundException extends  Exception{

private static final long serialVersionUID = 1L;
	
	public TripBookingNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}

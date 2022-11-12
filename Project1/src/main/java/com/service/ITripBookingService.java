package com.service;

import java.util.List;

import com.entities.Driver;
import com.entities.TripBooking;
import com.exception.TripBookingNotFoundException;

public interface ITripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking updateTripBooking(int TripBookingId,TripBooking tripBooking) throws TripBookingNotFoundException;
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingNotFoundException;
	public List<TripBooking> viewAllTripsCustomer(int customerId) throws TripBookingNotFoundException;
	public float calculateBill(int customerId);
	public Driver viewDriver(int tripId);
	
}
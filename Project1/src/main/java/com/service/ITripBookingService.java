package com.service;

import java.util.List;

import com.entities.Driver;
import com.entities.TripBooking;

public interface ITripBookingService {
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking updateTripBooking(int TripBookingId,TripBooking tripBooking);
	public TripBooking deleteTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateBill(int customerId);
	public Driver viewDriver(int tripId);
}
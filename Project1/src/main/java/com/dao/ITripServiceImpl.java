package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Driver;
import com.entities.TripBooking;
import com.exception.TripBookingNotFoundException;
//import com.exception.DriverNotFoundException;
import com.repository.ITripBookingRepository;
import com.service.ITripBookingService;

@Service
public class ITripServiceImpl implements ITripBookingService{
	@Autowired
	private ITripBookingRepository tripBookingRepository;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		TripBooking tripBookingObj = tripBookingRepository.save(tripBooking);
		return tripBookingObj;
	}

	@Override
	public TripBooking updateTripBooking(int tripBookingId, TripBooking tripBooking) throws TripBookingNotFoundException {
		TripBooking tripBookingObj = tripBookingRepository.findById(tripBookingId).orElseThrow(()->new TripBookingNotFoundException("Trip Booking does not exist with that Id"));
		tripBookingObj.setCustomerId(tripBooking.getCustomerId());
		tripBookingObj.setDriver(tripBooking.getDriver());
		tripBookingObj.setFromLocation(tripBooking.getFromLocation());
		tripBookingObj.setToLocation(tripBooking.getToLocation());
		tripBookingObj.setFromDateTime(tripBooking.getFromDateTime());
		tripBookingObj.setToDateTime(tripBooking.getToDateTime());
		tripBookingObj.setStatus(tripBooking.isStatus());
		tripBookingObj.setDistanceInKm(tripBooking.getDistanceInKm());
		tripBookingObj.setBill(tripBooking.getBill());
		
		tripBookingRepository.deleteById(tripBookingId);
		TripBooking updatedTripBooking = tripBookingRepository.save(tripBookingObj);
		return updatedTripBooking;
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingNotFoundException {
		 
		TripBooking tripBookingObj = tripBookingRepository.findById(tripBookingId).orElseThrow(()->new TripBookingNotFoundException("Trip Booking does not exist with that Id"));
		if(tripBookingRepository.existsById(tripBookingId))
			tripBookingRepository.deleteById(tripBookingId);
		return tripBookingObj;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) throws TripBookingNotFoundException {
		List<TripBooking> bestTripsCustomer = tripBookingRepository.viewAllTripsCustomer(customerId);
		return bestTripsCustomer;
	}

	//@Override
	public Driver viewDriver(int tripBookingId){
		TripBooking tripBookingObj = tripBookingRepository.findById(tripBookingId).get();
		return tripBookingObj.getDriver();
	}


	@Override
	public float calculateBill(int tripId) {
		// TODO Auto-generated method stub
		TripBooking trip=tripBookingRepository.findById(tripId).get();
		float bill=trip.getDistanceInKm()*trip.getCab().getPerKmRate();
		return bill;
	}
	public List<TripBooking> viewTripsCabwise(int cabId){
		return tripBookingRepository.getTripsCabwise(cabId);
	
	}
	public List<TripBooking> getAllTrips(){
		return tripBookingRepository.findAll();	}
	public TripBooking getTripById(int tripId){
		return tripBookingRepository.findById(tripId).get();
	}
}
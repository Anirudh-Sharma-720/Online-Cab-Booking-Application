package com.controller;
import com.dao.*;
import com.entities.*;
import com.exception.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/trip/v1/")
public class ITripBoookingServiceController {
	
	Logger log = LoggerFactory.getLogger(IDriverServiceController.class);
	
	@Autowired
	private ITripServiceImpl serv;

	@PostMapping("/trip/insert")
	public TripBooking addAdmin(@RequestBody TripBooking trip) {
		TripBooking tObj = serv.insertTripBooking(trip);
		if(tObj != null)
			log.info("Trip Booking Inserted!");
		else
			log.info("Failed to Insert Trip Booking!");
		return tObj;
	}
	
	@PutMapping("/trip/update/{id}")
	public TripBooking updateAdminName(@PathVariable("id") int id, @RequestBody TripBooking trip) throws TripBookingNotFoundException {
		TripBooking tObj = serv.updateTripBooking(id, trip);
		if(tObj != null)
			log.info("Trip Booking Details Updated!");
		else
			log.info("Failed to Update Trip Booking Details!");
		return tObj;
	}
	
	@DeleteMapping("/trip/delete/{id}")
	public TripBooking deleteAdmin(@PathVariable int id) throws TripBookingNotFoundException {
		TripBooking tObj = serv.deleteTripBooking(id);
		if(tObj != null)
			log.info("Trip Booking Deleted!");
		else
			log.info("Failed to Delete Trip Booking!");
		return tObj;
	}
	
	@GetMapping("/trips/customer/{id}")
	public List<TripBooking> getAllTripsCustomerwise(@PathVariable int id) throws TripBookingNotFoundException {
		List<TripBooking> tList = serv.viewAllTripsCustomer(id);
		if(tList.size() > 0)
			log.info("List of All Trips by Customer extracted");
		else
			log.info("Failed to extract List of All Trips by Customer");
		return tList;
	}
	
	@GetMapping("/trip/driver/{id}")
	public Driver viewDriver(@PathVariable int id){
		Driver dObj = serv.viewDriver(id);
		if(dObj != null) 
			log.info("Driver extracted!");
		else 
			log.info("Failed to extract Driver");
		return dObj;
	}
	
	@GetMapping("/trip/cab/{id}")
	public List<TripBooking> viewTripsCabwise(@PathVariable int id){
		List<TripBooking> tList = serv.viewTripsCabwise(id);
		if(tList.size() > 0)
			log.info("List of Trips provied By Cab extracted");
		else
			log.info("Failed to extract List of Trips provied By Cab");
		return tList;
	}
	
	@GetMapping("/trip/getAll")
	public List<TripBooking> getAllTrips(){
		List<TripBooking> tList = serv.getAllTrips();
		if(tList.size() > 0)
			log.info("List of Trip Bookings extracted");
		else
			log.info("Failed to extract List of Trip Bookings");
		return tList;
	}
	
	@GetMapping("/trip/getById/{id}")
	public TripBooking getTripById(@PathVariable int id) {
		TripBooking tObj = serv.getTripById(id);
		if(tObj != null) 
			log.info("Trip Booking details extracted!");
		else 
			log.info("Failed to extract Trip Booking details");
		return tObj;
	}
	
}

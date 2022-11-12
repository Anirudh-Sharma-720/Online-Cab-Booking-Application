package com.controller;
import com.dao.*;
import com.entities.*;
import com.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/trip/v1/")
public class ITripBoookingServiceController {
@Autowired
private ITripServiceImpl serv;

@PostMapping("/trip/insert")
public TripBooking addAdmin(@RequestBody TripBooking trip) {
	return serv.insertTripBooking(trip);
}

@PutMapping("/trip/update/{id}/{trip}")
public TripBooking updateAdminName(@PathVariable("id") int id,@PathVariable("trip") TripBooking trip) {
	return serv.updateTripBooking(id, trip);
}

@DeleteMapping("/trip/delete/{id}")
public TripBooking deleteAdmin(@PathVariable int id)  {
	return serv.deleteTripBooking(id);
}

@GetMapping("/trips/customer/{id}")
public List<TripBooking> getAllTripsCustomerwise(@PathVariable int id){
	return serv.viewAllTripsCustomer(id);
}
@GetMapping("/trip/driver/{id}")
public Driver viewDriver(@PathVariable int id){
	return serv.viewDriver(id);
}
@GetMapping("/trip/cab/{id}")
public List<TripBooking> viewTripsCabwise(@PathVariable int id){
	return serv.viewTripsCabwise(id);
}
@GetMapping("/trip/getAll")
public List<TripBooking> getAllTrips(){
	return serv.getAllTrips();
}
@GetMapping("/trip/getById/{id}")
public TripBooking getTripById(@PathVariable int id) {
	return serv.getTripById(id);
}
}

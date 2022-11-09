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

@DeleteMapping("trip/delete/{id}")
public TripBooking deleteAdmin(@PathVariable int id)  {
	return serv.deleteTripBooking(id);
}

@GetMapping("trips/customer/{id}")
public List<TripBooking> getAllTripsCustomerwise(@PathVariable int id){
	return serv.viewAllTripsCustomer(id);
}
@GetMapping("trip/driver/{id}")
public Driver viewDriver(@PathVariable int id){
	return serv.viewDriver(id);
}
@GetMapping("trip/cab/{id}")
public List<TripBooking> viewTripsCabwise(@PathVariable int id){
	return serv.viewTripsCabwise(id);
}


}

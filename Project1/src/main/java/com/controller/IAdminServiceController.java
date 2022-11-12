package com.controller;
import com.dao.*;
import com.entities.*;
import com.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/admin/v1/")
public class IAdminServiceController {
	@Autowired
private IAdminServiceImpl serv;


@PostMapping("/admin/insert")
public Admin addAdmin(@RequestBody Admin admin) {
	return serv.insertAdmin(admin);
}

@PutMapping("/admin/update/{id}")
public Admin updateAdmin(@PathVariable("id") int id,@RequestBody Admin admin) throws AdminNotFoundException {
	return serv.updateAdmin(id, admin);
}

@DeleteMapping("/admin/delete/{id}")
public Admin deleteAdmin(@PathVariable int id) throws AdminNotFoundException {
	return serv.deleteAdmin(id);
}


@GetMapping("/admin/getAll")
public List<Admin> getAllAdmins(){
	return serv.getAllAdmins();
}
@GetMapping("/trips/getAll")
public List<TripBooking> getAllTrips(){
	return serv.getAllTrips();
}

//@GetMapping("trips/customer/{id}")
//public List<TripBooking> getAllTripsCustomerwise(@PathVariable int id){
//	return serv.getTripsCustomerwise(id);
//}
@GetMapping("/trips/cab/{id}")
public List<TripBooking> getAllTripsCabwise(@PathVariable int id){
	return serv.getTripsCabwise(id);
}
@GetMapping("/trips/cab/{from}/{to}")
public List<TripBooking> getAllTripsDatewise(@PathVariable("from") LocalDateTime from,@PathVariable("to") LocalDateTime to){
	return serv.getTripsDatewise(from,to);
}
@GetMapping("/admin/getById/{userId}")
public Admin getAdminById(@PathVariable int userId) {
	return serv.getAdminById(userId);
}
}

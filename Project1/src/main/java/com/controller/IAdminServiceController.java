package com.controller;
import com.dao.*;
import com.entities.*;
import com.exception.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

import javax.validation.Valid;
@RestController
@CrossOrigin("*")
public class IAdminServiceController {
	@Autowired
private IAdminServiceImpl serv;
	Logger log = LoggerFactory.getLogger(IAdminServiceController.class);
	


@PostMapping("/admin/insert")
public Admin addAdmin(@Valid @RequestBody Admin admin) {
	Admin a = serv.insertAdmin(admin);
	if(a!=null) log.info("Admin inserted!");
	else log.info("Failed to insert admin");
	return a;
}

@PutMapping("/admin/updateName/{id}/{name}")
public Admin updateAdminName(@PathVariable("id") int id,@PathVariable("name") String name) throws AdminNotFoundException {
	Admin a = serv.updateAdminName(id, name);
	if(a!=null) log.info("Admin updated!");
	else log.info("Failed to update admin");
	return a;
}

@DeleteMapping("admin/delete/{id}")
public Admin deleteAdmin(@PathVariable int id) throws AdminNotFoundException {
	Admin a = serv.deleteAdmin(id);
	if(a!=null) log.info("Admin deleted!");
	else log.info("Failed to delete admin");
	return a;
}


@GetMapping("admin/getAll")
public List<Admin> getAllAdmins(){
	List<Admin> alist = serv.getAllAdmins();
	if(alist.size()!=0) log.info("List of admin extracted!");
	else log.info("Failed to extract the list of admins");
	return alist;
}
@GetMapping("trips/getAll")
public List<TripBooking> getAllTrips(){
	List<TripBooking> alist = serv.getAllTrips();
	if(alist.size()!=0) log.info("List of trips extracted!");
	else log.info("Failed to extract the list of trips");
	return alist;
}

//@GetMapping("trips/customer/{id}")
//public List<TripBooking> getAllTripsCustomerwise(@PathVariable int id){
//	return serv.getTripsCustomerwise(id);
//}

@GetMapping("trips/cab/{id}")
public List<TripBooking> getAllTripsCabwise(@PathVariable int id){
	List<TripBooking> alist = serv.getTripsCabwise(id);
	if(alist.size()!=0) log.info("List of trips(cabwise) extracted!");
	else log.info("Failed to extract the list of trips(cabwise)");
	return alist;

}
@GetMapping("trips/cab/{from}/{to}")
public List<TripBooking> getAllTripsDatewise(@PathVariable("from") LocalDateTime from,@PathVariable("to") LocalDateTime to){
	List<TripBooking> alist = serv.getTripsDatewise(from,to);
	if(alist.size()!=0) log.info("List of trips(datewise) extracted!");
	else log.info("Failed to extract the list of trips(datewise)");
	return alist;
}
}

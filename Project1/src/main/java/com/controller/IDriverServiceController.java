package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.entities.Driver;
import com.exception.DriverNotFoundException;
import com.service.IDriverService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/drivers/")
public class IDriverServiceController {
	
	Logger log = LoggerFactory.getLogger(IDriverServiceController.class);
	@Autowired
	private IDriverService driverService;
	/*
	 * POST-create
	 * GET-fetch
	 * PUT-update
	 * DELETE-delete
	 * method
	 * header(method name, cookies, url, session, error)
	 * body{
	 * URI: localhost:8080/add/product
	 * 
	 * */
	
	@PostMapping("/driver/insert")
	public ResponseEntity<Driver> insertDriver(@Valid @RequestBody Driver driver) {
		Driver d = driverService.insertDriver(driver);
		if(d!=null) {
			log.info("Driver inserted!");
		}
		else log.info("Failed to insert driver!");
		return new ResponseEntity<Driver>(d, HttpStatus.CREATED);
	}
	
	@PutMapping("/driver/update/{userId}")
	public Driver updateDriver(@Valid @PathVariable("userId") int userId, @RequestBody Driver driver) throws DriverNotFoundException {
		Driver d = driverService.updateDriver(userId, driver); 
		if(d!=null) log.info("Driver updated!");
		else log.info("Failed to update driver");
		return d;
	}
	
	@DeleteMapping("/driver/delete/{userId}")
	public Driver deleteDriver(@PathVariable("userId") int userId) throws DriverNotFoundException{
		Driver d = driverService.deleteDriver(userId);
		if(d!=null) log.info("Driver deleted!");
		else log.info("Failed to delete driver");
		return d;
	}
	
	@GetMapping("/driver/view/{userId}")
	public Driver viewDriver(@PathVariable("userId") int userId) throws DriverNotFoundException {
		Driver d = driverService.viewDriver(userId);
		if(d!=null) log.info("Driver extracted!");
		else log.info("Failed to extract driver");
		return d;
	}
	
	@GetMapping("driver/viewBest")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException{
		List<Driver> dlist = driverService.viewBestDrivers();
		if(dlist.size()!=0) log.info("List of best drivers extracted!");
		else log.info("Failed to extract the list of best drivers");
		return dlist;
	}
	
	@GetMapping("driver/viewAll")
	public List<Driver> viewAll() throws DriverNotFoundException{
		List<Driver> dlist = driverService.viewAll();
		if(dlist.size()!=0) log.info("List of drivers extracted!");
		else log.info("Failed to extract the list of drivers");
		return dlist;
	}
	
	
	
	
	
	

}
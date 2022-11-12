package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entities.Driver;
import com.exception.DriverNotFoundException;
import com.service.IDriverService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/driver/v1/")
public class IDriverServiceController {
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
	public Driver insertDriver(@RequestBody Driver driver) {
		return driverService.insertDriver(driver);
	}
	
	@PutMapping("/driver/update/{userId}")
	public Driver updateDriver(@PathVariable("userId") int userId, @RequestBody Driver driver) throws DriverNotFoundException {
		return driverService.updateDriver(userId, driver);
	}
	
	@DeleteMapping("/driver/delete/{userId}")
	public Driver deleteDriver(@PathVariable("userId") int userId) throws DriverNotFoundException{
		return driverService.deleteDriver(userId);
	}
	
	@GetMapping("/driver/view/{userId}")
	public Driver viewDriver(@PathVariable("userId") int userId) throws DriverNotFoundException {
		return driverService.viewDriver(userId);
	}
	
	@GetMapping("driver/viewBest")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException{
		return driverService.viewBestDrivers();
	}
	
	@GetMapping("driver/viewAll")
	public List<Driver> viewAll() throws DriverNotFoundException{
		return driverService.viewAll();
	}
	
	

}
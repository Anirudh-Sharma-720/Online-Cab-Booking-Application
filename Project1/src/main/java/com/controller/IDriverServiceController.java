package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entities.Driver;
import com.exception.DriverNotFoundException;
import com.service.IDriverService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/drivers/")
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
	
	@PostMapping("/insert")
	public Driver insertDriver(@RequestBody Driver driver) {
		return driverService.insertDriver(driver);
	}
	
	@PutMapping("/update/{driverId}")
	public Driver updateDriver(@PathVariable("driverId") int driverId, @RequestBody Driver driver) throws DriverNotFoundException {
		return driverService.updateDriver(driverId, driver);
	}
	
	@DeleteMapping("/delete/{driverId}")
	public Driver deleteDriver(@PathVariable("driverId") int driverId) throws DriverNotFoundException{
		return driverService.deleteDriver(driverId);
	}
	
	@GetMapping("/view/{driverId}")
	public Driver viewDriver(@PathVariable("driverId") int driverId) throws DriverNotFoundException {
		return driverService.viewDriver(driverId);
	}
	
	@GetMapping("/viewBest")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException{
		return driverService.viewBestDrivers();
	}
	
	
	
	

}

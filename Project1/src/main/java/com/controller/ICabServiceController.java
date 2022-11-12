package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entities.Cab;
import com.exception.CabNotFoundException;
import com.service.ICabService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cab/v1/")
public class ICabServiceController {
Logger log = LoggerFactory.getLogger(ICabServiceController.class);
	
	@Autowired
	private ICabService cabService;
	
	@GetMapping(path="/cab/viewAll")
	public List<Cab> viewAllCabs() {
		List<Cab> cabList = cabService.viewAllCabs();
		if(cabList.size() != 0)
			log.info("List of Cabs extracted");
		else
			log.info("Failed to extract the list of Cabs");			
		return cabList;
	}
	
	@PostMapping("/cab/insert")
	public Cab insertCab(@RequestBody Cab cab) {
		Cab cabObj = cabService.insertCab(cab);
		if(cabObj != null)
			log.info("Cab Inserted!");
		else
			log.info("Failed to Insert Cab!");
		return cabObj;
	}
	
	@PutMapping(path="/cab/update/{cabId}")
	public Cab updateCab(@PathVariable("cabId") int cabId, @RequestBody Cab cab) throws CabNotFoundException {
		Cab cabObj = cabService.updateCab(cabId, cab);
		if(cabObj != null)
			log.info("Cab Details Updated!");
		else
			log.info("Failed to Update Cab Details!");
		return cabObj;
	}
	
	@DeleteMapping("/cab/delete/{cabId}")
	public Cab deleteCab(@PathVariable("cabId") int cabId) throws CabNotFoundException{
		Cab cabObj = cabService.deleteCab(cabId);
		if(cabObj != null)
			log.info("Cab Deleted!");
		else
			log.info("Failed to Delete Cab!");
		return cabObj;
	}
	
	@GetMapping(path="/cab/byType/{carType}")
	public List<Cab> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		List<Cab> cabList = cabService.viewCabsOfType(carType);
		if(cabList.size() > 0)
			log.info("List of Cabs by type extracted");
		else
			log.info("Failed to extract List of Cabs by type");
		return cabList;
	}
	
	@GetMapping(path="/cab/countBy/{carType}")
	public int countCabsOfType(@PathVariable String carType) {
		int val = cabService.countCabsOfType(carType);
		if(val > 0)
			log.info("Count of Cabs by type extracted");
		else
			log.info("Failed to extract Count of Cabs by type");
		return val;
	}
	
}
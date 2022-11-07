package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Cab;
import com.exception.CabNotFoundException;
import com.service.ICabService;

@RestController
public class ICabServiceController {
	@Autowired
	private ICabService cabService;
	
	@PostMapping("/cab/insert")
	public Cab insertCab(@RequestBody Cab cab) {
		return cabService.insertCab(cab);
	}
	
	@PutMapping(path="/cab/update/{cabId}/{carType}")
	   public int updateCab(@PathVariable("carType") String carType, @PathVariable("cabId") int cabId) throws CabNotFoundException {
		   return cabService.updateCab(carType,cabId);
	}
	
	@DeleteMapping("/cab/delete/{cabId}")
	public Cab deleteCab(@PathVariable("cabId") int cabId) throws CabNotFoundException{
		return cabService.deleteCab(cabId);
	}
	
	@GetMapping(path="/cab/byType/{carType}")
	public List<Cab> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
		   return cabService.viewCabsOfType(carType);
	}
	
	@GetMapping(path="/cab/countBy/{carType}")
	public int countCabsOfType(String carType) {
		return cabService.countCabsOfType(carType);
	}
	
}

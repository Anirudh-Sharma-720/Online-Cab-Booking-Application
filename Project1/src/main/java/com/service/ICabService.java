package com.service;

import java.util.List;

import com.entities.Cab;
import com.exception.CabNotFoundException;

public interface ICabService {
	
	public List<Cab> viewAllCabs();
	public Cab insertCab(Cab cab);
	public Cab updateCab(int cabId, Cab cab) throws CabNotFoundException;
	public Cab deleteCab(int cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType);
	
}
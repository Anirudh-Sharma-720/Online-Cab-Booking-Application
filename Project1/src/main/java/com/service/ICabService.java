package com.service;

import java.util.List;

import com.entities.Cab;
import com.exception.CabNotFoundException;

public interface ICabService {
	
	public Cab insertCab(Cab cab);
	public int updateCab(String carType, int cabId) throws CabNotFoundException;
	public Cab deleteCab(int cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType);
	
}
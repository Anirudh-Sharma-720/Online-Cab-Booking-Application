package com.repository;

import java.util.List;

import com.entities.Cab;
import com.exception.CabNotFoundException;

public interface ICabRepository {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab) throws CabNotFoundException;
	public Cab deleteCab(Cab cab) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
}
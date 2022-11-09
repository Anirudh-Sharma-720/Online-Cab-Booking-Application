package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Cab;
import com.exception.CabNotFoundException;
import com.repository.ICabRepository;
import com.service.ICabService;

@Service
public class ICabServiceImpl implements ICabService{
	@Autowired
	private ICabRepository cabRepository;
	
	@Override
	public List<Cab> viewAllCabs() {
		return cabRepository.findAll();
	}
	
	@Override
	public Cab insertCab(Cab cab) {
		return cabRepository.save(cab);
	}

	@Override
	public Cab updateCab(int cabId, Cab cab) throws CabNotFoundException {
		Cab cabObj = cabRepository.findById(cabId).orElseThrow(()->new CabNotFoundException("Cab does not exist with that Id"));
		cabObj.setCarType(cab.getCarType());
		cabObj.setPerKmRate(cab.getPerKmRate());
		Cab updatedCabObj = cabRepository.save(cabObj);
		return updatedCabObj;
	}

	@Override
	public Cab deleteCab(int cabId) throws CabNotFoundException {
		Cab cabObj = cabRepository.findById(cabId).orElseThrow(()->new CabNotFoundException("Cab does not exist with that Id"));
		cabRepository.deleteById(cabId);
		return cabObj;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
		return cabRepository.findByName(carType);
	}

	@Override
	public int countCabsOfType(String carType) {
		return cabRepository.countByType(carType);
	}
	
}

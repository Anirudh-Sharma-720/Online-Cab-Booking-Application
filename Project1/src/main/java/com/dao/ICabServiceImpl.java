package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Cab;
import com.exception.CabNotFoundException;
import com.repository.ICabRepository;
import com.service.ICabService;

@Service
public abstract class ICabServiceImpl implements ICabService{
	@Autowired
	private ICabRepository cabRepository;
	
	@Override
	public Cab insertCab(Cab cab) {
		return cabRepository.save(cab);
	}

	@Override
	public int updateCab(String carType, int cabId) throws CabNotFoundException {
		Cab cabObj = cabRepository.findById(cabId).orElseThrow(()->new CabNotFoundException("Cab does not exist with that Id"));
		int status = cabRepository.updateCab(carType,cabId);
		return status;
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

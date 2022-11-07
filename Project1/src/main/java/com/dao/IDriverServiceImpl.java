package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Driver;
import com.exception.DriverNotFoundException;
import com.repository.IDriverRepository;
import com.service.IDriverService;

@Service
public class IDriverServiceImpl implements IDriverService{
	@Autowired
	private IDriverRepository driverRepository;

	@Override
	public Driver insertDriver(Driver driver) {
		Driver driverObj = driverRepository.save(driver);
		return driverObj;
	}

	@Override
	public Driver updateDriver(int driverId, Driver driver) throws DriverNotFoundException {
		Driver driverObj = driverRepository.findById(driverId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		driverObj.setCab(driver.getCab());
		driverObj.setLicenseNo(driver.getLicenseNo());
		driverObj.setRating(driver.getRating());
		Driver updatedDriver = driverRepository.save(driverObj);
		return updatedDriver;
	}

	@Override
	public Driver deleteDriver(int driverId) throws DriverNotFoundException {
		 
		Driver driverObj = driverRepository.findById(driverId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		driverRepository.deleteById(driverId);
		return driverObj;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> bestDrivers = driverRepository.viewBestDrivers();
		return bestDrivers;
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		Driver driverObj = driverRepository.findById(driverId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		return driverObj;
	}

}

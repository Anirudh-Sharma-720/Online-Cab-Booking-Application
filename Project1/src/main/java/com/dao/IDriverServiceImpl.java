package com.dao;

import java.util.List;
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
	public Driver updateDriver(int userId, Driver driver) throws DriverNotFoundException {
		Driver driverObj = driverRepository.findById(userId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		driverObj.setCab(driver.getCab());
		driverObj.setLicenseNo(driver.getLicenseNo());
		driverObj.setRating(driver.getRating());
		driverObj.setMobileNumber(driver.getMobileNumber());
		driverRepository.deleteById(userId);
		Driver updatedDriver = driverRepository.save(driverObj);
		return updatedDriver;
	}

	@Override
	public Driver deleteDriver(int userId) throws DriverNotFoundException { 
		Driver driverObj = driverRepository.findById(userId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		driverRepository.deleteById(userId);
		return driverObj;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> bestDrivers = driverRepository.viewBestDrivers();
		return bestDrivers;
	}

	@Override
	public Driver viewDriver(int userId) throws DriverNotFoundException {
		Driver driverObj = driverRepository.findById(userId).orElseThrow(()->new DriverNotFoundException("Driver with that id does not exist"));
		return driverObj;
	}

	@Override
	public List<Driver> viewAll() throws DriverNotFoundException {
		List<Driver> list = driverRepository.findAll();
		return list;
	}
	
	

}
package com.service;

import java.util.List;

import com.entities.Driver;
import com.exception.DriverNotFoundException;

public interface IDriverService {
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(int driverId, Driver driver) throws DriverNotFoundException;
	public Driver deleteDriver(int driverId) throws DriverNotFoundException;
	public List<Driver>viewBestDrivers() throws DriverNotFoundException;
	public Driver viewDriver(int driverId) throws DriverNotFoundException;
}
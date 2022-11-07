package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entities.Driver;
import com.exception.DriverNotFoundException;

public interface IDriverRepository extends JpaRepository<Driver, Integer>{
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(int driverId,Driver driver)throws DriverNotFoundException;
	public Driver deleteDriver(int driverId)throws DriverNotFoundException;
	
	
	public Driver viewDriver(int driverId)throws DriverNotFoundException;
	
	@Transactional
	@Query(value="select u from driver u where rating=5")
	public List<Driver>viewBestDrivers()throws DriverNotFoundException;
}
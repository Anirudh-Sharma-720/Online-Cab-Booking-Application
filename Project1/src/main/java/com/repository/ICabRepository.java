package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Cab;
import com.exception.CabNotFoundException;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer>{
	
	@Query(value="select c from Cab c where carType=?1")
	public List<Cab> findByName(String carType);
	
	@Query(value="select COUNT(c) from Cab c where carType=?1")
	public int countByType(String carType);
	
	
	@Modifying
	@Transactional
	@Query(value="update Cab set carType=?1 where cabId=?2")
	public int updateCab(String carType, int cabId) throws CabNotFoundException;

//	public Cab insertCab(Cab cab);
//	public Cab deleteCab(int cabId) throws CabNotFoundException;
//	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
//	public int countCabsOfType(String carType);
}
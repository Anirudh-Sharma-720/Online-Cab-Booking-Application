package com.dao;
import com.service.*;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entities.*;
import com.repository.IAdminRepository;
import com.repository.ITripBookingRepository;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class IAdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository repo;
	@Autowired
	private ITripBookingRepository tripRepo;
	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
	return repo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		
		Admin ad=repo.findById(adminId).get();
		if(repo.existsById(adminId)) {
			repo.deleteById(adminId);
			return ad ;
		}
		return null;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		// TODO Auto-generated method stub
		return tripRepo.findAll();
	}

	@Override
	public List<TripBooking> getTripsCabwise(Cab cab) {
		// TODO Auto-generated method stub
		return tripRepo.
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		// TODO Auto-generated method stub
		return null;
	}



	}
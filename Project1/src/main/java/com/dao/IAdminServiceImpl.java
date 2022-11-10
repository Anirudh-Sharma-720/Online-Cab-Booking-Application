package com.dao;
import com.service.*;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exception.*;
import java.sql.Timestamp;
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
	public Admin updateAdminName(int AdminId,String name) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		Admin adminObj = repo.findById(AdminId).orElseThrow(()->new AdminNotFoundException("Admin with that id does not exist"));
		adminObj.setUsername(name);
		if(repo.existsById(AdminId)) {
			repo.deleteById(AdminId);
		
		}
		return repo.save(adminObj);
	}

	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		
		Admin ad=repo.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin with this Id does not exist"));
		if(repo.existsById(adminId)) {
			repo.deleteById(adminId);
			return ad ;
		}
		return null;
	}
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<TripBooking> getAllTrips() {
		// TODO Auto-generated method stub
		return tripRepo.findAll();
	}

	@Override
	public List<TripBooking> getTripsCabwise(int cabId) {
		// TODO Auto-generated method stub
		return tripRepo.getTripsCabwise(cabId);
	}

//	@Override
//	public List<TripBooking> getTripsCustomerwise(int customerId) {
//		// TODO Auto-generated method stub
//		return tripRepo.getTripsCustomerwise(customerId);
//	}

	@Override
	public List<TripBooking> getTripsDatewise(LocalDateTime from, LocalDateTime to) {
		// TODO Auto-generated method stub
	    Timestamp d1=Timestamp.valueOf(from);
	    Timestamp d2=Timestamp.valueOf(to);
	    
		return tripRepo.getTripsDatewise(d1,d2);
		
	}



	}
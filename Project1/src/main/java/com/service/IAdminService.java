package com.service;
import com.exception.*;
import java.time.LocalDateTime;
import java.util.List;

import com.entities.Admin;
import com.entities.TripBooking;
import com.entities.*;
public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdminName(int adminId,String name) throws AdminNotFoundException;
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	public List<TripBooking> getAllTrips();
	public List<TripBooking> getTripsCabwise(int cabId);
	//public List<TripBooking> getTripsCustomerwise(int customerId);
	public List<TripBooking> getTripsDatewise(LocalDateTime from,LocalDateTime to);
	public List<Admin> getAllAdmins();
}
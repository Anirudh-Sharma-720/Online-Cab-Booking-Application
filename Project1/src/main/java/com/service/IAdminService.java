package com.service;

import java.time.LocalDateTime;
import java.util.List;

import com.entities.Admin;
import com.entities.TripBooking;
import com.entities.*;
public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public List<TripBooking> getAllTrips(int customerId);
	public List<TripBooking> getTripsCabwise(int cabId);
	public List<TripBooking> getTripsCustomerwise(int customerId);
	public List<TripBooking> getTripsDatewise(int tripId);
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);
}
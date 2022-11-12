package com.repository;

import java.util.List;
import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.entities.Cab;
import com.entities.TripBooking;
@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking,Integer>{
	
//	public TripBooking insertTripBooking(TripBooking tripBooking);
//	public TripBooking updateTripBooking(TripBooking tripBooking);
//	public TripBooking deleteTripBooking(TripBooking tripBooking);
	
	@Query(value="select t from TripBooking t where t.customerId=?1")
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	
//	public TripBooking calculateBill(int customerId);
	@Query(value="select p from TripBooking p where p.tripBookingId=?1")
	public List<TripBooking> viewDriver(int tripId);
	
	@Query(value="select p from TripBooking p where p.cab.cabId=?1")
	public List<TripBooking> getTripsCabwise(int cabId);
	
	@Query(value="select p from TripBooking p where p.customerId=?1")
	public List<TripBooking> getTripsCustomerwise(int customerId);
	
	@Query(value="select p from TripBooking p where p.fromDateTime=?1 and p.toDateTime=?2")
	public List<TripBooking> getTripsDatewise(Timestamp date1,Timestamp date2);
}
package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.IAdminServiceImpl;
import com.dao.ICustomerServiceImpl;
import com.dao.IDriverServiceImpl;
import com.entities.*;
import com.exception.AdminNotFoundException;
import com.exception.CustomerNotFoundException;
import com.exception.DriverNotFoundException;
import com.exception.InvalidLoginException;
import com.repository.*;

@SpringBootTest
class Project1ApplicationTests {

	//Driver
	//creating a mock driver repository
	@Mock
	private IDriverRepository driverRepo;
		
	//creating a mock driver service bean
	@Mock
	IDriverServiceImpl driverService;
		
		
	
	//Admin
	//creating a mock admin repository
	@Mock
	private IAdminRepository adminRepo;
	//creating a mock bean for admin service 
	@Mock
	private IAdminServiceImpl adminService;
	//creating a mock trip booking repository
	@Mock
	private ITripBookingRepository tripRepo;
	
	
	
	
	//customer
	//creating a mock customer repository
	@Mock
	private ICustomerRepository custRepo;
	//creating a mock bean for customer service
	@Mock
	ICustomerServiceImpl custService;
	
	
	@Test
	public void testDriver() throws DriverNotFoundException {
		//creating driver and cab objects to test the methods
		Driver testDriver = new Driver();
		Cab testCab = new Cab();
		testDriver.setUserId(1);
		testDriver.setUsername("deeksha");
		testDriver.setPassword("gdeeks");
		testDriver.setMobileNumber("8801327682");
		testDriver.setEmail("gdeeksha732@gmail.com");
		testDriver.setDriverId(11);
		testDriver.setLicenseNo("HG-124154");
		testDriver.setRating(4);
		testCab.setCabId(2);
		testCab.setCarType("mini");
		testCab.setPerKmRate(25);
		testCab.setTrips(null);
		testDriver.setCab(testCab);
		
		Driver updatedDriver = new Driver();
		updatedDriver.setUserId(2);
		updatedDriver.setUsername("sha");
		updatedDriver.setPassword("gdeeks");
		updatedDriver.setMobileNumber("8801327682");
		updatedDriver.setEmail("gdeeksha732@gmail.com");
		updatedDriver.setDriverId(11);
		updatedDriver.setLicenseNo("HG-124154");
		updatedDriver.setRating(5);
		testCab.setCabId(2);
		testCab.setCarType("mini");
		testCab.setPerKmRate(25);
		testCab.setTrips(null);
		updatedDriver.setCab(testCab);
		
		List<Driver> viewAll = new ArrayList<Driver>();
		viewAll.add(testDriver);
		viewAll.add(updatedDriver);
		
		List<Driver> viewBest = new ArrayList<Driver>();
		viewBest.add(updatedDriver);
		
		//test cases for all the services in dao class
		//inserting driver must return the driver object
		when(driverService.insertDriver(testDriver)).thenReturn(testDriver);
		assertThat(testDriver).isNotNull();
		//updating the test driver must return updated driver
		when(driverService.updateDriver(testDriver.getUserId(), updatedDriver)).thenReturn(updatedDriver);
		assertThat(updatedDriver).isNotNull();
		//viewing driver returns the driver that matches the given id
		when(driverService.viewDriver(1)).thenReturn(testDriver);
		assertThat(testDriver).isNotNull();
		//deleting driver returns the deleted driver object
		when(driverService.deleteDriver(1)).thenReturn(testDriver);
		//this method must return the list of all drivers
		when(driverService.viewAll()).thenReturn(viewAll);
		assertThat(viewAll.size()).isEqualTo(2);
		//this method must return the list of drivers that have rating = 5
		when(driverService.viewBestDrivers()).thenReturn(viewBest);
		assertThat(viewBest.size()).isEqualTo(1);
	
	}
	
	@Test
	public void testAdmin() throws AdminNotFoundException {
		//creating  objects to test admin service methods
		Admin testAdmin = new Admin();
		testAdmin.setUserId(1);
		testAdmin.setUsername("admin1");
		testAdmin.setPassword("123");
		testAdmin.setMobileNumber("34673647");
		testAdmin.setEmail("hdsghdghss");
		testAdmin.setAdminId(1);
		
		Admin updatedAdmin = new Admin();
		updatedAdmin.setUserId(2);
		updatedAdmin.setUsername("admin3");
		updatedAdmin.setPassword("123");
		updatedAdmin.setMobileNumber("34673647");
		updatedAdmin.setEmail("hdsghdghss");
		updatedAdmin.setAdminId(1);
		
		String updatedName = "admin2";
		
		List<Admin> viewAll = new ArrayList<Admin>();
		viewAll.add(testAdmin);
		viewAll.add(updatedAdmin);
		
		
		
		//creating objects to test trip booking methods in admin service
		TripBooking testBooking = new TripBooking();
		Cab testCab = new Cab();
		testCab.setCarType("car1");
		testCab.setCabId(5);
		testCab.setPerKmRate(10);
		
		testBooking.setBill(50);
		testBooking.setCab(testCab);
		testBooking.setCustomerId(2);
		testBooking.setDistanceInKm(10);
		testBooking.setToLocation("Kolkata");
		testBooking.setFromLocation("Hyderabad");
		
		Cab newCab = new Cab();
		newCab.setCabId(6);
		newCab.setCarType("car2");
		newCab.setPerKmRate(12);
		
		TripBooking Booking = new TripBooking();
		Booking.setBill(70);
		Booking.setCab(newCab);
		Booking.setCustomerId(2);
		Booking.setDistanceInKm(10);
		Booking.setToLocation("Kolkata");
		Booking.setFromLocation("Hyderabad");
		LocalDateTime from = LocalDateTime.of(2022, 11, 01, 15, 30, 00);
		LocalDateTime to = LocalDateTime.of(2022, 11, 01, 16, 30, 00);
		Booking.setFromDateTime(from);
		Booking.setToDateTime(to);
		
		List<TripBooking> viewTrips = new ArrayList();
		viewTrips.add(Booking);
		viewTrips.add(testBooking);
		
		
		List<TripBooking> viewCabWise = new ArrayList<>();
		viewCabWise.add(testBooking);
		
		List<TripBooking> viewDateWise = new ArrayList<>();
		viewDateWise.add(Booking);
		
		//test cases for all the services in dao class
		//inserting driver must return the driver object
		when(adminService.insertAdmin(testAdmin)).thenReturn(testAdmin);
		assertThat(testAdmin).isNotNull();
		
		when(adminService.updateAdminName(1,updatedName)).thenReturn(updatedAdmin);
		assertThat(updatedAdmin).isNotNull();
		//must return list of all admins
		when(adminService.getAllAdmins()).thenReturn(viewAll);
		assertThat(viewAll.size()).isEqualTo(2);
		when(adminService.deleteAdmin(1)).thenReturn(testAdmin);

		//must return list of all the trips
		when(adminService.getAllTrips()).thenReturn(viewTrips);
		assertThat(viewTrips.size()).isEqualTo(2);
		//must return list of trips that matches the given cab id
		when(adminService.getTripsCabwise(6)).thenReturn(viewCabWise);
		assertThat(viewCabWise.size()).isEqualTo(1);
		//must return list of trips that matches the given from and to time
		when(adminService.getTripsDatewise(LocalDateTime.of(2022, 11, 01, 15, 30, 00), LocalDateTime.of(2022, 11, 01, 16, 30, 00))).thenReturn(viewDateWise);
		assertThat(viewDateWise.size()).isEqualTo(1);
	}
	
	
	@Test
	public void testCustomer() throws CustomerNotFoundException, InvalidLoginException {
		//creating objects to test the customer service methods
		Customer testCust = new Customer();
		testCust.setUserId(1);
		testCust.setUsername("cust1");
		testCust.setPassword("123");
		testCust.setMobileNumber("8143965796");
		testCust.setEmail("cust1@gmail.com");
		testCust.setCustomerId(1);
		
		Customer updatedCust = new Customer();
		updatedCust.setUserId(2);
		updatedCust.setUsername("cust1");
		updatedCust.setPassword("789");
		updatedCust.setMobileNumber("990");
		updatedCust.setEmail("123");
		updatedCust.setCustomerId(1);
		
		List<Customer> viewAll = new ArrayList<Customer>();
		viewAll.add(testCust);
		viewAll.add(updatedCust);
		
		String uname="cust1";
		String pword="789";
		
		//must return the same object that is inserted
		when(custService.insertCustomer(testCust)).thenReturn(testCust);
		assertThat(testCust).isNotNull();
		//must return the updated object
		when(custService.updateCustomer(testCust.getUserId(), updatedCust)).thenReturn(updatedCust);
		assertThat(updatedCust).isNotNull();
		//returns the customer based on id
		when(custService.viewCustomer(1)).thenReturn(testCust);
		assertThat(testCust).isNotNull();
	
		when(custService.deleteCustomer(testCust.getUserId())).thenReturn(testCust);
		//must return the list of all customers
		when(custService.viewCustomers()).thenReturn(viewAll);
		assertThat(viewAll.size()).isEqualTo(2);
		//must return the valid customer
		when(custService.validateCustomer(uname, pword)).thenReturn(updatedCust);	
		assertThat(updatedCust).isNotNull();
	}
	
	

}

package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cab_table")
public class Cab {
	
	@Id
	private int cabId;
	
	@NotNull(message="Car Type cannot be Empty")
	private String carType;
	
	@NotNull(message="Rate per Km cannot be Empty")
	private float perKmRate;
	
//	@OneToMany(mappedBy="cab")
//	private List<TripBooking> trips;
//	public List<TripBooking> getTrips() {
//		return trips;
//	}
//	public void setTrips(List<TripBooking> trips) {
//		this.trips = trips;
//	}
	
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
}
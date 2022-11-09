package com.entities;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="cab_table")
public class Cab {
	@Id
	@GeneratedValue
	private int cabId;
	private String carType;
	private float perKmRate;

	@OneToMany(mappedBy="cab")
	private List<TripBooking> trips;
	public List<TripBooking> getTrips() {
		return trips;
	}
	public void setTrips(List<TripBooking> trips) {
		this.trips = trips;
	}
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
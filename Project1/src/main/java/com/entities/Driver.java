package com.entities;

import javax.persistence.*;

@Entity
@Table(name="driver_table")
public class Driver extends AbstractUser {
//	@Id
//	@GeneratedValue
	private int driverId;
	private String licenseNo;
	
	@OneToOne
	private Cab cab;
	private float rating;
	
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
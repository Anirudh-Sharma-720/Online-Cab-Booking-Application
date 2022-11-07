package com.entities;

import javax.persistence.*;

@Entity
public class Driver extends AbstractUser {
	@Id
	@Column(name="driver_id")
	private int driverId;
	@Column(name="license_no")
	private String licenseNo;
	@Column(name="cab")
	private Cab cab;
	@Column(name="rating")
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
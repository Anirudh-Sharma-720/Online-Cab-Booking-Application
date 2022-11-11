package com.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="driver_table")
public class Driver extends AbstractUser {

	@NotNull(message="Diver id cannot be null")
	private int driverId;
	
	
	@NotNull(message="License number cannot be null")@Pattern(regexp="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$", message="please provide a valid license number")
	private String licenseNo;
	
	@NotNull(message="Please provide cab details for the driver")
	@OneToOne
	private Cab cab;
	
	@NotNull(message="Driver rating cannot be null")
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
	
	/*
	public Driver(@NotNull(message = "Diver id cannot be null") int driverId,
			@NotNull(message = "License number cannot be null") @Pattern(regexp = "^(([A-Z]{2}[0-9]{2})()|([A-Z]{2}-[0-9]{2}))((19\u0010)[0-9][0-9])[0-9]{7}$") String licenseNo,
			@NotNull(message = "Please provide cab details for the driver") Cab cab,
			@NotNull(message = "Driver rating cannot be null") @Size(min = 1, max = 5, message = "Invalid rating") float rating) {
		super();
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	} */
	
	
	
}
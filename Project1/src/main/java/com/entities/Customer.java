package com.entities;
import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name="customer_table")
public class Customer extends AbstractUser {

	@NotNull(message="Customer id cannot be null")
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}

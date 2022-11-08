package com.entities;
import javax.persistence.*;
@Entity
@Table(name="customer_table")
public class Customer extends AbstractUser {
//	@Id
//	@GeneratedValue
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}

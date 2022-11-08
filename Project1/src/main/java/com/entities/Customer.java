package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "customer_table")
public class Customer extends AbstractUser {
	
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	public Customer() {
		super();
	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_table")
public class Customer {
	@Id
	private Integer custId;
	@Column(name = "cust_name")
	private String custName;
	
	public Customer() {
		super();
	}

	public Customer(Integer custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	
	

}

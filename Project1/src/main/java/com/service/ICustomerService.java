package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Customer;
import com.exception.CustomerNotFoundException;
import com.exception.InvalidLoginException;

public interface ICustomerService {
	 
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Integer id) throws CustomerNotFoundException;
	public List<Customer>viewCustomers();
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException,InvalidLoginException;
	
}
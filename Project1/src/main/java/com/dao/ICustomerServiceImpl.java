package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.entities.Customer;
import com.exception.CustomerNotFoundException;
import com.exception.InvalidLoginException;
import com.repository.ICustomerRepository;
import com.service.ICustomerService;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepo;
	
	// 1.Inserting a customer
	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	//2.updating the customer
	@Override
	public Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException  {
		Customer customerObj = customerRepo.findById(id)
				.orElseThrow( () -> new CustomerNotFoundException("customer with customerId: " + id + " doesn't exist") );
		customerObj.setUsername(customer.getUsername());
		customerObj.setPassword(customer.getPassword());
		customerObj.setEmail(customer.getEmail());
		customerObj.setMobileNumber(customer.getMobileNumber());
		customerObj.setCustomerId(customer.getCustomerId());
		
		return customerRepo.save(customerObj);
	}
	
	//3.delete a customer by id
	@Override
	public Customer deleteCustomer(Integer id) throws CustomerNotFoundException {
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer with customerId: " + id + " doesn't exist"));
		customerRepo.deleteById(id);
		return customer;
	}
	
	//4.view list of all the customers.
	@Override
	public List<Customer> viewCustomers() {
		return customerRepo.findAll();
	}
	
	//5.view customer by id
	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		 return customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("customer with customerId: " + customerId + " doesn't exist"));
	}
	
	//6.vaidate the customer
	@Override
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException, InvalidLoginException {
		
		Customer customer = customerRepo.findByUserName(username).orElseThrow(() -> new CustomerNotFoundException("customer with username: " + username + " doesn't exist"));
		
		if(customer.getPassword().equals(password)) {
			return customer;
		}else {
			throw new InvalidLoginException("Invalid Login Credentials, Password doesn't match");
		}
	}

	

}
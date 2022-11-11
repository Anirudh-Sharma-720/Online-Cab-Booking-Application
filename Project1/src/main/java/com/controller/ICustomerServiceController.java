package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.exception.CustomerNotFoundException;
import com.exception.InvalidLoginException;
import com.service.ICustomerService;

@RestController
@RequestMapping("/service/customer-service/")
@CrossOrigin(origins = "*")
public class ICustomerServiceController {
	
	Logger log = LoggerFactory.getLogger(ICustomerServiceController.class);
	@Autowired
	private ICustomerService customerService;
	
	//1.Create and insert new employee
		@PostMapping("/customers")
		public Customer createCustomer(@Valid @RequestBody Customer customer) {
			Customer c = customerService.insertCustomer(customer);
			if(c!=null) log.info("Customer created!");
			else log.info("Failed to create customer");
			return c;
		}
		
	//2.update customer
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable Integer id,@RequestBody Customer customer) throws CustomerNotFoundException{
		Customer updatedCust = customerService.updateCustomer(id, customer);
		if(updatedCust!=null) log.info("Customer updated!");
		else log.info("Failed to update customer!");
		return ResponseEntity.ok(updatedCust);
	}
	
	//3. Delete customer
	@DeleteMapping("customers/{id}")
	public Customer deleteCustomer(@PathVariable Integer id) throws CustomerNotFoundException {
		Customer c = customerService.deleteCustomer(id);
		if(c!=null) log.info("Customer deleted!");
		else log.info("Failed to delete customer!");
		return c;
	}
	
	
	//4.view all customers
	@GetMapping("/customers")
	public List<Customer> viewAllCustomer() {
		List<Customer> clist = customerService.viewCustomers();
		if(clist.size()!=0) log.info("List of customers extracted!");
		else log.info("Failed to extract the list of customers");
		return clist;
	}
	
	//5.get customer by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws CustomerNotFoundException{
		Customer custObj = customerService.viewCustomer(id);
		if(custObj!=null) log.info("Customer extracted from the given id!");
		else log.info("Failed to extract customer by id!");
		return ResponseEntity.ok(custObj);
	}
	
	//6. Validate customer
	@GetMapping("/customers/validate/{userName}&{password}")
	public Customer validateCustomer(@PathVariable String userName,@PathVariable String password) throws CustomerNotFoundException, InvalidLoginException {
		Customer c = customerService.validateCustomer(userName, password);
		if(c!=null) log.info("Customer validated!");
		else log.info("Failed to validate customer!");
		return c;
	}
	
	

}
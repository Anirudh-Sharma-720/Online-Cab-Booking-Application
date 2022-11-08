package com.controller;

import java.util.List;

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
	
	@Autowired
	private ICustomerService customerService;
	
	//1.Create and insert new employee
		@PostMapping("/customers")
		public Customer createCustomer(@RequestBody Customer customer) {
			return customerService.insertCustomer(customer);
		}
		
	//2.update customer
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer) throws CustomerNotFoundException{
		Customer updatedCust = customerService.updateCustomer(id, customer);
		return ResponseEntity.ok(updatedCust);
	}
	
	//3. Delete customer
	@DeleteMapping("customers/{id}")
	public Customer deleteCustomer(@PathVariable Integer id) throws CustomerNotFoundException {
		return customerService.deleteCustomer(id);
	}
	
	
	//4.view all customers
	@GetMapping("/customers")
	public List<Customer> viewAllCustomer() {
		return customerService.viewCustomers();
	}
	
	//5.get customer by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws CustomerNotFoundException{
		Customer custObj = customerService.viewCustomer(id);
		return ResponseEntity.ok(custObj);
	}
	
	//6. Validate customer
	@GetMapping("/customers/validate/{userName}&{password}")
	public Customer validateCustomer(@PathVariable String userName,@PathVariable String password) throws CustomerNotFoundException, InvalidLoginException {
		return customerService.validateCustomer(userName, password);
	}
	
	

}

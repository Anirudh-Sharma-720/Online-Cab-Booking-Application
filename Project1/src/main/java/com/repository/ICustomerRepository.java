package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Customer;
import com.exception.CustomerNotFoundException;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	@Query(value="select c from Customer c where c.username=?1")
	public Optional<Customer> findByUserName(String name);
	
	
//	public Customer insertCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//	public List<Customer>viewCustomers() throws CustomerNotFoundException;
//	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
//	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}
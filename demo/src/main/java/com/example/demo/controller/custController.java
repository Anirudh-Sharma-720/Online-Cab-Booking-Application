package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;

@RestController
@RequestMapping("/app/")
public class custController {
	
	@Autowired
	private CustomerRepo custRepo;
	
	@GetMapping("/custs")
	public List<Customer> viewAllCustomers(){
		return custRepo.findAll();
	}

}

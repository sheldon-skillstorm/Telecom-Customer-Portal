package com.teleskill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teleskill.beans.Customer;
import com.teleskill.service.CustomerService;


@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	public CustomerController() {
		System.out.println("Controller created!");
		
	}
	
	@PostMapping("/teleskill/customers")
	public ResponseEntity<Customer> save( @RequestBody Customer customer) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(customer) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/teleskill/customers")
	public ResponseEntity<List<Customer>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<Customer>>(service.findAll() ,HttpStatus.OK);
		
	}

}

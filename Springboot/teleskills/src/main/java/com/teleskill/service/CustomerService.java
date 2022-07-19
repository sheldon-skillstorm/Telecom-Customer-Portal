package com.teleskill.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleskill.beans.Customer;
import com.teleskill.data.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public CustomerService() {
		System.out.println("Service created");
	}
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
	public List<Customer> findAll(){
		return repository.findAll();
	}

}


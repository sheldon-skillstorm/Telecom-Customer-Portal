package com.teleskill.service;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleskill.beans.Bill;
import com.teleskill.data.BillRepository;





@Service
public class BillService {
	
	@Autowired
	private BillRepository repository;
	
	public BillService() {
		System.out.println("Service created");
	}
	
	public Bill save(Bill bill) {
		return repository.save(bill);
	}
	
	public List<Bill> findAll(){
		return repository.findAll();
	}

}

package com.teleskill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teleskill.beans.Bill;

import com.teleskill.service.BillService;



@RestController
public class BillController {
	
	@Autowired
	private BillService service;
	
	public BillController() {
		System.out.println("Controller created!");
	}
	
	@PostMapping("/teleskill/bills")
	public ResponseEntity<Bill>  save(@RequestBody Bill bill) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(bill) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/teleskill/bills")
	public ResponseEntity<List<Bill>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<Bill>>(service.findAll() ,HttpStatus.OK);
	}
	
	@GetMapping("/teleskill/bills/{id}")
	public ResponseEntity<Bill>  getBill(@PathVariable int id) {
		//System.out.println("name: " + name);
		return new ResponseEntity<Bill> (service.find(id),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/teleskill/bills/{id}")
	public void deleteBill(@PathVariable int id){
		 service.delete(id) ;
	}
	
	@PutMapping("/teleskill/bills/{id}")
	public ResponseEntity<Bill>  update(@RequestBody Bill bill, @PathVariable int id) {
		
		return new ResponseEntity<Bill> (service.update(bill, id),HttpStatus.OK) ;
	}
}

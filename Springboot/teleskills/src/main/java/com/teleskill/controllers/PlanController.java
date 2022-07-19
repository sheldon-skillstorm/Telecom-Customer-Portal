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
import com.teleskill.beans.Plan;
import com.teleskill.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	private PlanService service;
	
	public PlanController() {
		System.out.println("Controller created!");
	}
	
	@PostMapping("/teleskill/plans")
	public ResponseEntity<Plan>  save(@RequestBody Plan plan) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(plan) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/teleskill/plans")
	public ResponseEntity<List<Plan>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<Plan>>(service.findAll() ,HttpStatus.OK);
	}
}

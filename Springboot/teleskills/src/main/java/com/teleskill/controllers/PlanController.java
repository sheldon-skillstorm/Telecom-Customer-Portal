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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 
import com.teleskill.beans.Plan;
import com.teleskill.service.PlanService;

@RestController
@RequestMapping("/plans/v1")
public class PlanController {
	
	@Autowired
	private PlanService service;
	
	public PlanController() {
		System.out.println("Controller created!");
	}
	
	@PostMapping
	public ResponseEntity<Plan>  save(@RequestBody Plan plan) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(plan) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Plan>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<Plan>>(service.findAll() ,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Plan>  getPlan(@PathVariable int id) {
		return new ResponseEntity<Plan> (service.find(id),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/{id}")
	public void deletePlan(@PathVariable int id){
		 service.delete(id) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Plan>  update(@RequestBody Plan plan, @PathVariable int id) {
		
		return new ResponseEntity<Plan> (service.update(plan, id),HttpStatus.OK) ;
	}
}

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
import com.teleskill.beans.User;
import com.teleskill.service.PlanService;
import com.teleskill.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	public UserController() {
		System.out.println("Controller created!");
	}
	
	@PostMapping
	public ResponseEntity<User>  save(@RequestBody User user) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(user) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<User>>(service.findAll() ,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User>  getUser(@PathVariable int id) {
		return new ResponseEntity<User> (service.find(id),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id){
		 service.delete(id) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User>  update(@RequestBody User user, @PathVariable int id) {
		
		return new ResponseEntity<User> (service.update(user, id),HttpStatus.OK) ;
	}

}

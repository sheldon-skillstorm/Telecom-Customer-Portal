package com.teleskill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teleskill.beans.Device;
import com.teleskill.service.DeviceService;

@RestController
public class DeviceController {
	
	
	@Autowired
	private DeviceService service;
	
	
	public DeviceController() {
		System.out.println("Controller created!");
		
	}
	
	@PostMapping("/teleskill/devices")
	public ResponseEntity<Device> save( @RequestBody Device device) {
		System.out.println("Post called");
		return new ResponseEntity<>(service.save(device) ,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/teleskill/devices")
	public ResponseEntity<List<Device>> findAll() {
		System.out.println("Get called");
		return new ResponseEntity<List<Device>>(service.findAll() ,HttpStatus.OK);
		
	}

}

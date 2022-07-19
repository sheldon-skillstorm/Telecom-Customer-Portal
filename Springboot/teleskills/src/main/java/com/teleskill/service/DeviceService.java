package com.teleskill.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleskill.beans.Device;

import com.teleskill.data.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository repository;
	
	public DeviceService() {
		System.out.println("Service created");
	}
	
	public Device save(Device device) {
		return repository.save(device);
	}
	
	public List<Device> findAll(){
		return repository.findAll();
	}
	public Device find(int id) {
		return repository.findById(id).get();
	}
	
	public void delete(int id) {
		 repository.deleteById(id);
	}
	
	public Device update( Device device, int id) {
		 return repository.save(device);
	}

}


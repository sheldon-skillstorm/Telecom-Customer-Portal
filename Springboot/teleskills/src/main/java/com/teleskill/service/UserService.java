package com.teleskill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleskill.beans.Plan;
import com.teleskill.beans.User;
import com.teleskill.data.PlanRepository;
import com.teleskill.data.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public UserService() {
		System.out.println("Service created");
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User find(int id) {
		return repository.findById(id).get();
	}
	
	public void delete(int id) {
		 repository.deleteById(id);
	}
	
	public User update(User user, int id) {
		 return repository.save(user);
	}

}

package com.teleskill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleskill.beans.Plan;
import com.teleskill.data.PlanRepository;


@Service
public class PlanService {
	
	@Autowired
	private PlanRepository repository;
	
	public PlanService() {
		System.out.println("Service created");
	}
	
	public Plan save(Plan plan) {
		return repository.save(plan);
	}
	
	public List<Plan> findAll(){
		return repository.findAll();
	}

}

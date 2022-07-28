//package com.teleskill.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.teleskill.beans.ActivePlan;
//import com.teleskill.data.ActivePlanRepository;
//
//@Service
//public class ActivePlanService {
//	
//	
//	@Autowired
//	private ActivePlanRepository repository;
//	
//
//	public ActivePlanService() {
//		repository.findAll();
//	}
//	
//	public ActivePlan save(ActivePlan activePlan) {
//		return repository.save(activePlan);
//	}
//	
//	public List<ActivePlan> findAll(){
//		return repository.findAll();
//	}
//	public ActivePlan find(int id) {
//		return repository.findById(id).get();
//	}
//	
//	public void delete(int id) {
//		 repository.deleteById(id);
//	}
//	
//	public ActivePlan update(ActivePlan activePlan, int id) {
//		 return repository.save(activePlan);
//	}
//
//}
//	



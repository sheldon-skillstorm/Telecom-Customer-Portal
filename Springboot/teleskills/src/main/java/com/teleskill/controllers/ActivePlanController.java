//package com.teleskill.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.teleskill.beans.ActivePlan;
//import com.teleskill.beans.Bill;
//import com.teleskill.service.ActivePlanService;
//import com.teleskill.service.BillService;
//
//@RestController
//@RequestMapping("/activePlans/v1")
//public class ActivePlanController {
//	
//
//	@Autowired
//	private ActivePlanService service;
//	
//	public ActivePlanController() {
//		System.out.println("Controller created!");
//	}
//	
//	@PostMapping
//	public ResponseEntity<ActivePlan>  save(@RequestBody ActivePlan activePlan) {
//		System.out.println("Post called");
//		return new ResponseEntity<>(service.save(activePlan) ,HttpStatus.CREATED);
//		
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<ActivePlan>> findAll() {
//		System.out.println("Get called");
//		return new ResponseEntity<List<ActivePlan>>(service.findAll() ,HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<ActivePlan>  getActivePlan(@PathVariable int id) {
//		
//		return new ResponseEntity<ActivePlan> (service.find(id),HttpStatus.OK) ;
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteActivePlan(@PathVariable int id){
//		 service.delete(id) ;
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<ActivePlan>  update(@RequestBody ActivePlan activePlan, @PathVariable int id) {
//		
//		return new ResponseEntity<ActivePlan> (service.update(activePlan, id),HttpStatus.OK) ;
//	}
//
//}

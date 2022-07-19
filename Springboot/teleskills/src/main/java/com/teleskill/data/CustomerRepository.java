package com.teleskill.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teleskill.beans.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {  
	
}

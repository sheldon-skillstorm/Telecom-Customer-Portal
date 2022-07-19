package com.teleskill.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teleskill.beans.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer>{

}

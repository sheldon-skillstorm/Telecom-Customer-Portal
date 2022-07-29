package com.teleskill.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.teleskill.beans.ActivePlan;

@Repository
public interface ActivePlanRepository extends JpaRepository<ActivePlan,Integer>{

}

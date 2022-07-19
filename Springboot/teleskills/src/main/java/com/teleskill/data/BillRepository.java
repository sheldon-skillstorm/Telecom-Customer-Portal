package com.teleskill.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teleskill.beans.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer>{

}

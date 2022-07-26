package com.teleskill.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
	private String name;
    @Column
	private int price;
    
    @ManyToOne
	@JoinColumn(name = "customerid")
	//@JsonManagedReference("ownerVehicles")
	private Customer customer;
	
	public Device() {
		super();
	}
	

	public Device(int id, String name, int price, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", price=" + price + ", customer=" + customer + "]";
	}


	
	
	
}

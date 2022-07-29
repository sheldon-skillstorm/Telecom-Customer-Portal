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
	@Column
	private String number;
	
	public Device() {
		super();
	}
	

	public Device(int id, String name, int price, String number) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;	
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
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + "]";
	}


	
	
	
}

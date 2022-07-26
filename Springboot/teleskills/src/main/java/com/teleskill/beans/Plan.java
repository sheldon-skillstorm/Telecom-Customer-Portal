package com.teleskill.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Column
	private String data;
	
	@Column
	private String hotspot;
	
	@Column
	private String streaming;
	
	@Column
	private int devicelimit;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	//@JsonManagedReference("ownerVehicles")
	private Customer customer;
	
	public Plan() {
		super();
		
	}


	public Plan(int id, String name, double price, String data, String hotspot, String streaming, int devicelimit,
			Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.data = data;
		this.hotspot = hotspot;
		this.streaming = streaming;
		this.devicelimit = devicelimit;
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHotspot() {
		return hotspot;
	}


	public void setHotspot(String hotspot) {
		this.hotspot = hotspot;
	}


	public String getStreaming() {
		return streaming;
	}


	public void setStreaming(String streaming) {
		this.streaming = streaming;
	}


	public int getDevicelimit() {
		return devicelimit;
	}


	public void setDevicelimit(int devicelimit) {
		this.devicelimit = devicelimit;
	}
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", price=" + price + ", data=" + data + ", hotspot=" + hotspot
				+ ", streaming=" + streaming + ", devicelimit=" + devicelimit + ", customer=" + customer + "]";
	}
	
	



	
	
	
	
}

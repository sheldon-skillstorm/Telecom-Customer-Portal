package com.teleskill.beans;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




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
	
	@OneToMany(mappedBy = "plans")
	@JsonIgnore
	 Set<ActivePlan> plan;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(data, devicelimit, hotspot, id, name, price, streaming);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		return Objects.equals(data, other.data) && devicelimit == other.devicelimit
				&& Objects.equals(hotspot, other.hotspot) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(streaming, other.streaming);
	}



	public Plan() {
		super();
		
	}

	

	public Plan(int id, String name, double price, String data, String hotspot, String streaming, int devicelimit
			,Set<ActivePlan> plan) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.data = data;
		this.hotspot = hotspot;
		this.streaming = streaming;
		this.devicelimit = devicelimit;
		this.plan = plan;
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
	
	


	public Set<ActivePlan> getPlan() {
		return plan;
	}


	public void setPlan(Set<ActivePlan> plan) {
		this.plan = plan;
	}
	
	







	
	



	
	
	
	
}

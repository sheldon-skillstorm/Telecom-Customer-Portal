package com.teleskill.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "activeplan")
public class ActivePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonIgnore
	User users;
		
	@Override
	public int hashCode() {
		return Objects.hash(id, plans, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivePlan other = (ActivePlan) obj;
		return id == other.id && Objects.equals(plans, other.plans) && Objects.equals(users, other.users);
	}

	@ManyToOne
	@JoinColumn(name = "planid")
	Plan plans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Plan getPlans() {
		return plans;
	}

	public void setPlans(Plan plans) {
		this.plans = plans;
	}
	
	public ActivePlan() {
		super();
		
	}

	public ActivePlan(int id, User users, Plan plans) {
		super();
		this.id = id;
		this.users = users;
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "ActivePlan [id=" + id + ", users=" + users + ", plans=" + plans + "]";
	}
	
	

	
	
	


}

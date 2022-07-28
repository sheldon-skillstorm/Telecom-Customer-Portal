package com.teleskill.beans;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "users")
public class User implements UserDetails{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	     
	    @Column(nullable = false, length = 50, unique = true)
	    private String username;
	     
	    @Column(nullable = false, length = 64)
	    private String password;
	    
	    @OneToMany(mappedBy = "users")
//	    @JsonIgnore
		Set<ActivePlan> plans;
	    
	    
	    
	 
	    @Override
		public int hashCode() {
			return Objects.hash(id, password, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(id, other.id) && Objects.equals(password, other.password)
					&& Objects.equals(username, other.username);
		}

		public User() { }
	     
	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

		public User(Integer id, String username, String password, Set<ActivePlan> plans) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.plans = plans;
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		public Set<ActivePlan> getPlans() {
			return plans;
		}

		public void setPlans(Set<ActivePlan> plans) {
			this.plans = plans;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", plans" + plans + "]";
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
	     
	    
	}



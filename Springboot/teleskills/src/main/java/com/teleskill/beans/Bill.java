package com.teleskill.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Date invoicedate;
	
	@Column
	private String billingaddress;
	
	@Column
	private String billingcity;
	
	@Column
	private String billingstate;
	
	@Column
	private String billingcountry;
	
	@Column
	private String billingpostalcode;
	
	@Column
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	//@JsonManagedReference("ownerVehicles")
	private Customer customer;
	
	public Bill() {
		super();
		
	}
	
	public Bill(int id, Date invoicedate, String billingaddress, String billingcity, String billingstate,
			String billingcountry, String billingpostalcode, double total, Customer customer) {
		super();
		this.id = id;
		this.invoicedate = invoicedate;
		this.billingaddress = billingaddress;
		this.billingcity = billingcity;
		this.billingstate = billingstate;
		this.billingcountry = billingcountry;
		this.billingpostalcode = billingpostalcode;
		this.total = total;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}

	public String getBillingcity() {
		return billingcity;
	}

	public void setBillingcity(String billingcity) {
		this.billingcity = billingcity;
	}

	public String getBillingstate() {
		return billingstate;
	}

	public void setBillingstate(String billingstate) {
		this.billingstate = billingstate;
	}

	public String getBillingcountry() {
		return billingcountry;
	}

	public void setBillingcountry(String billingcountry) {
		this.billingcountry = billingcountry;
	}

	public String getBillingpostalcode() {
		return billingpostalcode;
	}

	public void setBillingpostalcode(String billingpostalcode) {
		this.billingpostalcode = billingpostalcode;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "Bill [id=" + id + ", invoicedate=" + invoicedate + ", billingaddress=" + billingaddress
				+ ", billingcity=" + billingcity + ", billingstate=" + billingstate + ", billingcountry="
				+ billingcountry + ", billingpostalcode=" + billingpostalcode + ", total=" + total + ", customer="
				+ customer + "]";
	}
	
	
}

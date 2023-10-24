package com.insurance.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Embeddable
//@Entity
//@Table(name="addresses")
public class Address {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long addressId;
	private String addressLine;
	//private String street;
	private String city;
	private String county;
	private String state;
	private String zipcode;
	
	public Address() {
		super();
	}

	public Address(String addressLine, String city, String county, String state, String zipcode) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}

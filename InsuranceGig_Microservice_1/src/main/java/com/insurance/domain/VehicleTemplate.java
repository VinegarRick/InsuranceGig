package com.insurance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicletemplates")
public class VehicleTemplate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String make;
	
	private String model;
	
	private Integer baseValuation;

	public VehicleTemplate() {
		super();
	}

	public VehicleTemplate(Long id, String make, String model, Integer baseValuation) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.baseValuation = baseValuation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getBaseValuation() {
		return baseValuation;
	}

	public void setBaseValuation(Integer baseValuation) {
		this.baseValuation = baseValuation;
	}
	
	
}

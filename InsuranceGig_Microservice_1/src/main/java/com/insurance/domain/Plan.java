package com.insurance.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="plans")
public class Plan {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double premium;
    
    private int numClaims;

    private String username;
    
    @ManyToOne
    private PlanTemplate plantemplate;
    
    
    @ManyToOne
    @JsonBackReference
    private Policy policy;
    
	public Plan() {
		super();
	}

	public Plan(Long id, String name, Double premium, Integer numClaims, PlanTemplate plantemplate, Policy policy, String username) {
		super();
		this.id = id;
		this.name = name;
		this.premium = premium;
		this.numClaims = numClaims;
		this.plantemplate = plantemplate;
		this.policy = policy;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Integer getNumClaims() {
		return numClaims;
	}

	public void setNumClaims(Integer numClaims) {
		this.numClaims = numClaims;
	}

	public PlanTemplate getPlantemplate() {
		return plantemplate;
	}

	public void setPlantemplate(PlanTemplate plantemplate) {
		this.plantemplate = plantemplate;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
    
}

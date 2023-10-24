package com.insurance.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="plans")
public class Plan {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double minPremium;

    private Integer deductible;
    
    private Double maxCoverage;
    
    @Column(length = 2000)
    private String description;

    @ManyToMany(mappedBy="plans")
    @JsonBackReference
    private List<Policy> policies;
    
	public Plan() {
		super();
	}

	public Plan(Long id, String name, Double minPremium, Integer deductible, Double maxCoverage, String description,
			List<Policy> policies) {
		super();
		this.id = id;
		this.name = name;
		this.minPremium = minPremium;
		this.deductible = deductible;
		this.maxCoverage = maxCoverage;
		this.description = description;
		this.policies = policies;
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

	public Double getMinPremium() {
		return minPremium;
	}

	public void setMinPremium(Double minPremium) {
		this.minPremium = minPremium;
	}

	public Integer getDeductible() {
		return deductible;
	}

	public void setDeductible(Integer deductible) {
		this.deductible = deductible;
	}

	public Double getMaxCoverage() {
		return maxCoverage;
	}

	public void setMaxCoverage(Double maxCoverage) {
		this.maxCoverage = maxCoverage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

    
}

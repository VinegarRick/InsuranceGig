package com.insurance.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="plantemplates")
public class PlanTemplate {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Double basePremium;
	
	private Integer deductible;
	
    @Column(length = 2000)
    private String description;
    
    @OneToMany
    private List<Plan> plans;

	public PlanTemplate() {
		super();
	}

	public PlanTemplate(Long id, String name, Double basePremium, Integer deductible, String description,
			List<Plan> plans) {
		super();
		this.id = id;
		this.name = name;
		this.basePremium = basePremium;
		this.deductible = deductible;
		this.description = description;
		this.plans = plans;
	}

	public Long getPlanTemplateId() {
		return id;
	}

	public void setPlanTemplateId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(Double basePremium) {
		this.basePremium = basePremium;
	}

	public Integer getDeductible() {
		return deductible;
	}

	public void setDeductible(Integer deductible) {
		this.deductible = deductible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

    
}

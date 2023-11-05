package com.insurance.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="policies")
public class Policy {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Double totalPremium;
    
    @OneToOne
    private Vehicle vehicle;
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate startDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate endDate;
        
    private String status;
    
    private String username;
    
    @OneToMany
    private List<Plan> plans;

    //@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    /*@ManyToMany
    @JoinTable(name = "policy_plan", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "plan_id"))
    @JsonManagedReference
    private List<Plan> plans;*/

	public Policy() {
		super();
	}

	public Policy(Long id, Double totalPremium, Vehicle vehicle, LocalDate startDate, LocalDate endDate, String status,
			String username, List<Plan> plans) {
		super();
		this.id = id;
		this.totalPremium = totalPremium;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.username = username;
		this.plans = plans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(Double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	
}

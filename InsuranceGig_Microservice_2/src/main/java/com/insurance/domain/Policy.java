package com.insurance.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="policies")
public class Policy {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long driverId;
    
    private Long vehicleId;

    private Double premium;
    
    private Date startDate;
    
    private Date endDate;
    
    private int faultRecord;
    
    private String status; // need to add to getters/setters/constructor

    //@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "policy_plan", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "plan_id"))
    @JsonManagedReference
    private List<Plan> plans;

	public Policy() {
		super();
	}

	public Policy(Long id, Long driverId, Long vehicleId, Double premium, Date startDate, Date endDate, int faultRecord,
			List<Plan> plans) {
		super();
		this.id = id;
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.faultRecord = faultRecord;
		this.plans = plans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getFaultRecord() {
		return faultRecord;
	}

	public void setFaultRecord(int faultRecord) {
		this.faultRecord = faultRecord;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

}

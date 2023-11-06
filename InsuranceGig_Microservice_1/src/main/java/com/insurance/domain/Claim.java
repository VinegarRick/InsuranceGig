package com.insurance.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate accidentDate;
    
    private String accidentLocation;
    
    private String description;
    
    private String status;
    
    private double repairPrice;
        
    private String username;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "claim_id")
    private List<ClaimImage> images = new ArrayList<>();

	public Claim() {
		super();
	}

	public Claim(Long id, LocalDate accidentDate, String accidentLocation, String description, String status,
			double repairPrice, String username, Vehicle vehicle, List<ClaimImage> images) {
		super();
		this.id = id;
		this.accidentDate = accidentDate;
		this.accidentLocation = accidentLocation;
		this.description = description;
		this.status = status;
		this.repairPrice = repairPrice;
		this.username = username;
		this.vehicle = vehicle;
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(LocalDate accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getAccidentLocation() {
		return accidentLocation;
	}

	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getRepairPrice() {
		return repairPrice;
	}

	public void setRepairPrice(double repairPrice) {
		this.repairPrice = repairPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<ClaimImage> getImages() {
		return images;
	}

	public void setImages(List<ClaimImage> images) {
		this.images = images;
	}

    
}

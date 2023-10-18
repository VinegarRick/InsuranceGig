package com.insurance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;
    
    private String make;
    
    private String model;
       
    private String year;
    
    private Integer mileage;

    //@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    //private List<Claim> claims = new ArrayList<>();
    
	public Vehicle() {
		super();
	}

	public Vehicle(Long id, String vin, String make, String model, String year, Integer mileage) {
		super();
		this.id = id;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	
    
}

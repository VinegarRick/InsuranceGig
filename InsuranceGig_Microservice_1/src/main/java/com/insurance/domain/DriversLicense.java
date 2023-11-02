package com.insurance.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="driverslicenses")
public class DriversLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	
    
    @Lob
    private byte[] driversLicense;
    
	private String licenseNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate expirationDate;
	
	private String username;

	public DriversLicense() {
		super();
	}

	public DriversLicense(Long id, byte[] driversLicense, String licenseNumber, LocalDate expirationLocalDate, String username) {
		super();
		this.id = id;
		this.driversLicense = driversLicense;
		this.licenseNumber = licenseNumber;
		this.expirationDate = expirationLocalDate;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(byte[] driversLicense) {
		this.driversLicense = driversLicense;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public LocalDate getExpirationLocalDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationLocalDate) {
		this.expirationDate = expirationLocalDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

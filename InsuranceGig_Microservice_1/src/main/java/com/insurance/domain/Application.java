package com.insurance.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="applications")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long applicationId;
	
	private String status;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String addressLine;
	
	private String city;
	
	private String county;
	
	private String zipcode;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate dateOfBirth;
	
	private String gender;
	
	private String licenseNo;
	
	private String ssn;
	
	private String vin;
	
	private int carYear;
	
	private String carMake;
	
	private String carModel;
	
	private int carMileage;
	
	//private List<String> plans;
	
	private String plans;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate submittedDate;

	public Application() {
		super();
	}

	public Application(Long applicationId, String status, String username, String firstName, String lastName,
			String addressLine, String city, String county, String zipcode, LocalDate dateOfBirth, String gender,
			String licenseNo, String ssn, String vin, int carYear, String carMake, String carModel, int carMileage,
			String plans, LocalDate submittedDate) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine = addressLine;
		this.city = city;
		this.county = county;
		this.zipcode = zipcode;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.licenseNo = licenseNo;
		this.ssn = ssn;
		this.vin = vin;
		this.carYear = carYear;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carMileage = carMileage;
		this.plans = plans;
		this.submittedDate = submittedDate;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(int carMileage) {
		this.carMileage = carMileage;
	}

	public String getPlans() {
		return plans;
	}

	public void setPlans(String plans) {
		this.plans = plans;
	}

	public LocalDate getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDate submittedDate) {
		this.submittedDate = submittedDate;
	}
	
	
}

package com.insurance.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insurance.domain.Application;
import com.insurance.domain.DriversLicense;
import com.insurance.domain.PaymentInfo;
import com.insurance.service.ApplicationService;
import com.insurance.service.DriversLicenseService;
import com.insurance.service.PaymentInfoService;

@RestController
public class Microservice1Controller {

	@Autowired ApplicationService applicationService;
	@Autowired PaymentInfoService paymentInfoService;
	@Autowired DriversLicenseService driversLicenseService;
	
	@PostMapping(value="/saveApplication")
	public Application saveApplication(@RequestBody Application application) {
		System.out.println("saving application...");
		
		Application existingApplication = applicationService.findApplicationByUsername(application.getUsername());
		if (existingApplication != null) {
			if (existingApplication.getStatus() == "pending" || existingApplication.getStatus() == "approved") {
				return existingApplication;
			} else {
				existingApplication.setStatus("pending");
				existingApplication.setFirstName(application.getFirstName());
				existingApplication.setLastName(application.getLastName());
				existingApplication.setAddressLine(application.getAddressLine());
				existingApplication.setCity(application.getCity());
				existingApplication.setCounty(application.getCounty());
				existingApplication.setZipcode(application.getZipcode());
				existingApplication.setDateOfBirth(application.getDateOfBirth());
				existingApplication.setGender(application.getGender());
				existingApplication.setLicenseNo(application.getLicenseNo());
				existingApplication.setSsn(application.getSsn());
				existingApplication.setVin(application.getVin());
				existingApplication.setCarYear(application.getCarYear());
				existingApplication.setCarMake(application.getCarMake());
				existingApplication.setCarModel(application.getCarModel());
				existingApplication.setCarMileage(application.getCarMileage());
				existingApplication.setPlans(application.getPlans());
				
				return applicationService.save(existingApplication);
			}
		} else {
			return applicationService.save(application);
		}
	}
	
	@PostMapping(value="/savePaymentInfo")
	public PaymentInfo savePaymentInfo(@RequestBody PaymentInfo paymentInfo) {
		System.out.println("saving payment info...");
		
		return paymentInfoService.save(paymentInfo);
	}
	
    @PostMapping(value="/saveDriversLicense")
    public DriversLicense saveDriversLicense(@RequestParam("driversLicense") MultipartFile driversLicense, @RequestParam("licenseNumber") String licenseNumber, @RequestParam("expirationDate") String expirationDate, @RequestParam("username") String username) {
        System.out.println("in /saveDriversLicense of microservice");
    	
    	try {
            byte[] driversLicenseData = driversLicense.getBytes();
            DriversLicense driversLicenseEntity = new DriversLicense();
            driversLicenseEntity.setDriversLicense(driversLicenseData);
            driversLicenseEntity.setLicenseNumber(licenseNumber);
            
            LocalDate parsedExpirationDate = LocalDate.parse(expirationDate);
            
            driversLicenseEntity.setExpirationDate(parsedExpirationDate);
            driversLicenseEntity.setUsername(username);
            
            DriversLicense savedLicense = driversLicenseService.save(driversLicenseEntity);
            
            return savedLicense;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    @GetMapping(value="/findDriversLicenseByUsername/{username}")
    public DriversLicense findDriversLicenseByUsername(@PathVariable String username) {
    	return driversLicenseService.findDriversLicenseByUsername(username);
    }
    
    @GetMapping(value="/findPaymentInfoByUsername/{username}")
    public PaymentInfo findPaymentInfoByUsername(@PathVariable String username) {
    	return paymentInfoService.findPaymentInfoByUsername(username);
    }
    
	@GetMapping(value="/findApplicationByUsername/{username}")
	public Application findApplicationByUsername(@PathVariable String username) {
		System.out.println("fetching application...");
		
		return applicationService.findApplicationByUsername(username);
	}
}

package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.DriversLicense;
import com.insurance.repository.DriversLicenseRepository;

@Service
public class DriversLicenseService {
	
	@Autowired DriversLicenseRepository driversLicenseRepository;
	
	public List<DriversLicense> findAll() {
		return driversLicenseRepository.findAll();
	}

	public DriversLicense save(DriversLicense dl) {
		DriversLicense driversLicense = driversLicenseRepository.save(dl);
		return driversLicense;
	}

	public DriversLicense findDriversLicenseById(long driversLicenseId) {
		Optional<DriversLicense> driversLicense = driversLicenseRepository.findById(driversLicenseId);
		if(driversLicense.isPresent()) {
			return driversLicense.get();
		} else {
			return null;
		}
	}

	public DriversLicense findDriversLicenseByUsername(String username) {
		DriversLicense driversLicense = driversLicenseRepository.findByUsername(username);
		
		return driversLicense;
	}
	
	public void deleteDriversLicenseById(long driversLicenseId) {
		driversLicenseRepository.deleteById(driversLicenseId);
		
	}
}

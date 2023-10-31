package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.DriversLicense;

public interface DriversLicenseRepository extends JpaRepository<DriversLicense, Long> {

	DriversLicense findByUsername(String username);
}

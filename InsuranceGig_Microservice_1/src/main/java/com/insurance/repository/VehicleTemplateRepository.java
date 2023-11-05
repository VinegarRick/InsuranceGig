package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.VehicleTemplate;

public interface VehicleTemplateRepository extends JpaRepository<VehicleTemplate, Long> {
	
	List<VehicleTemplate> findByMake(String make);

	VehicleTemplate findByMakeAndModel(String make, String model);
}

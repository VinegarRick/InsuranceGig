package com.insurance.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.VehicleTemplate;
import com.insurance.repository.VehicleTemplateRepository;

@Service
public class VehicleTemplateService {

	@Autowired VehicleTemplateRepository vehicleTemplateRepository;
	
	public List<String> getCarMakes() {
		List<VehicleTemplate> vehicleTemplates = vehicleTemplateRepository.findAll();
		Set<String> carMakes = new HashSet<>();
		
		for (VehicleTemplate x : vehicleTemplates) {
			carMakes.add(x.getMake());
		}
		
		return new ArrayList<>(carMakes);		
	}
	
	public List<String> getCarModelsByMake(String make) {
		List<VehicleTemplate> vehicleTemplates = vehicleTemplateRepository.findByMake(make);
		List<String> carModels = new ArrayList<>();
		
		for (VehicleTemplate x : vehicleTemplates) {
			carModels.add(x.getModel());
		}
		
		return carModels;
	}
	
	public Integer getBaseValuation(String make, String model) {
		System.out.println("inside getBaseValuation of VehicleTemplateService");
		VehicleTemplate vehicleTemplate = vehicleTemplateRepository.findByMakeAndModel(make, model);
		
		if (vehicleTemplate == null) {
			return 0;
		}
		
		return vehicleTemplate.getBaseValuation();
	}
}

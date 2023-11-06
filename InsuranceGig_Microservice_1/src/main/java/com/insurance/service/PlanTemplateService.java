package com.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.PlanTemplate;
import com.insurance.repository.PlanTemplateRepository;

@Service
public class PlanTemplateService {

	@Autowired PlanTemplateRepository planTemplateRepository;
	
	public PlanTemplate findPlanTemplateByName(String name) {
		PlanTemplate planTemplate = planTemplateRepository.findByNameIgnoreCaseStartingWith(name);
		return planTemplate;
	}
	
	public PlanTemplate findPlanTemplateById(Long id) {
		Optional<PlanTemplate> optValue = planTemplateRepository.findById(id);
		if (optValue.isPresent()) {
			return optValue.get();
		} else {
			return null;
		}		
	}
}

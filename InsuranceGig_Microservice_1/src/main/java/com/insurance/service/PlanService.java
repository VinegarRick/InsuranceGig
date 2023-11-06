package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Plan;
import com.insurance.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired PlanRepository planRepository;
	
	public List<Plan> findAll() {
		return planRepository.findAll();
	}

	public Plan save(Plan pl) {
		Plan plan = planRepository.save(pl);
		return plan;
	}

	public Plan findPlanById(long planId) {
		Optional<Plan> plan = planRepository.findById(planId);
		if(plan.isPresent()) {
			return plan.get();
		} else {
			return null;
		}
	}

	public Plan findPlanByUsername(String username) {
		Plan plan = planRepository.findByUsername(username);
		
		return plan;
	}
	
	public void deletePlanById(long planId) {
		planRepository.deleteById(planId);
		
	}
}

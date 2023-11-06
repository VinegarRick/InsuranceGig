package com.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.PlanTemplate;

public interface PlanTemplateRepository extends JpaRepository<PlanTemplate, Long> {

	PlanTemplate findByNameIgnoreCaseStartingWith(String name);
	
	Optional<PlanTemplate> findById(Long id);
}

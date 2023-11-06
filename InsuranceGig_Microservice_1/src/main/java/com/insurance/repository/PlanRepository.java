package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

	Plan findByUsername(String username);
}

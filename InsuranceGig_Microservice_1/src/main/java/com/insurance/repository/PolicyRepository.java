package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

	Policy findByUsername(String username);
}

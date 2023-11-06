package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	Claim findByUsername(String username);
}

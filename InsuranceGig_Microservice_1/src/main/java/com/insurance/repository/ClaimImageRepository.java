package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.ClaimImage;

public interface ClaimImageRepository extends JpaRepository<ClaimImage, Long> {

}

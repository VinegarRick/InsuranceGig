package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}

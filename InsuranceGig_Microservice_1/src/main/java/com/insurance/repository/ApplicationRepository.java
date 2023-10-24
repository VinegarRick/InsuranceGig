package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}

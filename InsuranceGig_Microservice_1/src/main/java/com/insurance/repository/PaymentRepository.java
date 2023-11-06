package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Payment findByUsername(String username);
}

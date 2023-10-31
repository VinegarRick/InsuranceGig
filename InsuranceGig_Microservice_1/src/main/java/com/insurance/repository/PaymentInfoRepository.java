package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.Application;
import com.insurance.domain.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Integer> {

	PaymentInfo findByUsername(String username);
}

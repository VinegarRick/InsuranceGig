package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Payment;
import com.insurance.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired PaymentRepository paymentRepository;
	
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	public Payment save(Payment a) {
		Payment payment = paymentRepository.save(a);
		return payment;
	}

	public Payment findPaymentById(long paymentId) {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if(payment.isPresent()) {
			return payment.get();
		} else {
			return null;
		}
	}

	public Payment findPaymentByUsername(String username) {
		Payment payment = paymentRepository.findByUsername(username);
		
		return payment;
	}
	
	public void deletePaymentById(long paymentId) {
		paymentRepository.deleteById(paymentId);
		
	}
}

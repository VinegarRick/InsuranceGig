package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.PaymentInfo;
import com.insurance.repository.PaymentInfoRepository;

@Service
public class PaymentInfoService {
	
	@Autowired PaymentInfoRepository paymentInfoRepository;
	
	public List<PaymentInfo> findAll() {
		return paymentInfoRepository.findAll();
	}

	public PaymentInfo save(PaymentInfo pi) {
		PaymentInfo paymentInfo = paymentInfoRepository.save(pi);
		return paymentInfo;
	}

	public PaymentInfo findPaymentInfoById(int paymentInfoId) {
		Optional<PaymentInfo> paymentInfo = paymentInfoRepository.findById(paymentInfoId);
		if(paymentInfo.isPresent()) {
			return paymentInfo.get();
		} else {
			return null;
		}
	}

	public PaymentInfo findPaymentInfoByUsername(String username) {
		PaymentInfo paymentInfo = paymentInfoRepository.findByUsername(username);
		
		return paymentInfo;
	}
	
	public void deletePaymentInfoById(int paymentInfoId) {
		paymentInfoRepository.deleteById(paymentInfoId);
		
	}
}

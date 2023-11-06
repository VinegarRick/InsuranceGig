package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Policy;
import com.insurance.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired PolicyRepository policyRepository;
	
	public List<Policy> findAll() {
		return policyRepository.findAll();
	}

	public Policy save(Policy po) {
		Policy policy = policyRepository.save(po);
		return policy;
	}

	public Policy findPolicyById(long policyId) {
		Optional<Policy> policy = policyRepository.findById(policyId);
		if(policy.isPresent()) {
			return policy.get();
		} else {
			return null;
		}
	}

	public Policy findPolicyByUsername(String username) {
		Policy policy = policyRepository.findByUsername(username);
		
		return policy;
	}
	
	public void deletePolicyById(long policyId) {
		policyRepository.deleteById(policyId);
		
	}
}

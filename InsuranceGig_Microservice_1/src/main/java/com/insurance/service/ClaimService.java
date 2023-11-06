package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Claim;
import com.insurance.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired ClaimRepository claimRepository;
	
	public List<Claim> findAll() {
		return claimRepository.findAll();
	}

	public Claim save(Claim cl) {
		Claim claim = claimRepository.save(cl);
		return claim;
	}

	public Claim findClaimById(long claimId) {
		Optional<Claim> claim = claimRepository.findById(claimId);
		if(claim.isPresent()) {
			return claim.get();
		} else {
			return null;
		}
	}

	public Claim findClaimByUsername(String username) {
		Claim claim = claimRepository.findByUsername(username);
		
		return claim;
	}
	
	public void deleteClaimById(long claimId) {
		claimRepository.deleteById(claimId);
		
	}
}

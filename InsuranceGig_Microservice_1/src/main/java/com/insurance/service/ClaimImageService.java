package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.ClaimImage;
import com.insurance.repository.ClaimImageRepository;

@Service
public class ClaimImageService {

	@Autowired ClaimImageRepository claimImageRepository;
	
	public List<ClaimImage> findAll() {
		return claimImageRepository.findAll();
	}

	public ClaimImage save(ClaimImage ci) {
		ClaimImage claimImage = claimImageRepository.save(ci);
		return claimImage;
	}

	public ClaimImage findClaimImageById(long claimImageId) {
		Optional<ClaimImage> claimImage = claimImageRepository.findById(claimImageId);
		if(claimImage.isPresent()) {
			return claimImage.get();
		} else {
			return null;
		}
	}
	
	public void deleteClaimImageById(long claimImageId) {
		claimImageRepository.deleteById(claimImageId);
		
	}
}

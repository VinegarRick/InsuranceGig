package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.domain.Application;
import com.insurance.repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired ApplicationRepository applicationRepository;
	
	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	public Application save(Application a) {
		Application application = applicationRepository.save(a);
		return application;
	}

	public Application findApplicationById(long applicationId) {
		Optional<Application> application = applicationRepository.findById(applicationId);
		if(application.isPresent()) {
			return application.get();
		} else {
			return null;
		}
	}

	public Application findApplicationByUsername(String username) {
		Application application = applicationRepository.findByUsername(username);
		
		return application;
	}
	
	public void deleteApplicationById(long applicationId) {
		applicationRepository.deleteById(applicationId);
		
	}
	
}

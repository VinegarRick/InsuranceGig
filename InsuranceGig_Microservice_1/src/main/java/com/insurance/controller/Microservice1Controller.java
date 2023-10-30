package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.domain.Application;
import com.insurance.service.ApplicationService;

@RestController
public class Microservice1Controller {

	@Autowired ApplicationService applicationService;
	
	@PostMapping(value="/saveApplication")
	public Application saveApplication(@RequestBody Application application) {
		System.out.println("saving application...");
		
		return applicationService.save(application);
	}
	
	@GetMapping(value="/findApplicationByUsername/{username}")
	public Application findApplicationByUsername(@PathVariable String username) {
		System.out.println("fetching application...");
		
		return applicationService.findApplicationByUsername(username);
	}
}

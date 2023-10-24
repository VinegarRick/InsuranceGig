package com.insurance.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insurance.component.ApplicationComponent;
import com.insurance.component.EmailComponent;
import com.insurance.service.UserService;

import jakarta.transaction.Transactional;

@RestController
public class GatewayController {

	@Autowired ApplicationComponent applicationComponent;
	@Autowired EmailComponent emailComponent;
	@Autowired UserService userService;
	
	@Transactional
	@PostMapping(value="/saveApplication")
	public JsonNode saveApplication(@RequestBody JsonNode payload, Principal principal) {
		//JsonNode applicationData = payload.get("applicationData");
		
		
		String username = principal.getName();
		String emailAddress = userService.findByUserName(username).getEmail();
				
		//((ObjectNode) applicationData).put("userName", username);
		//((ObjectNode) applicationData).put("userEmail", emailAddress);
		
		JsonNode application = applicationComponent.saveApplication(payload);
	    
		//emailComponent.sendEmail(emailAddress, booking);
	    
		return application;
	}
	
	@PostMapping(value = "/sendContactEmail")
	public JsonNode sendContactEmail(@RequestBody JsonNode payload) {
		emailComponent.sendContactEmail(payload);
		
		return payload;
	}

	
	@PostMapping(value="/sendQuoteEmail")
	public JsonNode sendQuoteEmail(@RequestBody JsonNode payload) {
		emailComponent.sendQuoteEmail(payload);
		
		return payload;
	}
}

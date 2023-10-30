package com.insurance.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insurance.component.ApplicationComponent;
import com.insurance.component.EmailComponent;
import com.insurance.domain.User;
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
	
	@GetMapping(value="/findUserByUsername")
	public User findUserByUsername(Principal principal) {
		return userService.findByUserName(principal.getName());
	}
	
	@GetMapping(value="/findApplicationByUsername")
	public JsonNode findApplicationByUsername(Principal principal) {
		JsonNode application = applicationComponent.findApplicationByUsername(principal.getName());
		
		return application;
	}
}

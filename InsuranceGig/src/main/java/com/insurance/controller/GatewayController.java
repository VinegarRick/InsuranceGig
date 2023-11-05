package com.insurance.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insurance.component.ApplicationComponent;
import com.insurance.component.EmailComponent;
import com.insurance.component.PolicyComponent;
import com.insurance.component.ProfileComponent;
import com.insurance.component.VehicleComponent;
import com.insurance.domain.Role;
import com.insurance.domain.User;
import com.insurance.service.RoleService;
import com.insurance.service.UserService;

import jakarta.transaction.Transactional;

@RestController
public class GatewayController {

	@Autowired ApplicationComponent applicationComponent;
	@Autowired EmailComponent emailComponent;
	@Autowired ProfileComponent profileComponent;
	@Autowired VehicleComponent vehicleComponent;
	@Autowired PolicyComponent policyComponent;
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	@Autowired PasswordEncoder passwordEncoder;
	
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
	
	@PostMapping(value="/savePaymentInfo")
	public JsonNode savePaymentInfo(@RequestBody JsonNode payload) {		
		JsonNode paymentInfo = profileComponent.savePaymentInfo(payload);
		
		return paymentInfo;
	}
	
	@GetMapping(value="/findPaymentInfoByUsername")
	public JsonNode findPaymentInfoByUsername(Principal principal) {
		return profileComponent.findPaymentInfoByUsername(principal.getName());
	}
	
	@PostMapping(value = "/saveDriversLicense")
	public JsonNode saveDriversLicense(@RequestParam("driversLicense") MultipartFile driversLicense, @RequestParam("licenseNumber") String licenseNumber, @RequestParam("expirationDate") String expirationDate, @RequestParam("username") String username) throws IOException, ParseException {
		System.out.println("inside saveDriversLicense of GatewayController");
		
	    JsonNode response = profileComponent.saveDriversLicense(driversLicense, licenseNumber, expirationDate, username);

	    return response;
	}

	
	@GetMapping(value="/findDriversLicenseByUsername")
	public JsonNode findDriversLicenseByUsername(Principal principal) {
		return profileComponent.findDriversLicenseByUsername(principal.getName());
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
	
	@GetMapping(value="/findApplicationById/{applicationId}")
	public ResponseEntity<?> findApplicationById(@PathVariable Long applicationId) {
		ResponseEntity<?> response = applicationComponent.findApplicationById(applicationId);
		return response;
	}
	
	@GetMapping(value="/findAllApplications")
	public JsonNode findAllApplications() {
		return applicationComponent.findAllApplications();
	}
	
	@PostMapping(value = "/updateApplicationStatus")
	public ResponseEntity<?> updateApplicationStatus(@RequestBody Map<String, String> payload) {
	    System.out.println("in updateApplicationStatus of GatewayController");
	    ResponseEntity<?> response = applicationComponent.updateApplicationStatus(payload);
	    return response;
	}
	
	@PostMapping(value="/registerUser")
	public User registerUser(@RequestBody JsonNode payload) {
		User existingUser = userService.findByUserName(payload.get("username").asText());
		if (existingUser != null) return null;
		
		User newUser = new User();
		newUser.setUserName(payload.get("username").asText());
		newUser.setEmail(payload.get("email").asText());
		newUser.setCustomerMobile(payload.get("mobile").asText());
		newUser.setUserPassword(passwordEncoder.encode(payload.get("password").asText()));
		
		Role userRole = roleService.findByRoleName("User");
		newUser.getRoles().add(userRole);
		
		User user = userService.save(newUser);
		
		return user;
	}
	
	@PostMapping(value="/saveVehicle")
	public ResponseEntity<?> saveVehicle(@RequestBody JsonNode payload) {
		return vehicleComponent.saveVehicle(payload);
	}
	
	@GetMapping(value="/getCarMakes")
	public ResponseEntity<?> getCarMakes() {
		return vehicleComponent.getCarMakes();
	}
	
	@GetMapping("/getCarModels")
	public ResponseEntity<?> getCarModels(@RequestParam("make") String make) {
	    return vehicleComponent.getCarModelsByMake(make);
	}

	@PostMapping("/savePolicy")
	public ResponseEntity<?> savePolicy(@RequestBody Map<String, String> payload) {
		return policyComponent.savePolicy(payload);
	}
}

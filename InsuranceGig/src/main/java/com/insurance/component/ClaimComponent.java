package com.insurance.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClaimComponent {

	public ResponseEntity<JsonNode> findAllClaims() {
		System.out.println("inside findAllClaims in ClaimComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findAllClaims", Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
	
	public ResponseEntity<JsonNode> findClaimById(Long id) {
		System.out.println("inside findClaimById in ClaimComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findClaimById/" + id, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
	
	public ResponseEntity<JsonNode> updateClaimStatus(Map<String, String> payload) {
	    System.out.println("inside updateClaimStatus of ClaimComponent");

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    Map<String, String> requestPayload = new HashMap<>();
	    requestPayload.put("id", payload.get("id"));
	    requestPayload.put("status", payload.get("status"));

	    HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestPayload, headers);

	    RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/updateClaimStatus", requestEntity, Object.class);
	    Object objects = responseEntity.getBody();

	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

	    return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
}

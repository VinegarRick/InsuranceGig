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
public class ApplicationComponent {

	public JsonNode saveApplication(JsonNode application) {
		System.out.println("inside saveApplication of ApplicationComponent");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<JsonNode> requestEntity = new HttpEntity<>(application, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveApplication", requestEntity, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
				
		
		return returnObj;
	}
	
	public JsonNode findApplicationByUsername(String username) {
		System.out.println("inside getApplicationByUsername of ApplicationComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findApplicationByUsername/" + username, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return returnObj;
	}
	
	public ResponseEntity<JsonNode> findApplicationById(Long applicationId) {
		System.out.println("inside getApplicationById of ApplicationComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findApplicationById/" + applicationId, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
	
	public JsonNode findAllApplications() {
		System.out.println("inside findAllApplications of ApplicationComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findAllApplications", Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return returnObj;
	}
	
	public ResponseEntity<JsonNode> updateApplicationStatus(Map<String, String> payload) {
	    System.out.println("inside updateApplicationStatus of ApplicationComponent");

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    Map<String, String> requestPayload = new HashMap<>();
	    requestPayload.put("applicationId", payload.get("applicationId"));
	    requestPayload.put("status", payload.get("status"));

	    HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestPayload, headers);

	    RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/updateApplicationStatus", requestEntity, Object.class);
	    Object objects = responseEntity.getBody();

	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

	    return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}

}

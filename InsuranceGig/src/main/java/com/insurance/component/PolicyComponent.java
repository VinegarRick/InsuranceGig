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
public class PolicyComponent {
	
	public ResponseEntity<JsonNode> savePolicy(Map<String, String> payload) {
	    System.out.println("inside savePolicy of PolicyComponent");

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    Map<String, String> requestPayload = new HashMap<>();
	    requestPayload.put("username", payload.get("username"));
	    requestPayload.put("plans", payload.get("plans"));
	    requestPayload.put("dob", payload.get("dob"));

	    HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestPayload, headers);

	    RestTemplate restTemplate = new RestTemplate();

	    ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/savePolicy", requestEntity, Object.class);
	    Object objects = responseEntity.getBody();

	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

	    return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
}

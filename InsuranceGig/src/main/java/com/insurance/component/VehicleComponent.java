package com.insurance.component;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class VehicleComponent {
	
	public ResponseEntity<JsonNode> saveVehicle(JsonNode vehicle) {
		System.out.println("inside saveVehicle of VehicleComponent");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<JsonNode> requestEntity = new HttpEntity<>(vehicle, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveVehicle", requestEntity, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
				
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
	
	public ResponseEntity<JsonNode> getCarMakes() {
		System.out.println("inside getCarMakes in VehicleComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getCarMakes", Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
	
	public ResponseEntity<JsonNode> getCarModelsByMake(String make) {
		System.out.println("inside getCarModelsByMake in VehicleComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getCarModelsByMake/" + make, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());
	}
}


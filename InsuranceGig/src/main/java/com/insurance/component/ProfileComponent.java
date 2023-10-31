package com.insurance.component;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProfileComponent {

	public JsonNode savePaymentInfo(JsonNode paymentInfo) {
		System.out.println("inside savePaymentInfo of ProfileComponent");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<JsonNode> requestEntity = new HttpEntity<>(paymentInfo, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/savePaymentInfo", requestEntity, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
				
		
		return returnObj;
	}	
	
    public JsonNode saveDriversLicense(MultipartFile driversLicense, String licenseNumber, Date expirationDate, String username) throws IOException {
    	System.out.println("inside saveDriversLicense of ProfileComponent");
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        
        map.add("driversLicense", new FileSystemResource(convert(driversLicense)));
        map.add("licenseNumber", licenseNumber);
        map.add("expirationDate", expirationDate);
        map.add("username", username);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveDriversLicense", requestEntity, Object.class);

        Object objects = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

        return returnObj;
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }
}

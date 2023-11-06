package com.insurance.component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	public JsonNode findPaymentInfoByUsername(String username) {
		System.out.println("inside findPaymentInfo in ProfileComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findPaymentInfoByUsername/" + username, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return returnObj;
	}
	
    public JsonNode saveDriversLicense(MultipartFile driversLicense, String licenseNumber, String expirationDate, String username) throws IOException {
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
        //File convFile = new File(file.getOriginalFilename());
    	File convFile = File.createTempFile("uploadedFile", null);
        file.transferTo(convFile);
        return convFile;
    }
    
	public JsonNode findDriversLicenseByUsername(String username) {
		System.out.println("inside findApplicationByUsername in ProfileComponent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/findDriversLicenseByUsername/" + username, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		
		return returnObj;
	}
	
	public ResponseEntity<JsonNode> savePayment(JsonNode payment) {
		System.out.println("inside savePayment of ProfileComponent");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<JsonNode> requestEntity = new HttpEntity<>(payment, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/savePayment", requestEntity, Object.class);
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
				
		
		return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());	
	}	
	
	public ResponseEntity<JsonNode> fileClaim(MultipartFile[] claimImages, String accidentDate, String accidentLocation, double repairPrice, String description, String username) throws IOException {
		System.out.println("inside fileClaim of ProfileComponent");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        
        map.add("accidentDate", accidentDate);
        map.add("accidentLocation", accidentLocation);
        map.add("repairPrice", repairPrice);
        map.add("description", description);
        map.add("username", username);
        
        for (MultipartFile claimImage : claimImages) {
            ByteArrayResource resource = new ByteArrayResource(claimImage.getBytes()) {
                @Override
                public String getFilename() {
                    return claimImage.getOriginalFilename();
                }
            };
            map.add("claimImages", resource);
        }
        
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.postForEntity("http://localhost:8383/fileClaim", requestEntity, Object.class);

        Object objects = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

        return new ResponseEntity<>(returnObj, responseEntity.getHeaders(), responseEntity.getStatusCode());	
	}
}

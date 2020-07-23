package com.hackathon.fitnesstracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GoogleFitAPIController {
	
	@Autowired
	RestTemplate restTemp;
	
	
	@GetMapping(value ="/login")
	public String getAPIdata() {
		
		String fitdataURI = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
		ResponseEntity<String> result = restTemp.exchange(fitdataURI, HttpMethod.GET, null, String.class);
		return result.getBody();
	}
	
}

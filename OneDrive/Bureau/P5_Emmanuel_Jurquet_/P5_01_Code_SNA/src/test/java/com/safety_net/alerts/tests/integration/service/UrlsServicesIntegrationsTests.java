package com.safety_net.alerts.tests.integration.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safety_net.alerts.model.Resident;
import com.safety_net.alerts.service.ResidentService;
import com.safety_net.alerts.service.UrlsServices;

@SpringBootTest
public class UrlsServicesIntegrationsTests {

	
	
	@Autowired
	UrlsServices urlsService; 
	
	@Autowired
	ResidentService resService;
	
	
	
	@Test
	 public void findResident () {
		
		
		Resident res = new Resident();
		
		res.setFirstName("Emmanuel");
		res.setLastName("Jurquet");
		res.setAddress("new address");
		
		assertEquals(res.getLastName(), "Jurquet");
		
		
	}
	
	
	
}

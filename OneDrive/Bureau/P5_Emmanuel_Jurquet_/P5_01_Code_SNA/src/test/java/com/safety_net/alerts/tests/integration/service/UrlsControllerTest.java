package com.safety_net.alerts.tests.integration.service;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.safety_net.alerts.service.ResidentService;
import com.safety_net.alerts.service.UrlsServices;

@SpringBootTest
@AutoConfigureMockMvc
public class UrlsControllerTest {


	@Autowired
	MockMvc mvc;

	@MockBean
	UrlsServices urlservices;


	@MockBean
	ResidentService residservice;



	@Test
	void findPersonsByStationNumber () {

		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/firestation?stationNumber=2")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	void findResidentsPhoneByStationNumber () {

		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/phoneAlert?firestation=3")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	void findEmail () {

		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/communityEmail?city=Culver")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	void findListOfResidentsByAddress () {
		
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/fire?address=1509 Culver St")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}		
	}
	@Test 
	void findChildByAddress () {
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/childAlert?address=1509 Culver St")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}		
	}
	@Test
	void  findListOfResidentsByFireStationNumber () {
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/flood/stations?station_number=2")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		
		}
	}
	@Test
	void  personInfo () {
		
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.get("/personInfo?firstName=Jacob&lastName=Boyd")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());	
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		
		}
	}
}

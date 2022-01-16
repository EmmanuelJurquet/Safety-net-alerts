package com.safety_net.alerts.tests.integration.service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.safety_net.alerts.model.Persons;

import com.safety_net.alerts.service.PersonService;

import net.minidev.json.JSONObject;



@SpringBootTest
@AutoConfigureMockMvc
public class PersonsControllerTests {

	
		@Autowired
	    MockMvc mvc;
		
		@MockBean
	    PersonService personService;
	 	
		@BeforeEach
	    public void config() {
	        List<Persons> lPerson = new ArrayList<>();
	        when(personService.list()).thenReturn(lPerson);
	    }
	
		
		@Test
		void getPersons() {
			try {
	            this.mvc.perform(MockMvcRequestBuilders
	                    .get("/persons")
	                    .contentType(MediaType.APPLICATION_JSON))
	                    .andExpect(status().isOk());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		}
		@Test
		void addPersons () {
			JSONObject object = new JSONObject ();
			object.put("firstName" , "Emmanuel");
			object.put("lastName", "Jurquet");
			object.put("address","newaddress");
			object.put("city", "culver");
			object.put("zip", "7510215");
			object.put("phone", "0156987465");
			object.put("email", "e.jurqie@trucbnd");

			
			String jsonString = object.toString();
			
			try {
				this.mvc.perform(MockMvcRequestBuilders
						.post("/persons")
						.content(jsonString)
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
				}catch(Exception e ) {
					System.out.println(e.getMessage());
				}
			
		
		}	
		@Test 
			
		void modifyPersons() {
			
			
			JSONObject object = new JSONObject ();
			object.put("firstName" , "Emmanuel");
			object.put("lastName", "Jurquet");
			object.put("address","newaddress");
			object.put("city", "culver");
			object.put("zip", "7510215");
			object.put("phone", "0156987465");
			object.put("email", "e.jurqie@trucbnd");
			
			
			String jsonString = object.toString();
			
			try {
				this.mvc.perform(MockMvcRequestBuilders
						.put("/persons")
						.content(jsonString)
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
				}catch(Exception e ) {
					System.out.println(e.getMessage());
				}
		}
		
		@Test
		void removePersons() {
			
			try {
				this.mvc.perform(MockMvcRequestBuilders
						.delete("/persons?firstName=Jacob&lastName=Boyd")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
				}catch(Exception e ) {
					System.out.println(e.getMessage());
				}
		}
}

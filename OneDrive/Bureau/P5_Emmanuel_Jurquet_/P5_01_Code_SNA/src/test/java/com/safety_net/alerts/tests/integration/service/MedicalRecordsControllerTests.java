package com.safety_net.alerts.tests.integration.service;

import static org.mockito.Mockito.when;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.safety_net.alerts.model.MedicalRecords;
import com.safety_net.alerts.service.MedicalRecordsService;
@AutoConfigureMockMvc
@SpringBootTest

public class MedicalRecordsControllerTests {

	@Autowired
    MockMvc mvc;
	
	@MockBean
    MedicalRecordsService medicrecordsService;
	
	@BeforeEach
    public void config() {
        List<MedicalRecords> lMedic= new ArrayList<>();
        when(medicrecordsService.list()).thenReturn(lMedic);
    }
	
	@Test
	void getMedicalRecords() {
		try {
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/medicalrecords")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	@Test
	void addMedicalPersons () {
		
		JSONObject object = new JSONObject ();
		
		object.put("firstName","Guillet");
		object.put("lastName","Audrey");
		
		String jsonString = object.toString();
		
		
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.post("/medicalrecords")
					.content(jsonString)
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			}catch(Exception e ) {
				System.out.println(e.getMessage());
			}
		
	
	}	
	@Test 
	void modifyMedicalrecords () {
		
	JSONObject object = new JSONObject ();
		
		object.put("firstName","Audrey");
		object.put("lastName","Guillet");
		
		String jsonObject = object.toString();
		
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.put("/medicalrecords")
					.content(jsonObject)
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			}catch(Exception e ) {
				System.out.println(e.getMessage());
			}
	}
	
	@Test
	void removeMedicalRecords() {
		
		try {
			this.mvc.perform(MockMvcRequestBuilders
					.delete("/medicalrecords?firstName=Audrey&lastName=Guillet")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			}catch(Exception e ) {
				System.out.println(e.getMessage());
			}
	}
}




	


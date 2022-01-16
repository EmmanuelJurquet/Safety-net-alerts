package com.safety_net.alerts.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safety_net.alerts.DAO.IMedicalRecordsDAO;
import com.safety_net.alerts.model.MedicalRecords;
import com.safety_net.alerts.service.MedicalRecordsService;
@SpringBootTest
public class MedicalrecordsServicesListsTests {
	@Autowired
	MedicalRecordsService mService;
	
	@MockBean
	IMedicalRecordsDAO medDAO;
	
	@Test
	public void list() {
		
		List<MedicalRecords> lmedic = new ArrayList<>();
		MedicalRecords medic = new MedicalRecords();
		lmedic.add(medic);
		
		when(medDAO.findAll()).thenReturn(lmedic);
		
		List<MedicalRecords> lResult = mService.list();
		
		
		assertEquals(lmedic.size(), lResult.size());

	}
	@Test 
	public void findChild () {
		
		String lastName = "Boyd";
		
		List<MedicalRecords> lchild = mService.findChild(lastName);
		List<MedicalRecords> lresult = new ArrayList<>();
		
		when (medDAO.findChild(lastName)).thenReturn(lresult);
		
		assertEquals(lchild.size(), lresult.size());
	}
	
} 

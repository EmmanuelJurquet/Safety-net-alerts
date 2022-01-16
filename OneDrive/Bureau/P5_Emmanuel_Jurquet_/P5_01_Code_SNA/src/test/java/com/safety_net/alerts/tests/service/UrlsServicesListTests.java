package com.safety_net.alerts.tests.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safety_net.alerts.DAO.IFireStationsDAO;
import com.safety_net.alerts.DAO.IMedicalRecordsDAO;
import com.safety_net.alerts.DAO.IPersonDAO;
import com.safety_net.alerts.service.ResidentService;
import com.safety_net.alerts.service.UrlsServices;

@SpringBootTest
public class UrlsServicesListTests {
	
	
	@Autowired
	UrlsServices urlsService;
	
	@Autowired
	ResidentService resService;
	
	@MockBean
	IPersonDAO personDAO;
	
	@MockBean
	IFireStationsDAO fireDAO;
	
	@MockBean
	IMedicalRecordsDAO medDAO;
	
	@Test
	public void findPersonsByStationNumber () {
		
		String stationNumber = "2";
		
		List<String> lAddress = fireDAO.findAddressByStationNumber(stationNumber);
		List<String>lAdressTest =  new ArrayList<>();
 		when(fireDAO.findAddressByStationNumber(stationNumber)).thenReturn(lAdressTest);
		
		assertEquals(lAddress.size(), lAdressTest.size());
	}

}

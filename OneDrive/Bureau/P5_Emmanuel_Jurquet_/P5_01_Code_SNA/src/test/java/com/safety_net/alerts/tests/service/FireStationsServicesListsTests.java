package com.safety_net.alerts.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safety_net.alerts.DAO.IFireStationsDAO;
import com.safety_net.alerts.model.FireStations;
import com.safety_net.alerts.service.FireStationsService;

@SpringBootTest
public class FireStationsServicesListsTests {
	
	@Autowired
	FireStationsService fservice;
	
	@MockBean
	IFireStationsDAO fireDAO;
	@Test
	public void list() {
		
		List<FireStations> lfire = new ArrayList<>();
		FireStations fire = new FireStations();
		lfire.add(fire);
		
		when(fireDAO.findAll()).thenReturn(lfire);
		
		List<FireStations> lResult = fservice.list();
		
		
		assertEquals(lfire.size(), lResult.size());
		
	}
	@Test
	public void findAddressByStationNumber() {
		
		String fnumber = "1";
		List<String> findaddress = fservice.findAddressByStationNumber(fnumber);
		List<String> lresult  =  new ArrayList<>();
		
		when(fireDAO.findAddressByStationNumber(fnumber)).thenReturn(lresult);
		
		assertEquals(lresult.size(),findaddress.size());
		
		
	}
	@Test
	public void findStationByAddress () {
		String address = "1509 Culver St";
		List<String> findaddress = fservice.findAddressByStationNumber(address);
		List<String> lresult  =  new ArrayList<>();
		
		when(fireDAO.findAddressByStationNumber(address)).thenReturn(lresult);
		
		assertEquals(lresult.size(),findaddress.size());
		
		
		
	}

}

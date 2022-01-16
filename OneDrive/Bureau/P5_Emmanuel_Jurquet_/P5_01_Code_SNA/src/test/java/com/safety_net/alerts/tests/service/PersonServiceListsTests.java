package com.safety_net.alerts.tests.service;


import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.safety_net.alerts.service.PersonService;
import com.safety_net.alerts.DAO.IPersonDAO;
import com.safety_net.alerts.model.Persons;


@SpringBootTest
public class PersonServiceListsTests {

	@Autowired
	PersonService personService;

	@MockBean
	IPersonDAO personDAO;

 
	@Test
	public void list() {

		List<Persons> lPerson = new ArrayList<>();
		Persons person = new Persons();
		lPerson.add(person);

		when(personDAO.findAll()).thenReturn(lPerson);

		List<Persons> lResult = personService.list();


		assertEquals(lPerson.size(), lResult.size());
	}

	@Test
	public void findPersonsByAddress () {

		String address ="1509 Culver St";
		List<Persons> laddress = personService.findPersonsByAddress(address);
		List<Persons> lPerson = new ArrayList<>();


		when(personDAO.findPersonsByAddress(address)).thenReturn(lPerson);

		assertEquals(laddress.size(),lPerson.size());


	}
	@Test
	public void findPhonesByAddress () {
		String address ="1509 Culver St";
		List<String> lphone = personService.findPhoneByAddress(address);
		List<String> lphonetest = new ArrayList<>();


		when(personDAO.findPhoneByAddress(address)).thenReturn(lphonetest);

		assertEquals(lphone.size(),lphonetest.size());

	}
	@Test
	public void findFamily () {
		String firstName = "Jacob";
		String lastName = "Boyd";

		List<Persons> lfamily = personService.findFamily(firstName, lastName);
		List<Persons> lfamilytest =personService.findFamily(firstName, lastName);

		when (personDAO.findFamily(firstName, lastName)).thenReturn(lfamilytest);
		
		
		assertEquals(lfamily.size(),lfamilytest.size());
	}
	@Test
	public void findEmail () {

		String city = "Culver";
		List<String> lemail = personService.findEmail(city);
		List<String> lemailtest =  new ArrayList<>();

		when(personDAO.findEmail(city)).thenReturn(lemailtest);

		assertEquals(lemail.size(),lemailtest.size());

	}
}
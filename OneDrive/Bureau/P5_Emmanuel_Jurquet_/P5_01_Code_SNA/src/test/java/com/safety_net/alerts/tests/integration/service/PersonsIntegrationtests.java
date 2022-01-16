package com.safety_net.alerts.tests.integration.service;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.service.PersonService;

@SpringBootTest
public class PersonsIntegrationtests {


	@Autowired
	PersonService personService;


	@Test
	public void add() {

		Persons person =  new Persons();
		person.setFirstname("Emmanuel");
		person.setLastname("Jurquet");
		person.setAddress("15 av Zanzibar");
		person.setPhone("0789685747");
		person.setEmail("e.kehett@yahootruc.com");
		person.setZip("4758656");
		person.setCity("culver");

		boolean successAdd = personService.add(person);
		Persons personFind = personService.findPerson("Emmanuel", "Jurquet");


		assertEquals(true, successAdd);
		assertEquals(person, personFind);

	}


	@Test
	public void remove () {

		Persons person = new Persons();

		person.setFirstname("Emmanuel");
		person.setLastname("Jurquet");
		person.setAddress("15 av Zanzibar");
		person.setPhone("0789685747");
		person.setEmail("e.kehett@yahootruc.com");
		person.setZip("4758656");
		person.setCity("culver");

		personService.add(person);
		boolean succesRemove = personService.remove("Emmanuel", "Jurquet");
		Persons personFind = personService.findPerson("Emmanuel", "Jurquet");

		assertEquals(true, succesRemove);
		assertEquals(personFind, null);

	}

	@Test
	public void replace () {


		Persons person = new Persons();

		person.setFirstname("Emmanuel");
		person.setLastname("Jurquet");
		person.setAddress("15 av Zanzibar");
		person.setPhone("0789685747");
		person.setEmail("e.kehett@yahootruc.com");
		person.setZip("4758656");
		person.setCity("culver");

		personService.add(person);

		person.setAddress("16, av Zanzibar");


		personService.replace(person);

		Persons pers =	personService.findPerson("Emmanuel", "Jurquet");

		assertEquals(pers.getAddress(),"16, av Zanzibar");

	}

	@Test
	public void findPerson () {

		Persons person = new Persons();

		person.setFirstname("Emmanuel");
		person.setLastname("Jurquet");
		person.setAddress("15 av Zanzibar");
		person.setPhone("0789685747");
		person.setZip("4758656");
		person.setEmail("e.kehett@yahootruc.com");
		person.setCity("culver");

		personService.add(person);

		assertEquals(personService.findPerson("Emmanuel" , "Jurquet"),person);
	}

	@Test
	public void findFamily () {

		Persons person = new Persons();

		person.setFirstname("Audrey");
		person.setLastname("Jurquet");
		person.setAddress("15 av Zanzibar");
		person.setPhone("0789685747");
		person.setZip("4758656");
		person.setEmail("e.kehett@yahootruc.com");
		person.setCity("culver");

		personService.add(person);

		assertEquals(personService.findFamily("Audrey", "Jurquet"), personService.findFamily("Emmanuel", "Jurquet"));

	}
	
}


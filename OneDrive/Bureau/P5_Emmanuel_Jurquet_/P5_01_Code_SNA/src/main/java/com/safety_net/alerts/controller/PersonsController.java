package com.safety_net.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.service.PersonService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
public class PersonsController {
	
	@Autowired
	private PersonService personService;
	
	 private static final Logger logger = LogManager.getLogger(PersonsController.class);
	 
	 
	 
	@GetMapping(value="persons")
	public List<Persons> listePersons() {
		logger.info("Recherche des Habitants");
		List<Persons> lPerson = personService.list();
		logger.info(lPerson);
		return lPerson;
	}
	
	@PostMapping(value="/persons") 
	public void addpersons(@RequestBody Persons persons) {
		logger.info("Ajout de :  {}", persons.getFirstname(), persons.getLastname());
		logger.info(personService.add(persons));
		personService.add(persons);
		
	}
	
	@PutMapping(value ="/persons") 
	public void replacePersons (@RequestBody Persons persons) {
		logger.info("Modifications d'informations personnelles de :  {}",persons);
		personService.replace(persons);

	}
	
	@DeleteMapping(value ="/persons") 
	public void removePersons (@RequestParam String firstName,@RequestParam String lastName) {
		logger.info("Effacement de : {}",firstName, lastName);
		personService.remove(firstName, lastName);
		
	}
		
}



	
	
	

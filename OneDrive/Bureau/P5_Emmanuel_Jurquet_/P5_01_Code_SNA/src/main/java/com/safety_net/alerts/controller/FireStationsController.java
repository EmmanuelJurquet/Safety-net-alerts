package com.safety_net.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety_net.alerts.model.FireStations;

import com.safety_net.alerts.service.FireStationsService;


@RestController
public class FireStationsController {
			
	@Autowired
	private FireStationsService firestationService;
	private static final Logger logger = LogManager.getLogger(FireStationsController.class);

	@GetMapping(value="/firestations")
	public List<FireStations> listeFireStations() {
		logger.info("Recherche des Casernes de Pompiers");
		List<FireStations> lFire = firestationService.list();
		logger.info(lFire);
		return lFire;
	}

	@PostMapping(value="/firestations") 
	public void addFireStation(@RequestBody FireStations firestations) {
		logger.info("Ajout d'une Caserne de Pompiers: {}", firestations.getStation());
		logger.info("Adresse de la caserne : {}", firestations.getAddress());
		firestationService.add(firestations);
	}

	@PutMapping(value ="/firestations") 
	public void replaceFireStations (@RequestBody FireStations firestations) {
		logger.info("Modifications d'un mapping se caserne: {}", firestations.getStation());
		logger.info(firestations.getAddress());
		firestationService.replace(firestations);
	}

	@DeleteMapping(value ="/firestations") 
	public void removeFireStations ( @RequestParam String address, @RequestParam String station  ) {
		logger.info("Effacement d'un mapping de caserne: {}",address, station);
		firestationService.remove( address, station);

	}

}





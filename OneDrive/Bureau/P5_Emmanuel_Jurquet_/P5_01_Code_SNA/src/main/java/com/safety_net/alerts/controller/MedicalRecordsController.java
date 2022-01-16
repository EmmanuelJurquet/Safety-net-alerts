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

import com.safety_net.alerts.model.MedicalRecords;

import com.safety_net.alerts.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController {

	@Autowired
	private MedicalRecordsService medicalRecordsService;
	 private static final Logger logger = LogManager.getLogger(MedicalRecordsController.class);

	@GetMapping(value="/medicalrecords") 
	public List<MedicalRecords> listMedicalRecords(){
		logger.info("Recherche des dossiers Médicaux");
		List<MedicalRecords> lMedic = medicalRecordsService.list();
		logger.info(lMedic);
		return lMedic;
		
	}

	@PostMapping(value="/medicalrecords") 
	public void addMedicalRecords(@RequestBody MedicalRecords medicalrecords) {
		logger.info("Ajour d'un Dossier Médical: {}",medicalrecords.toString());
		medicalRecordsService.add(medicalrecords);
	}

	@PutMapping(value ="/medicalrecords") 
	public void replaceMedicalRecords (@RequestBody MedicalRecords medicalrecords) {
		logger.info("Modification d'un dossier médical: {}", medicalrecords.toString());
		medicalRecordsService.replace(medicalrecords);
	}

	@DeleteMapping(value ="/medicalrecords") 
	public void removeMedicalRecords (@RequestParam String firstName,@RequestParam String lastName) {
		logger.info("Delete Medicalrecords {}", firstName, lastName);
		medicalRecordsService.remove(firstName, lastName);

	}
	

}

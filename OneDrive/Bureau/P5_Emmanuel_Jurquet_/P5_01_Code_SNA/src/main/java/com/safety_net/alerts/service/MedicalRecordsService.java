package com.safety_net.alerts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety_net.alerts.DAO.IMedicalRecordsDAO;
import com.safety_net.alerts.model.MedicalRecords;

@Service
public class MedicalRecordsService {



	@Autowired
	private IMedicalRecordsDAO medicalRecordsDAO;

	public List<MedicalRecords> list() {
		return this.medicalRecordsDAO.findAll();
	}

	public boolean add (MedicalRecords medicalrecords) {
		medicalRecordsDAO.add(medicalrecords);
		return true;
	}
	public boolean remove (String firstName, String lastName) {
		medicalRecordsDAO.remove(firstName, lastName);
		return true;
	}

	public boolean replace ( MedicalRecords medicalrecords ) {
		medicalRecordsDAO.replace(medicalrecords);
		return true;
	}

	public LocalDate findbirthdate(String firstName, String lastName){
		return medicalRecordsDAO.findbirthdate(firstName, lastName);
		
	}
	public List<MedicalRecords> findChild(String lastName) {
		return medicalRecordsDAO.findChild(lastName);
		
	}
	public MedicalRecords findMedFile(String firstName, String lastName) {
		return medicalRecordsDAO.findMedFile(firstName, lastName);
		
	}
}



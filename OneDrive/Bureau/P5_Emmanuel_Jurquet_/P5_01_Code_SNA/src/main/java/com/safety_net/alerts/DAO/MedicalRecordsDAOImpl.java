package com.safety_net.alerts.DAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safety_net.alerts.model.MedicalRecords;
import com.safety_net.alerts.repository.ProxyBDD;


@Repository
public  class MedicalRecordsDAOImpl implements IMedicalRecordsDAO {


	@Autowired
	private ProxyBDD proxyBDD;

	public List<MedicalRecords> findAll() {
		return proxyBDD.getlMedicalRecords();
	}

	public boolean  add(MedicalRecords medicalrecords ) {
		boolean result =  false;
		List<MedicalRecords> lmedicrec = proxyBDD.getlMedicalRecords();
		if(lmedicrec.add(medicalrecords)) {
			result = true;
		}
		return result;

	}
	public boolean remove (String firstName, String lastName ) {
		List<MedicalRecords> lmedicrec = proxyBDD.getlMedicalRecords();
		boolean result = false;
		for (MedicalRecords medicrec:lmedicrec) {

			if (medicrec.getFirstname().equals(firstName) && medicrec.getLastname().equals(lastName)) {
				lmedicrec.remove(medicrec);
				result = true;
				break;
			}
		}return result;
	}

	public boolean replace (MedicalRecords medicalrecords) {
		List<MedicalRecords> lmedicrec = proxyBDD.getlMedicalRecords();
		boolean result = false;
		for (MedicalRecords medicrec:lmedicrec) {
			
			if (medicrec.getFirstname().equals(medicalrecords.getFirstname())&& medicrec.getLastname().equals(medicalrecords.getLastname())){

				medicrec.setMedications(medicalrecords.getMedications());
				medicrec.setAllergies(medicalrecords.getAllergies());
				result = true;
				break;
			}
		}
		return result;
	}
	public LocalDate findbirthdate(String firstName, String lastName) {

		List<MedicalRecords> lmedicrec= proxyBDD.getlMedicalRecords();
		LocalDate date = null;
		for (MedicalRecords med : lmedicrec) {

			if (med.getFirstname().equals(firstName)&& med.getLastname().equals(lastName)) {
				date = med.getBirthdate();
			}
		}
		return date;
	}

	

	public  List<MedicalRecords> findChild (String lastName) {
		List<MedicalRecords> lmedicrec = proxyBDD.getlMedicalRecords();
		LocalDate date = null;
		List<MedicalRecords>homeChild =  new ArrayList<>();

		for (MedicalRecords med : lmedicrec) {
			date = med.getBirthdate();	
			Long age = date.until(LocalDate.now(), ChronoUnit.YEARS);

			if (age <=18) {

				homeChild.add(med);
			}	
		}	
		return homeChild;
	}


	public MedicalRecords findMedFile (String firstName, String  lastName) {
		
		List<MedicalRecords> lmedicrec = proxyBDD.getlMedicalRecords();
		MedicalRecords medfile = null;
		
		for (MedicalRecords findfile : lmedicrec) {
			
				if(findfile.getFirstname().equals(firstName)&&findfile.getLastname().equals(lastName)) {
					medfile =findfile;
			}	
		}
		return medfile;
	}
}


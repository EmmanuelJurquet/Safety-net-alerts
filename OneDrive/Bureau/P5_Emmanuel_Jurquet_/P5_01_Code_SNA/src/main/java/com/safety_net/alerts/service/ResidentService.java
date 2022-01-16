package com.safety_net.alerts.service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety_net.alerts.DAO.IFireStationsDAO;
import com.safety_net.alerts.DAO.IMedicalRecordsDAO;
import com.safety_net.alerts.DAO.IPersonDAO;

import com.safety_net.alerts.model.MedicalRecords;
import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.model.Resident;





@Service
public class ResidentService {


	@Autowired
	IPersonDAO personsDAO;
	@Autowired
	IFireStationsDAO firestationsDAO;
	@Autowired
	IMedicalRecordsDAO medicalrecordsDAO;



	public Resident resident(String firstName , String lastName) {

		Persons persons =  personsDAO.findPerson(firstName, lastName);
		List<String> firestations = firestationsDAO.findStationByAddress(persons.getAddress());
		MedicalRecords medFile =  medicalrecordsDAO.findMedFile(firstName, lastName);
		Resident resident = new Resident();

		resident.setFirstName(firstName);
		resident.setLastName(lastName);
		resident.setAddress(persons.getAddress());
		resident.setPhone(persons.getPhone());
		resident.setStation(firestations);
		resident.setBirthday(medFile.getBirthdate());
		resident.setMedications(medFile.getMedications());
		resident.setAllergies(medFile.getAllergies());

		return resident;
	}

	public List<Resident> findListOfResidentsByAddress (String address) {

		List<Persons> personsaddress = personsDAO.findPersonsByAddress(address);
		List<Resident> results = new ArrayList<>();


		for(Persons pers : personsaddress) {

			String firstName = pers.getFirstname();
			String lastName = pers.getLastname();

			results.add(resident(firstName, lastName));

		}
		return results;
	}

	public List <List <Resident>> findChildByAddress (String address){
		List <List <Resident>> result  = new ArrayList<>();
		List <Resident> child = new ArrayList<>();
		List<Resident> homeCHild =  new ArrayList<>();
		result.add(child);
		result.add(homeCHild);
		
		List<Persons> findResidentsByAddress = personsDAO.findPersonsByAddress(address);
		
		for (Persons pers : findResidentsByAddress) {
			
		
			MedicalRecords medfil = medicalrecordsDAO.findMedFile(pers.getFirstname(), pers.getLastname());
			Long age =  medfil.getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
			Resident resident= new Resident();
			// resident à remplir avec les données
			resident.setFirstName(pers.getFirstname());
			resident.setLastName(pers.getLastname());
			resident.setBirthday(medfil.getBirthdate());
			resident.setMedications(medfil.getMedications());
			resident.setAddress(pers.getAddress());
			resident.setAllergies(medfil.getAllergies());
			resident.setPhone(pers.getPhone());
			
			if (age <=18) {
				child.add(resident);
			} else {
				homeCHild.add(resident);
			}
		}
		
		return result;
	}

	public List<Resident> findListOfResidentsByFireStationNumber (String station_number){
		List <Persons> persons = personsDAO.findAll();
		List<String> lfireStations = firestationsDAO.findAddressByStationNumber(station_number);

		String firstName = null;
		String lastName = null;
		Resident res = null;

		List<Resident> lresults = new ArrayList<>();

		for (Persons pers : persons) {
			firstName = pers.getFirstname();
			lastName = pers.getLastname();
			res = resident(firstName,lastName);

		for (String address : lfireStations ) {

			if (address.equals(res.getAddress())){		
				lresults.add(res);			
			}
		}
	}return lresults;	
	}
}		
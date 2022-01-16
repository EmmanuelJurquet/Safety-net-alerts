package com.safety_net.alerts.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety_net.alerts.DAO.IFireStationsDAO;
import com.safety_net.alerts.DAO.IMedicalRecordsDAO;
import com.safety_net.alerts.DAO.IPersonDAO;
import com.safety_net.alerts.model.FireStations;
import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.repository.ProxyBDD;
import com.safety_net.alerts.model.MedicalRecords;
import java.util.Date;
import java.util.Calendar;




@Service
public class UrlsServices {


	@Autowired
	IPersonDAO personsDAO;
	@Autowired
	IFireStationsDAO firestationsDAO;
	@Autowired
	IMedicalRecordsDAO medicalrecordsDAO;

	



	public Map<String, Object> findPersonsByStationNumber (String stationNumber) {

		
		List<Persons> resultats =  new ArrayList<>();
		List<String> lAddress = firestationsDAO.findAddressByStationNumber(stationNumber);
		Map<String, Object> mResult = new HashMap<>();

		int nbAdult = 0;	
		int nbChild = 0;

		for (String address : lAddress) {

			List<Persons> persons = personsDAO.findPersonsByAddress(address);
			for(Persons pers : persons) {
				
			LocalDate medic = medicalrecordsDAO.findbirthdate(pers.getFirstname(),pers.getLastname());
			LocalDate a = LocalDate.now().minusYears(18);

			if (medic.isAfter(a)){
				nbChild = nbChild +1;
			}
			if (medic.isBefore(a)) {
				nbAdult = nbAdult +1;
			}
			if (medic.equals(a)) {
				nbAdult = nbAdult+1;
			}
			resultats.add(pers);			

			
			}
		}
		mResult.put("persons", resultats);
		mResult.put("adulte", nbAdult);
		mResult.put("child", nbChild);	
		
		return mResult;
	}


		
		
		

	


	public List<String> findResidentsPhoneByStationNumber (String firestation){


		List<String> findStation = firestationsDAO.findAddressByStationNumber(firestation);
		List<String> result =  new ArrayList<>();

		for (String address : findStation) {

			List<String> results  = personsDAO.findPhoneByAddress(address);
			result.addAll(results);
		}
		return result;
	}




	public List<String>findEmail (String city){
		List<String> findemail = personsDAO.findEmail(city);
		return findemail;

	}

}


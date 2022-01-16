package com.safety_net.alerts.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety_net.alerts.model.MedicalRecords;
import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.model.Resident;
import com.safety_net.alerts.service.ResidentService;
import com.safety_net.alerts.service.UrlsServices;

@RestController
public class URLControllers {


	@Autowired
	private	UrlsServices  urlsServices;
	@Autowired
	private ResidentService rServices;
	
	 private static final Logger logger = LogManager.getLogger(URLControllers.class);

	@GetMapping (value = "/firestation")
	public Map<String, Object> findPersonsByStationNumber (@RequestParam String stationNumber){
		logger.info("Persons find by FireStation Number {}", stationNumber);
		Map<String, Object> lresult = urlsServices.findPersonsByStationNumber(stationNumber);
		logger.info(lresult);
		return lresult;
	}

	@GetMapping (value = "/childAlert")
	public List<List<Resident>> findChildByAddress (@RequestParam String address) {
		logger.info("Childs find by Address {}", address);
		List<List<Resident>> lresults = rServices.findChildByAddress(address);
		logger.info(lresults);
		return lresults;
	}

	@GetMapping (value = "/phoneAlert")
	public List<String>findPhoneByFireStationNumber (@RequestParam String firestation){
		logger.info("Phone's persons find by FireStation Number {}", firestation);
		List<String> lresults = urlsServices.findResidentsPhoneByStationNumber(firestation);
		logger.info(lresults);
		return lresults;
	}

	@GetMapping (value ="/fire" )
	public List<Resident> findListOfResidentsByAddress (@RequestParam String address){
		logger.info("Residents find by Address {}",address);
		List<Resident> lresults =  rServices.findListOfResidentsByAddress(address);
		logger.info(lresults);
		return lresults;
	}

	@GetMapping ( value = "/flood/stations")
	public List<Resident> findListOfResidentsByFireStationNumber (@RequestParam String station_number){
		logger.info("List of Residents find by FireStationNumber",station_number);
		List<Resident> lresults =  rServices.findListOfResidentsByFireStationNumber(station_number);
		logger.info(lresults);
		return lresults;	
	}

	@GetMapping (value= "/personInfo")
	public Resident resident(@RequestParam String firstName , String lastName) {
		logger.info("Find a Resident by Name",firstName, lastName);
		Resident result = rServices.resident(firstName, lastName);
		logger.info(result);
		return result;
	}

	@GetMapping (value = "/communityEmail")
	public List<String> findEmailCity (@RequestParam String city) {
		logger.info("Return all Emails's Residents {}",city);
		List<String> lresults = urlsServices.findEmail(city);
		logger.info(lresults);
		return lresults;
		
	}
}




	



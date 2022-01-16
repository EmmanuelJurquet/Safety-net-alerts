package com.safety_net.alerts.service;

import java.util.List;

import com.safety_net.alerts.model.FireStations;

public interface IFireStationsService {

	
	
	public List<FireStations> list();
	
	public boolean add (FireStations firestations);
	
	public boolean remove (FireStations firestations);
	
	public boolean replace(FireStations firestations);
	
	public List<String> findAddressByStationNumber(String firestation);
	
	public List<String> findStationByAddress (String address); 

}

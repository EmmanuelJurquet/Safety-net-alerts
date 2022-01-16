package com.safety_net.alerts.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.safety_net.alerts.model.FireStations;
import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.repository.ProxyBDD;

@Repository
public  class FireStationsDAOImpl implements IFireStationsDAO {


	@Autowired 
	private ProxyBDD proxyBDD;


	public List<FireStations> findAll() {

		return proxyBDD.getlFireStations();
	}

	public boolean add(FireStations firestations ) {
		boolean result  = false;
		List<FireStations> lfirestations = proxyBDD.getlFireStations();
		lfirestations.add(firestations);
		return result;
	}

	public boolean remove(String address, String station) {
		List<FireStations> lfirestations = proxyBDD.getlFireStations();
		boolean result = false;
		
 		for (FireStations firesta:lfirestations) {

			if (firesta.getStation().equals(station)&&firesta.getAddress().equals(address)) {		
				lfirestations.remove(firesta);
				result = true;
				break;
			}
		}
 		return result ;
	}
	public boolean replace(FireStations firestations) {
		
		List<FireStations>lfirestations = proxyBDD.getlFireStations();
		boolean result = false;
		String address = firestations.getAddress();

		for(FireStations firesta:lfirestations) {
			if (firesta.getAddress().equals(address)){		

				firesta.setStation(firestations.getStation());
			}
		}
		return result ;
	}


	
	public List<String> findAddressByStationNumber(String firestation) {

		List<FireStations>lfirestations = proxyBDD.getlFireStations();
		List<String> lAddress = new ArrayList<>();

		for (FireStations firesta : lfirestations) {
			
			if( firesta.getStation().equals(firestation) ) {
				lAddress.add(firesta.getAddress());
			}
			
		}
		
		return lAddress;

	}
	public List<String> findStationByAddress (String address) {
		List<FireStations>lfirestations = proxyBDD.getlFireStations();
		List<String> results = new ArrayList<>();
		
		for (FireStations stations : lfirestations) {
			
			String findaddress = stations.getAddress();
			if(findaddress.equals(address)) {
				
				results.add(stations.getStation());
			}
		}
		return results;
	}

}



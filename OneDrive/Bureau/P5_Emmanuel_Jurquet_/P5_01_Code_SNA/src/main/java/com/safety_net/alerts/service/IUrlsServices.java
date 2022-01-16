package com.safety_net.alerts.service;

import java.util.List;
import java.util.Map;



public interface IUrlsServices {

	
	public Map<String, Object> findPersonsByStationNumber (String stationNumber);
	
	public List<String> findResidentsPhoneByStationNumber (String firestation);
	
	public List<String>findEmail (String city);
}

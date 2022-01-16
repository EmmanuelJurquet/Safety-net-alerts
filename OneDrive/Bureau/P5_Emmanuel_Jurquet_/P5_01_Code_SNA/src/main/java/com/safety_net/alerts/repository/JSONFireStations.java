package com.safety_net.alerts.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.json.JsonParser;
import com.safety_net.alerts.model.FireStations;






public class JSONFireStations {



	public  List<FireStations> readFireStations () {

		JSONParser jsonP = new JSONParser ();
		List<FireStations> lFireStations = new ArrayList<>();  
		try {
			JSONObject json = (JSONObject) jsonP.parse(new FileReader ("C:\\Users\\emman\\OneDrive\\Bureau\\P5_Emmanuel_Jurquet_Safety_net_alerts\\P5_01_Safety_Net_Alerts_Code\\resources\\sna.json"));
			JSONArray fireStationsArray = (JSONArray) json.get("firestations");

			for (int i = 0;i<fireStationsArray.size();i++) {
				JSONObject jsonFireStations = (JSONObject) fireStationsArray.get(i);
				
				FireStations fireStations = new FireStations();
				fireStations.setAddress(jsonFireStations.get("address").toString());
				
				fireStations.setStation(jsonFireStations.get("station").toString());
				lFireStations.add(fireStations);
				
			}

		 
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ParseException e) { 

			e.printStackTrace();

		}
		return lFireStations;
	}

}		
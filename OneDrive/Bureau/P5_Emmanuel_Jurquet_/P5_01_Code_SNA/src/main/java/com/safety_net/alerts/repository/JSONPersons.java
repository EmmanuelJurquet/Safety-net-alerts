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



import com.safety_net.alerts.model.Persons;


public class JSONPersons {




		public List<Persons> readPersons() {

		JSONParser jsonP = new JSONParser();
		List<Persons> lPersons = new ArrayList<>();

		try {

			JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("C:\\Users\\emman\\OneDrive\\Bureau\\P5_Emmanuel_Jurquet_Safety_net_alerts\\P5_01_Safety_Net_Alerts_Code\\resources\\sna.json"));

			JSONArray persArray = (JSONArray) jsonO.get("persons");
		
			for( int i = 0 ; i < persArray.size(); i++ ) {

				JSONObject jsonPers = (JSONObject) persArray.get(i);
				
				Persons persons = new Persons();
				
				String firstName = jsonPers.get("firstName").toString();
				persons.setFirstname(firstName);
				
				persons.setLastname(jsonPers.get("lastName").toString());

				persons.setAddress(jsonPers.get("address").toString());

				persons.setCity(jsonPers.get("city").toString());

				persons.setZip(jsonPers.get("zip").toString());

				persons.setPhone(jsonPers.get("phone").toString());

				persons.setEmail(jsonPers.get("email").toString());
				
				lPersons.add(persons);
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) { 
			e.printStackTrace();
		}

		return lPersons;
	}
}


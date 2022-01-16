package com.safety_net.alerts.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.safety_net.alerts.model.MedicalRecords;


public class JSONMedicalRecord {

	public List<MedicalRecords> readMedicalRecords() {

		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
			JSONParser jsonP = new JSONParser();
			List <MedicalRecords> lMedicalRecords = new ArrayList<>();
	try {
				
				JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("C:\\Users\\emman\\OneDrive\\Bureau\\P5_Emmanuel_Jurquet_Safety_net_alerts\\P5_01_Safety_Net_Alerts_Code\\resources\\sna.json"));
				JSONArray medRArray = (JSONArray) jsonO.get("medicalrecords");
				
				for (int i = 0; i < medRArray.size();i++) {
			
				JSONObject jsonMedicRec = (JSONObject) medRArray.get(i);
				
				MedicalRecords medicRecords = new MedicalRecords();
				
				String firstName = jsonMedicRec.get("firstName").toString();
				medicRecords.setFirstname(firstName);
					
				medicRecords.setLastname(jsonMedicRec.get("lastName").toString());
				LocalDate localDate = LocalDate.parse(jsonMedicRec.get("birthdate").toString(), formatter);
				medicRecords.setBirthdate(localDate);
				
				String medics = jsonMedicRec.get("medications").toString().replaceAll("\"","");
				String[] result=  medics.split(",");
				List<String> lmedics = new ArrayList<>(Arrays.asList(result));
				medicRecords.setMedications(lmedics);
				String allergies = jsonMedicRec.get("allergies").toString().replaceAll("\"","");
				String[] results = allergies.split(",");
				List<String> lallergies =  new ArrayList<>(Arrays.asList(results));
				
				medicRecords.setAllergies(lallergies);
				
				lMedicalRecords.add(medicRecords);
				
				}
			}

			catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} catch (ParseException e) { 

				e.printStackTrace();

			}
			return lMedicalRecords;
	}
	
}

	



package com.safety_net.alerts.model;

import java.beans.JavaBean;
import java.time.LocalDate;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

@JavaBean
public class MedicalRecords {


	private String firstname;
	private String lastname;
	private LocalDate birthdate;
	private List<String> medications;
	private List<String> allergies;


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "MedicalRecords [firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", medications=" + medications + ", allergies=" + allergies + "]";

	}
}


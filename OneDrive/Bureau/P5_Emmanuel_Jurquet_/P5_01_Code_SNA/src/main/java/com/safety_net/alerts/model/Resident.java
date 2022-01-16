 package com.safety_net.alerts.model;

import java.time.LocalDate;
import java.util.List;

public class Resident {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private List<String> station;
	private LocalDate birthday;
	private List <String>medications;
	private List<String> allergies;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public List<String> getStation() {
		return station;
	}
	public void setStation(List<String> station) {
		this.station = station;
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
		return "Resident [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phone="
				+ phone + ", station=" + station + ", birthday=" + birthday + ", medications=" + medications
				+ ", allergies=" + allergies + "]";
	}
	
	
	
}

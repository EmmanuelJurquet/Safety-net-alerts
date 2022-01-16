 package com.safety_net.alerts.service;

import java.util.List;

import com.safety_net.alerts.model.Persons;

public interface IPersonsService {

	public List<Persons> list();
	
	public boolean add (Persons persons);
	
	public void replace (Persons person);
	
	public boolean remove (String firstName,String lastName);
	
	public  List<Persons> findPersonsByAddress (String address);
	
	public List<String> findPhoneByAddress (String address);
	
	public List<Persons> findFamily (String firstName, String LastName);

	public List<String> findEmail (String city);
}
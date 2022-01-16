package com.safety_net.alerts.DAO;

import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.repository.JSONPersons;
import java.util.List;
import java.util.Map;

public interface IPersonDAO {
	

	
	public List<Persons>findAll();

	public Persons findPerson(String firstName, String lastName);
		
	public boolean add(Persons persons);

	public void replace(Persons person);

	public boolean remove(String firstName, String lastName);
	
	public List<String> findPhoneByAddress (String address);
	
	public  List<Persons> findPersonsByAddress (String address);
	
	public List<Persons> findFamily (String firstName, String LastName);

	public List<String> findEmail(String city);
}

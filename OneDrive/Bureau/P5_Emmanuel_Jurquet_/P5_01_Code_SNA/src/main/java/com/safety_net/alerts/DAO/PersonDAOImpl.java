package com.safety_net.alerts.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.safety_net.alerts.model.Persons;
import com.safety_net.alerts.repository.ProxyBDD;

@Repository
public  class PersonDAOImpl implements IPersonDAO {


	@Autowired
	private ProxyBDD proxyBDD;

	@Override
	public List<Persons> findAll() {
		return proxyBDD.getLpersons();
	}

	public boolean add(Persons person) {
		List<Persons> lperson = proxyBDD.getLpersons();
		lperson.add(person);
		return true;
	}
	
	public boolean remove(String firstName, String lastName ) {
		List<Persons> lperson = proxyBDD.getLpersons();
		boolean result = false;
		for (Persons pers:lperson) {	

			if (pers.getFirstname().equals(firstName) && pers.getLastname().equals(lastName)) {
				lperson.remove(pers);
				result = true;
				break;
			}
		}
		return result;
	}	

	public void replace (Persons person) {

		List<Persons> lperson = proxyBDD.getLpersons();

		String firstName = person.getFirstname();
		String lastName = person.getLastname();

		for (Persons pers:lperson) {

			if (pers.getFirstname().equals(firstName) && pers.getLastname().equals(lastName)) {

				pers.setAddress(person.getAddress());
				pers.setCity(person.getCity());
				pers.setZip(person.getZip());
				pers.setPhone(person.getPhone());
				pers.setEmail(person.getEmail());
				break;
			}
		}
	}
	
	public Persons findPerson (String firstName, String lastName) {
		List<Persons> lPersons = proxyBDD.getLpersons();
		Persons result = null ;
		for (Persons person : lPersons) {
			
			if (person.getFirstname().equals(firstName) && person.getLastname().equals(lastName)) {
				result = person;	
			}
		}
		return result;
	}
	 
	
	public  List<Persons> findPersonsByAddress (String address) {
		List<Persons> lPersons = proxyBDD.getLpersons();
		List<Persons> mPersons = new ArrayList<>();

		for (Persons persons : lPersons) {

			String laddress =  persons.getAddress(); 
			if (laddress.equals(address)) {

				mPersons.add(persons);
			}
		} 
		return mPersons;
	}
	public Persons findPersonbyAddress (String address) {
		List<Persons> lPersons = proxyBDD.getLpersons();
		Persons result = null;
		
		for (Persons person : lPersons) {
			
			String raddress = person.getAddress();
			if (raddress.equals(address)) {
				
				person.getFirstname();
				person.getLastname();
			}
			result= person;
		}
		return result;
		
	}
	public List<String> findPhoneByAddress (String address){

		List<Persons> lPersons = proxyBDD.getLpersons();
		List<String> phoneP = new ArrayList<>();
		
		for (Persons person : lPersons) {
			String	phone =  person.getPhone();
			if (person.getAddress().equals(address)) {
				phoneP.add(phone);
			}	
		}
		return phoneP ;
	}
	
	public List<Persons> findFamily (String firstName, String LastName){

		List<Persons> lPersons = proxyBDD.getLpersons();
		List<Persons> lFamily = new ArrayList<>();
	
		String famAddress = null;
		for (Persons fam : lPersons) {

			if (fam.getFirstname().equals(firstName)&&fam.getLastname().equals(LastName)) {
				famAddress = fam.getAddress();
			}
		}
		for (Persons fam : lPersons) {

			if (fam.getAddress().equals(famAddress) && !(fam.getFirstname().equals(firstName)&& fam.getLastname().equals(LastName)) ) {
				lFamily.add(fam);
			}
		}
		return lFamily;
		
	}
	public List<String> findEmail (String city) {
		List<Persons> lPersons = proxyBDD.getLpersons();
		List <String> results = new ArrayList<>();
		
		for (Persons persons: lPersons) {
				String email  = persons.getEmail();
			if(persons.getCity().equals(city)) {
				results.add(email);
			}	
		}
		return results;
	}
}
				


		








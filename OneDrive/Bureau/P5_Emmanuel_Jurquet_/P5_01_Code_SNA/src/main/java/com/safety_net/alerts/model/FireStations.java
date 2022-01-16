package com.safety_net.alerts.model;

import java.beans.JavaBean;

@JavaBean
public class FireStations {

	
	
	private String address;
	private String stations;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		
		return stations;
	}
	public void setStation(String stations) {
		this.stations = stations;
	}
	
	@Override
	public String toString() {
		return "FireStations [address=" + address + ", stations=" + stations + "]";
	}

}
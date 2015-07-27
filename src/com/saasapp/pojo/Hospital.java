package com.saasapp.pojo;

public class Hospital {

	private String hospitalName;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Hospital(String hospitalName) {
		super();
		this.hospitalName = hospitalName;
	}
	
}

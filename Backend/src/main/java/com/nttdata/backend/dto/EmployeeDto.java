package com.nttdata.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {

	@JsonProperty("Primer nombre")
	private String firstName;
	
	@JsonProperty("Segundo nombre")
	private String secondName;
	
	@JsonProperty("Primer apellido")
	private String firstLastName;
	
	@JsonProperty("Segundo apellido")
	private String secondLastName;
	
	@JsonProperty("Teléfono")
	private String phone;
	
	@JsonProperty("Dirección")
	private String address;
	
	@JsonProperty("Ciudad de residencia")
	private String city;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

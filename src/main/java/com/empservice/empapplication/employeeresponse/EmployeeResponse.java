package com.empservice.empapplication.employeeresponse;

import java.util.List;

public class EmployeeResponse {

	private int Id;

	private String name;

	private String email;

	private String bloodgroup;
	
	private AddressResponse addressResponse;
	
	private List<AddressResponse> addResponse;
	
	
	

	public List<AddressResponse> getAddResponse() {
		return addResponse;
	}

	public void setAddResponse(List<AddressResponse> addResponse) {
		this.addResponse = addResponse;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	
	
}

package com.kevin.fidelity.HashMapJerseeyMaven;

public class Customer {

	private String name;
	private String Address;
	
	
	public Customer(String name, String address) {
		super();
		this.name = name;
		Address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}

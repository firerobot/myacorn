package com.myacorn.exercise;

public class Author {
	private String lastName;
	private String firstName;
	private String country;
	
	public Author(String lastName, String firstName, String country) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.country = country;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.firstName)
		.append(" ")
		.append(this.lastName)
		.append(" from ")
		.append(this.country);
		return buf.toString();
	}
}

package com.myacorn.exercise;

public class Author {
	public enum Sex {
		M,
		F
	}
	private Sex gender;
	private String lastName;
	private String firstName;
	private String country;
	private int age;
	
	public Author(Sex gender, String lastName, String firstName, String country, int age) {
		this.gender = gender;
		this.lastName = lastName;
		this.firstName = firstName;
		this.country = country;
		this.age = age;
	}
	
	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
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
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.firstName)
		.append(" ")
		.append(this.lastName)
		.append("(")
		.append(this.getGender())
		.append(" aged ")
		.append(this.getAge())
		.append(")")
		.append(" from ")
		.append(this.country);
		return buf.toString();
	}
	
	/*
	 * Special function to get around with mapping method
	 */
	public Author getAuthor() {
		return this;
	}
}

package com.myacorn.exercise;

import java.lang.Math;

//From Item 8 of Effective Java 2nd Edition
//Broken - violates symmetry!
public final class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}

/*
	// Broken - violates symmetry!
	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString) {
			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
		}
		if (o instanceof String) { // One-way interoperability!
			return s.equalsIgnoreCase((String) o);
		}
		return false;
	}
*/

	//Should not attempt to interoperate with String
	@Override 
	public boolean equals(Object o) {
		return o instanceof CaseInsensitiveString &&
		((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	}
	
	
	//Must return the same hashcode for objects that are equal
	//and also each unique object should return the same hash code.
	@Override
	public int hashCode() {
		int result = s.toLowerCase().hashCode();
		char[] array = s.toCharArray();
		//String[] array = s.split("(?!^)");
		
		for (int i = 0; i < array.length; i++) {
			if (Character.isUpperCase(array[i])) {
				double exp = i + 1;
				Double addTo = Math.pow(2.0, exp);
				result += addTo.intValue();
			}
		}
		return result;
	}
	
	
	
}
package com.myacorn.exercise;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CaseInsensitiveStringTest {
	@Test
	public void testEquals() {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		assertEquals(false, cis.equals(s));  //cis is not equal to s
		assertEquals(false, s.equals(cis));  //s is not equal to cis
		
		CaseInsensitiveString cis2 = new CaseInsensitiveString("PolisH");
		CaseInsensitiveString cis3 = new CaseInsensitiveString("POLISH");
		CaseInsensitiveString cis4 = new CaseInsensitiveString("polish");
		
		//symmetric
		assertEquals(true, cis.equals(cis2));
		assertEquals(true, cis2.equals(cis));

		//transitivity
		assertEquals(true, cis2.equals(cis3));
		assertEquals(true, cis.equals(cis3));
		
		//consistent
		assertEquals(true, cis.equals(cis2));
		
		//reflexive
		assertEquals(true, cis.equals(cis));
		
		//null
		assertEquals(false, cis.equals(null));
	}
	
	@Test
	public void testHashMap() {
		CaseInsensitiveString s1 = new CaseInsensitiveString("Polish");
		CaseInsensitiveString s2 = new CaseInsensitiveString("pOlish");
		CaseInsensitiveString s3 = new CaseInsensitiveString("poLish");
		CaseInsensitiveString s4 = new CaseInsensitiveString("polIsh");
		CaseInsensitiveString s5 = new CaseInsensitiveString("poliSh");
		CaseInsensitiveString s6 = new CaseInsensitiveString("polisH");
		CaseInsensitiveString s7 = new CaseInsensitiveString("POlish");
		CaseInsensitiveString s8 = new CaseInsensitiveString("POLish");
		CaseInsensitiveString s9 = new CaseInsensitiveString("POLIsh");
		CaseInsensitiveString s10 = new CaseInsensitiveString("POLISh");
		CaseInsensitiveString s11 = new CaseInsensitiveString("POLISH");
		CaseInsensitiveString s12 = new CaseInsensitiveString("poliSH");

		assertEquals(s1.hashCode(), new CaseInsensitiveString("Polish").hashCode());
		
		Map<CaseInsensitiveString, Integer> hashMap = new HashMap<CaseInsensitiveString, Integer> ();
		hashMap.put(s1, 1);
		hashMap.put(s2, 2);
		hashMap.put(s3, 3);
		hashMap.put(s4, 4);
		hashMap.put(s5, 5);
		hashMap.put(s6, 6);
		hashMap.put(s7, 7);
		hashMap.put(s8, 8);
		hashMap.put(s9, 9);
		hashMap.put(s10, 10);
		hashMap.put(s11, 11);
		hashMap.put(s12, 12);
		
		assertEquals(Integer.valueOf(1), hashMap.get(new CaseInsensitiveString("Polish")));
		assertEquals(Integer.valueOf(6), hashMap.get(new CaseInsensitiveString("polisH")));
		assertEquals(Integer.valueOf(12), hashMap.get(new CaseInsensitiveString("poliSH")));
		
		//test 
	}
}

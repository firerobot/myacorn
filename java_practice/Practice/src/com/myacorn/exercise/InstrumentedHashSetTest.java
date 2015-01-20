package com.myacorn.exercise;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class InstrumentedHashSetTest {
	@Test
	public void test() {
		InstrumentedHashSet<String> s =
				new InstrumentedHashSet<String>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		assertEquals(3, s.getAddCount());
	}
}

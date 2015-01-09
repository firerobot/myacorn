package com.myacorn.exercise;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

public class HelloWorldTest {
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	@Test
	public void test() {
		String[] args = new String[] {"test"};
		HelloWorld.main(args);
		assertEquals("Hello World\r\n", log.getLog());
		//fail("Not yet implemented");
	}

}
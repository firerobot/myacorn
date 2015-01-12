package com.myacorn.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void test() {
		Author author = new Author("Buffet", "Warren", "USA");
		Book book = new Book(author, "How to invest your money", "972-1-800", 1985, 1);
		assertEquals("How to invest your money (ISBN:972-1-800) written by Warren Buffet from USA published in 1985 currently ranks #1", 
				book.toString());
	}

}
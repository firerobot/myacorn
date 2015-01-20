package com.myacorn.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myacorn.exercise.Author.Sex;

public class BookTest {

	@Test
	public void test() {
		Author author = new Author(Sex.M, "Buffet", "Warren", "USA", 80);
		Book book = new Book(author, "How to invest your money", "972-1-800", 1985, 1);
		assertEquals("How to invest your money (ISBN:972-1-800) written by Warren Buffet(M aged 80) from USA published in 1985 currently ranks #1", 
				book.toString());
	}

}

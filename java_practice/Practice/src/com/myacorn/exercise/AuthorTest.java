package com.myacorn.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myacorn.exercise.Author.Sex;

public class AuthorTest {

	@Test
	public void test() {
		Author author = new Author(Sex.M, "Buffet", "Warren", "USA", 80);
		assertEquals("Warren Buffet(M aged 80) from USA", author.toString());
	}

}

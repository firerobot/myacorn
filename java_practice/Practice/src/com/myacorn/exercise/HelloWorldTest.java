package com.myacorn.exercise;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import com.myacorn.exercise.Author.Sex;

public class HelloWorldTest {
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	private List<String> greekAlphabetList;
	private List<Book> bookList = new ArrayList<Book>();
	private List<Book> bookListWithDuplicate = new ArrayList<Book>();
	private Author author1 = new Author(Sex.M, "Buffet", "Warren", "USA", 80);
	private Author author2 = new Author(Sex.M, "Bloch", "Joshua", "USA", 50);
	private Author author4 = new Author(Sex.F, "Sierra", "Kathy", "USA", 55);
	
	@Before
	public void initialise() {
		greekAlphabetList = Arrays.asList
				("theta", "delta", "omega", "beta", "alpha", "zeta", "pi", "alpha");
		
		Book book2 = new Book(author2, "Effective Java", "600-3-758", 1992, 92);
		bookList.add(book2);
		bookListWithDuplicate.add(book2);
		
		Book book3 = new Book(author2, "Effective Java Second Edition", "600-3-999", 2012, 169);
		bookList.add(book3);
		bookListWithDuplicate.add(book3);
		
		Book book1 = new Book(author1, "How to invest your money", "972-1-800", 1985, 1);
		bookList.add(book1);
		bookListWithDuplicate.add(book1);
		bookListWithDuplicate.add(book1);
		
		Book book4 = new Book(author4, "Head First Java ", "605-7-601", 2008, 133);
		bookList.add(book4);
		bookListWithDuplicate.add(book4);
		
		// 4 books in bookList by 3 authors (2 Male, 1 Female)
		// 5 books in bookListWithDuplicate by 3 authors (2 Male, 1 Female)
	}
	
	@Test
	public void test() {
		String[] args = new String[] {"test"};
		HelloWorld.main(args);
		assertEquals("Hello World\r\n", log.getLog());
	}
	
	@Test
	public void testTreeMapSize() {
		//tree map only contains the unique
		assertEquals(7, HelloWorld.buildTreeSet(greekAlphabetList).size());
	}
	
	@Test
	public void testFindGreatestKeyLTEWithNoMatchingKey() {
		//find the key in the tree map that is before the search key when
		//sorted in ascending order
		assertEquals("delta", HelloWorld.findGreatestKeyLTE(greekAlphabetList, "gamma"));
	}
	
	@Test
	public void testFindGreatestKeyLTEWithMatchingKey() {
		assertEquals("pi", HelloWorld.findGreatestKeyLTE(greekAlphabetList, "pi"));
	}
	
	@Test
	public void testFindLeastKeyGTEWithNoMatchingKey() {
		//find the key in the tree map that is after the search key when
		//sorted in ascending order
		assertEquals("omega", HelloWorld.findLeastKeyGTE(greekAlphabetList, "gamma"));
	}

	@Test
	public void testFindLeastKeyGTEWithMatchingKey() {
		assertEquals("zeta", HelloWorld.findLeastKeyGTE(greekAlphabetList, "zeta"));
	}
	
	@Test
	public void testBookTreeSetSize() {
		//tree set only contains the unique
		assertEquals(4, HelloWorld.buildBookTreeSet(bookList, Book::compareByRank).size());
	}
	
	@Test
	public void testSortBookRankViaTreeMap() {
		Book[] array = HelloWorld.sortBookViaTreeMap(bookList, Book::compareByRank);
		assertEquals(4, array.length);
		assertEquals(Integer.valueOf(1), array[0].getRank());
		assertEquals(Integer.valueOf(92), array[1].getRank());
		assertEquals(Integer.valueOf(133), array[2].getRank());
		assertEquals(Integer.valueOf(169), array[3].getRank());
	}
	
	@Test
	public void testSortBookIsbnViaTreeMap() {
		Book[] array = HelloWorld.sortBookViaTreeMap(bookList, Book::compareByIsbn);
		assertEquals(4, array.length);
		assertEquals("600-3-758", array[0].getIsbn());
		assertEquals("600-3-999", array[1].getIsbn());
		assertEquals("605-7-601", array[2].getIsbn());
		assertEquals("972-1-800", array[3].getIsbn());
	}
	
	@Test
	public void testSortBookIsbnViaTreeMapWithDuplicate() {
		Book[] array = HelloWorld.sortBookViaTreeMap(bookListWithDuplicate, Book::compareByIsbn);
		assertEquals(4, array.length);
		assertEquals("600-3-758", array[0].getIsbn());
		assertEquals("600-3-999", array[1].getIsbn());
		assertEquals("605-7-601", array[2].getIsbn());
		assertEquals("972-1-800", array[3].getIsbn());
	}

	@Test
	public void testSortBookRankViaCollection() {
		Book[] array = HelloWorld.sortBookViaCollection(bookList, Book::compareByRank);
		assertEquals(4, array.length);
		assertEquals(Integer.valueOf(1), array[0].getRank());
		assertEquals(Integer.valueOf(92), array[1].getRank());
		assertEquals(Integer.valueOf(133), array[2].getRank());
		assertEquals(Integer.valueOf(169), array[3].getRank());
	}
	
	@Test
	public void testSortBookRankViaCollectionWithDuplicate() {
		Book[] array = HelloWorld.sortBookViaCollection(bookListWithDuplicate, Book::compareByRank);
		assertEquals(5, array.length);
		assertEquals(Integer.valueOf(1), array[0].getRank());
		assertEquals(Integer.valueOf(1), array[1].getRank());
		assertEquals(Integer.valueOf(92), array[2].getRank());
		assertEquals(Integer.valueOf(133), array[3].getRank());
		assertEquals(Integer.valueOf(169), array[4].getRank());
	}
	
	@Test
	public void testSortBookIsbnViaCollectionWithDuplicate() {
		Book[] array = HelloWorld.sortBookViaCollection(bookListWithDuplicate, Book::compareByIsbn);
		assertEquals(5, array.length);
		assertEquals("600-3-758", array[0].getIsbn());
		assertEquals("600-3-999", array[1].getIsbn());
		assertEquals("605-7-601", array[2].getIsbn());
		assertEquals("972-1-800", array[3].getIsbn());
		assertEquals("972-1-800", array[4].getIsbn());
	}
	
	@Test
	public void testGetNumberOfBooksWrittenByGender() {
		assertEquals(1, HelloWorld.getNumberOfBooksWrittenByGender(bookList, Sex.F) );
		assertEquals(3, HelloWorld.getNumberOfBooksWrittenByGender(bookList, Sex.M) );
		assertEquals(1, HelloWorld.getNumberOfBooksWrittenByGender(bookListWithDuplicate, Sex.F) );
		assertEquals(4, HelloWorld.getNumberOfBooksWrittenByGender(bookListWithDuplicate, Sex.M) );
	}
	
	@Test
	public void testGetNumberOfAuthorsByGender() {
		assertEquals(1, HelloWorld.getNumberOfAuthorsByGender(bookList, Sex.F) );
		assertEquals(2, HelloWorld.getNumberOfAuthorsByGender(bookList, Sex.M) );
		assertEquals(1, HelloWorld.getNumberOfAuthorsByGender(bookListWithDuplicate, Sex.F) );
		assertEquals(2, HelloWorld.getNumberOfAuthorsByGender(bookListWithDuplicate, Sex.M) );
	}
	
	@Test
	public void testGetAverageAgeOfAuthorsByGender() {
		double epsilon = 0.001d;
		assertEquals(55.0, HelloWorld.getAverageAgeOfAuthorsByGender(bookList, Sex.F), epsilon );
		assertEquals(65.0, HelloWorld.getAverageAgeOfAuthorsByGender(bookList, Sex.M), epsilon);
		assertEquals(55.0, HelloWorld.getAverageAgeOfAuthorsByGender(bookListWithDuplicate, Sex.F), epsilon );
		assertEquals(65.0, HelloWorld.getAverageAgeOfAuthorsByGender(bookListWithDuplicate, Sex.M), epsilon );
	}
	
	@Test
	public void testGroupAuthorsByGender() {
		Map <Author.Sex, List<Author>> map = HelloWorld.groupAuthorsByGender(bookListWithDuplicate);
		assertEquals(2, map.entrySet().size());
		assertEquals(true, map.keySet().contains(Author.Sex.F));
		assertEquals(1, map.get(Author.Sex.F).size());
		assertEquals("Sierra", map.get(Author.Sex.F).get(0).getLastName());
		assertEquals(true, map.keySet().contains(Author.Sex.M));
		assertEquals(4, map.get(Author.Sex.M).size());
		assertEquals(true, map.get(Author.Sex.M).contains(author1));
		assertEquals(true, map.get(Author.Sex.M).contains(author2));
	}
	
	@Test
	public void testGroupUniqueArthorsByGender() {
		Map <Author.Sex, Set<Author>> map = HelloWorld.groupUniqueAuthorsByGender(bookListWithDuplicate);
		assertEquals(2, map.entrySet().size());
		assertEquals(1, map.get(Author.Sex.F).size());
		assertEquals(2, map.get(Author.Sex.M).size());
	}
}

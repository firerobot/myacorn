package com.myacorn.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.myacorn.exercise.Author.Sex;


public class HelloWorld {

	public static void main (String[] args) {
		System.out.println("Hello World");
	}
	
	public static TreeSet<String> buildTreeSet(List<String> inputList) {
		return inputList.stream().collect(Collectors.toCollection(TreeSet::new));
	}
	
	public static String findGreatestKeyLTE(List<String> inputList, String key) {
		return buildTreeSet(inputList).floor(key);
	}
	
	public static String findLeastKeyGTE(List<String> inputList, String key) { 
		return buildTreeSet(inputList).ceiling(key);
	}

	//old way
/*
	public static TreeMap<Book, Integer> buildBookTreeMap(List<Book> inputList) {

		TreeMap<Book, Integer> treeMap = new TreeMap<Book, Integer>(new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
//				return b1.getIsbn().compareTo(b2.getIsbn());    //based on ISBN
				return b1.getRank().compareTo(b2.getRank());	//based on Rank but has to be non-primitive type
			}
		});
		
		for (int i = 0; i < inputList.size(); i++) {
			treeMap.put(inputList.get(i), i);
		}
		
		Iterator<Book> iter = treeMap.navigableKeySet().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		return treeMap;
	}
*/
	
	/*
	 * Using lambda expression to initialise a treeSet
	 */
	public static TreeSet<Book> buildBookTreeSet(List<Book> inputList, Comparator<Book> comparator) {
		//Need to create factory to create container i.e TreeSet<Book>. The expression means no parameter (get()) and 
		//return the TreeSet constructor with comparator as parameter 
		Supplier<TreeSet<Book>> collectionFactory = () -> { return new TreeSet<Book> (comparator); };
		TreeSet<Book> treeSet = inputList.stream().collect(Collectors.toCollection(collectionFactory));
		treeSet.forEach(System.out::println);
		return treeSet;
	}
	
	/*
	 * Return an array of books (with duplicates removed) sorted by the given book comparator
	 */
	public static Book[] sortBookViaTreeMap(List<Book> inputList, Comparator<Book> comparator) {
		Supplier<TreeSet<Book>> collectionFactory = () -> { return new TreeSet<Book> (comparator); };
		TreeSet<Book> treeSet = inputList.stream().collect(Collectors.toCollection(collectionFactory));
		return treeSet.toArray(new Book[treeSet.size()]);	
	}
	
	/*
	 * Return an array of books sorted by the given book comparator
	 */
	public static Book[] sortBookViaCollection(List<Book> inputList, Comparator<Book> comparator) {
		Collections.sort(inputList, comparator);
		return inputList.toArray(new Book[inputList.size()]);		
	}
	
	/*
	 * Return the number of books which has a male/female author from the given list
	 * Notice the use of Enum typed parameter
	 */
	public static long getNumberOfBooksWrittenByGender(List<Book> inputList, Enum<Sex> gender) {
		return inputList.stream().filter(b -> b.getAuthor().getGender() == gender).count();
	}
	
	/* 
	 * Return the number of male/female authors who wrote the books in the given list
	 * 1. Build a Hash Map of all authors to eliminate duplication
	 * 2. use aggregate functions to find the count from the key set
	 */
	public static long getNumberOfAuthorsByGender(List<Book> inputList, Enum<Sex> gender) {
		Set<Author> set = (Set<Author>)inputList.stream().map(Book::getAuthor).collect(Collectors.toCollection(HashSet::new));
		return set.stream().filter(a -> a.getGender() == gender).count();
	}
	
	/*
	 * Return the average age of authors of the given gender in the given book list 
	 * 
	 * Implementation: there is no need to build a HashMap explicitly. A HashSet is backed by HashMap.
	 * Note: mapToInt parameter is called a mapper
	 */
	public static double getAverageAgeOfAuthorsByGender(List<Book> inputList, Enum<Sex> gender) {
		Set<Author> set = (Set<Author>)inputList.stream().map(Book::getAuthor).collect(Collectors.toCollection(HashSet::new));
		return set.stream().filter(a -> a.getGender() == gender)
				.mapToInt(Author::getAge)
				.average().getAsDouble();
	}
	
	/*
	 * Return map based on gender and author list from the given book list
	 */
	public static Map<Author.Sex, List<Author>> groupAuthorsByGender(List<Book> inputList) {
		return inputList.stream().map(Book::getAuthor).collect(
                Collectors.groupingBy(Author::getGender));
	}

	/*
	 * Return map based on gender and author last name set from the given book list 
	 */
	public static Map<Author.Sex, Set<String>> groupUniqueAuthorLastNameByGender(List<Book> inputList) {
		Map<Author.Sex, Set<String>> result = inputList.stream().map(Book::getAuthor).collect(
					Collectors.groupingBy(Author::getGender,
					Collectors.mapping(Author::getLastName, Collectors.toSet())));
		System.out.println(result);
		return result;
	}
	
	/*
	 * Return map based on gender and author set from the given book list
	 * Note that the result map is implemented as HashMap 
	 */
	public static Map<Author.Sex, Set<Author>> groupUniqueAuthorsByGender(List<Book> inputList) {
		Map<Author.Sex, Set<Author>> result = inputList.stream().map(Book::getAuthor).collect(
					Collectors.groupingBy(Author::getGender,
							Collectors.mapping(Author::getAuthor, Collectors.toSet())));
		System.out.println(result);
		return result;
	}
}

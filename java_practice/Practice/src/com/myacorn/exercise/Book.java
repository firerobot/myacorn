package com.myacorn.exercise;

public class Book {
	private Author author;
	private String title;
	private String iSBN;
	private int year;
	private Integer rank;
	
	public Book(Author author, String title, String iSBN, int year, int rank) {
		this.author = author;
		this.title = title;
		this.iSBN = iSBN;
		this.year = year;
		this.rank = rank;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return iSBN;
	}
	public void setIsbn(String iSBN) {
		this.iSBN = iSBN;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.title)
		.append(" (ISBN:")
		.append(this.iSBN)
		.append(")")
		.append(" written by ")
		.append(this.author.toString())
		.append(" published in ")
		.append(this.year)
		.append(" currently ranks #")
		.append(this.rank);
		return buf.toString();
	}
	
	//Create static compare methods, it can be reference using the double colon syntax
	public static int compareByIsbn(Book a, Book b) {
		return a.getIsbn().compareTo(b.getIsbn());
	}
	
	public static int compareByRank(Book a, Book b) {
		return a.getRank().compareTo(b.getRank());
	}
}

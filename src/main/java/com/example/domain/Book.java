package com.example.domain;

public class Book {
	private String title;
	private String author;
	private int year;
	private int ISBN;
	private double price;
	
	public Book(String title, String author, int year, int iSBN, double price) {
		this.title = title;
		this.author = author;
		this.year = year;
		ISBN = iSBN;
		this.price = price;
	}
	
	public Book() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}



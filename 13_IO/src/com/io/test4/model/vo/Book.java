package com.io.test4.model.vo;

import java.util.Calendar;

public class Book {

	private String title; //도서명
	private String author; //저자
	private int price; //가격
	private Calendar dates; //출판날짜
	private double discountRate; //할인율
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String author, int price, Calendar dates, double discountRate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Calendar getDates() {
		return dates;
	}
	public void setDates(Calendar dates) {
		this.dates = dates;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	@Override
public String toString() {
		
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ","
				+ " dates=" + dates.get(Calendar.YEAR) + "년"
				+ dates.get(Calendar.MONTH) + "월"
				+ dates.get(Calendar.DAY_OF_MONTH) + "일"
				+ ", discountRate=" + discountRate + "]";
		
	}
	
}

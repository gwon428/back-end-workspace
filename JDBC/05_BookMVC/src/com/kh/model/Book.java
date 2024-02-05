package com.kh.model;

public class Book {
	private int rentno;
	private String title;
	private String author;
	
	public Book(int rentno, String title, String author) {
		super();
		this.rentno = rentno;
		this.title = title;
		this.author = author;
	}

	public int getRentno() {
		return rentno;
	}

	public void setRentno(int rentno) {
		this.rentno = rentno;
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

	@Override
	public String toString() {
		return "Book [반납 번호 : " + rentno + ", 제목 : " + title + ", 저자 : " + author + "]" ;
	}

}

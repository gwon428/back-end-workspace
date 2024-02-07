package com.kh.model;

public class Book {
	private int bookno;
	private String title;
	private String author;
	
	public Book(int bookno, String title, String author) {
		super();
		this.bookno = bookno;
		this.title = title;
		this.author = author;
	}

	public int getRentno() {
		return bookno;
	}

	public void setRentno(int bookno) {
		this.bookno = bookno;
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
		return "Book [책 번호 : " + bookno + ", 제목 : " + title + ", 저자 : " + author + "]" ;
	}

}

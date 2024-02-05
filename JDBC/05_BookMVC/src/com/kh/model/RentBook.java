package com.kh.model;

import java.util.Calendar;
import java.util.Date;

public class RentBook {
	private int rentno;
	private int bookno;
	private String title;
	private String author;
	private Date rentdate;

	public RentBook() {
		super();
	}
	

	public RentBook(int rentno, int bookno, String title, String author, Date rentdate) {
		super();
		this.rentno = rentno;
		this.bookno = bookno;
		this.title = title;
		this.author = author;
		this.rentdate = rentdate;
		
	}

	@Override
	public String toString() {
		return "RentBook [rentno=" + rentno + ", bookno=" + bookno + ", title=" + title + ", author=" + author
				+ ", rentdate=" + rentdate + "]";
	}


}

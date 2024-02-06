package com.kh.model;

import java.util.Date;

public class RentBook {
	private int rentno;
	private int bookno;
	private String title;
	private String author;
	private Date rentdate;
	private Date returndate;
	public RentBook() {
		super();
	}
	
		
	
	public RentBook(int rentno, int bookno, String title, String author, Date rentdate, Date returndate) {
		super();
		this.rentno = rentno;
		this.bookno = bookno;
		this.title = title;
		this.author = author;
		this.rentdate = rentdate;
		this.returndate = returndate;
	}

	@Override
	public String toString() {
		return "RentBook [rentno=" + rentno + ", bookno=" + bookno + ", title=" + title + ", author=" + author
				+ ", rentdate=" + rentdate + ", returndate = " + returndate + "]";
		
	}


}

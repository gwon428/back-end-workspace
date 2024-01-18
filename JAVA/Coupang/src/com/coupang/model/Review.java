package com.coupang.model;

import java.util.Date;

public class Review {
	private int reviCode;
	private String reviTitle;
	private String reviDesc;
	private Date reviDate;
	private int rating;
	
	private Customer customer;
	private Product product;
}

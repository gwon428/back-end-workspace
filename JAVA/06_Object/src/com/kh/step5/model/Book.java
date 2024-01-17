package com.kh.step5.model;

public class Book {
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	// 기본생성자를 명시해야 Application > Book b = new Book();이 에러가 안 남
	public Book() {
		/*	(2) 캡슐화(Encapsulation) [= 모델 클래스]
		 	- 정보 은닉 : 외부에서 객체 접근하는 데 있어서 정보를 숨기고 객체의 연산을 통해서만 접근이 가능하게 하는 것
		 	- 객체 내 정보 손상, 오용을 방지하고 데이터가 변경되어도 다른 객체에 영향을 주지 X
		 	- 독립성이 좋고, 하나의 모듈처럼 사용이 가능
		  */
		
	}

	// Alt + Shift + S + O == 생성자 단축키
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}
	
	// getter, setter [Alt + Shift + S + R]
	// Application에서 생성자의 변수들을 따로따로 호출해서 값을 초기화하거나.. 하고 싶을 때 [메서드 방식으로 접근]
	// (title, price 만 호출하고 싶을 때..)
	// setter 메서드 : 값을 담을 때 사용
	// getter 메서드 : 담겨진 값을 가져오려고 할 때 사용
	
	// setter
	public void setTitle(String title){
		this.title = title;
	}
	
	// getter
	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
		
}
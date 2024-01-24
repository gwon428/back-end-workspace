package H_Polymorphism.practice.model;

import java.util.Arrays;

// model class : 캡슐화 적용이 필요함! <- 변수는 private
// 접근제어자가 public -> 
public class Member {
	
	private String name = ""; // 이름
	private int age = 0;;	 // 나이
	private int coupon = 0;; // 요리 쿠폰 개수
	private Book[] bookList = new Book[3];      // 대여중인 책 1권 -- 포함 관계

	public Member() {
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getcoupon() {
		return coupon;
	}

	public void setcoupon(int coupon) {
		this.coupon = coupon;
	}

	public Book[] getBookList() {
		return bookList;
	}

	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}

	
	
	
}



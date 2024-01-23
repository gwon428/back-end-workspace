package com.kh.practice.controller;

import com.kh.practice.model.*;
/*	import 방식 (model package 아래의 모든 클래스들을 import 하겠다. */
public class LibraryController {
	
	private Member member = null;
	private Book[] bookList = new Book[4];
	
	// 인스턴스 초기화 블록 {} : 객체 생성 시 실행되는 블록.
	{
		bookList[0] = new CookBook("맛있는 지중해식 레시피", true);
		bookList[1] = new CookBook("카페 샌드위치 마스터 클래스", false);
		bookList[2] = new AniBook("원피스 107", 19);
		bookList[3] = new AniBook("주술회전 24", 15);
	}

	public void setMember(String name, int age) {
		member = new Member();
		member.setName(name);
		member.setAge(age);
		
	}
	
	public void setMember(String name, int age, int cookCoupon, Book book) {
		member.setName(name);
		member.setAge(age);
		member.setCookCoupon(cookCoupon);
		member.setBook(book);
	}
	
	public Book[] getBookList() {
		return bookList;
	}

	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

	public Member info() {
		return member;
	}

	public void rent(int index) {
		member.setBook(bookList[index]);
		member.setCookCoupon(index);
	}
	
	public boolean ageCheck(int num, int age) {
		if(age <= ((AniBook) bookList[num]).getAccessAge()) {
			return true;
		} 
		return false;
	}

}

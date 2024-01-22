package com.kh.practice.model;

public class AniBook extends Book {

	private int accessAge; // 제한 나이

	public AniBook() {
	}

	public AniBook(String title) {
		super(title);
	}

	public AniBook(String title, int accessAge) {
		super(title);
		this.accessAge = accessAge;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return super.toString() + "AniBook [accessAge=" + accessAge + "]";
	}
	
	

}

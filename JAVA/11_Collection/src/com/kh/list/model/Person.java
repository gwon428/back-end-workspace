package com.kh.list.model;

public class Person implements Comparable<Person> {
	private String name;
	private String addr;
	private int age;
	
	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	// 추상 메서드를 포함한 인터페이스를 implements를 하여 나오는 오류에 Add 
	/* 	compareTo : 반환되는 값을 가지고 정렬 기준을 잡음
	 	- 자기 자신과 매개값으로 전달된 객체가 같은 타입의 객체인지 비교
	 	- 비교해서 같으면 0을 반환, 자기 자신이 크다면 양의 정수(1)를 반환, 작다면 음의 정수(-1)를 반환
	 */ 
	@Override
	public int compareTo(Person o) {
		// 나이 순서대로
//		return this.age == o.age ? 0 : (this.age > o.age ? 1 : -1);
//		return this.age - o.age; 오름차순
		return (this.age - o.age)*-1;	// 내림차순
		
		// 이름 순서대로 (String은 클래스이기 때문에 compareTo 도 제공한다.)
//		return this.name.compareTo(o.name);
//		return this.name.equals(o.name) ? 0 : (this.name.charAt(0) > o.name.charAt(0) ? 1 : -1);
	}

}
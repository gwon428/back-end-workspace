package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {
		Car c = new Car();

		// 실제로는 직접 변수에 접근 X => 원칙적으로 private 접근 제어자로 변수를 선언해야하기 때문에 (데이터에 접근하지 못하도록 막기 위함)
//		c.color = "red";
//		c.gearType = "auto";
//		c.door = 4;
		
		Car c1 = new Car("red", "auto", 4);
//		Car c1 = new Car("orange", "auto");		// 다른 메서드를 사용해도 변수명이 같으면 오류 발생
		Car c2 = new Car("black", "manual");
		
		System.out.println(c1);		// (toString()을 만들기 전에는) 주소값 출력
									// (toString()을 만든 이후에는) toString()의 return값대로 출력
		System.out.println(c2);		// (toString()을 만들기 전에는) 주소값 출력
									// (toString()을 만든 이후에는) toString()의 return값대로 출력
	}
	
	
	/*	오버로딩 (같은 메서드, 다른 매개변수를 가지고 있는 경우)
	 	- 한 클래스 내에 동일한 이름의 메서드를
	 	매개변수의 자료형과 개수, 순서를 다르게 작성해야 함
	 */
	
	// 하단의 메서드들을 각기 다 다른 메서드로 인식
	void test() {}
	void test(int a) {}
	void test(int a, String s) {}
	void test(String s, int a) {}
	void test(int a, int b) {}
	
	// 변수명과는 상관없이 같은 자료형을 받으면 '같은 메서드로 인식'해서 오류 발생
//	void test(int a, int b) {}
//	void test(int c, int d) {}
	

	
	
	
}

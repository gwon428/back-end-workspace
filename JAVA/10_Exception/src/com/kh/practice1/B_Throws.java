package com.kh.practice1;

import java.io.IOException;

public class B_Throws {

	/*	리턴타입 메서드명 (매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
	 	
	 	}
	 	
	 	main 메서드에서도 throws 키워드로 예외를 떠넘길 수 있지만, 	결국 JVM이 예외 처리를 하게 되기 때문에 비추천
	 	--> 프로그램 사용자는 프로그램이 알 수 없는 예외 내용을 출력하고 종료되는 것을 좋아하지 않음
	 	--> 따라서 main 메서드에서 try~catch 블록으로 예외를 처리하는 것이 바람직
	 */
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		B_Throws t = new B_Throws();
		try {
			t.method1();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("예외가 발생했습니다!");
		}
	}
	
	public static void findClass() throws ClassNotFoundException {
//		try {
//			Class cla = Class.forName("java.lang.String2");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			// 에러가 나는 곳에서 에러 잡기
//		}
		
		Class cla = Class.forName("java.lang.String2");
			// 오류를 던져버림 (이 메서드를 호출하는 곳으로 떠넘김) [메인메서드]
	}

	public void method1() throws ClassNotFoundException, IOException {
		System.out.println("method1() 호출");
		method2();
		System.out.println("method1() 종료");
	}
	
	public void method2() throws ClassNotFoundException, IOException {
		System.out.println("method2() 호출");
		
		method3();
		// multi-catch
//		try {
//			method3();
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
		System.out.println("method2() 종료");
	}
	
	public void method3() throws ClassNotFoundException, IOException {
		System.out.println("method3() 호출");

		int random = (int) (Math.random() * 3 + 1);
		if (random == 1) {
			throw new ClassNotFoundException();
		} else if (random == 2) {
			throw new IOException();
		}
		// random이 3이 되면 오류 없이 실행이 됨 (예외가 발생하지 않은 상태!!!)
		System.out.println("method3() 종료");

	}
	
	
	
	
	
	
	
	
}

package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {
		
		/*	변수 호출 방법
		 	- 참조변수.변수;
		 	
		 	메서드 호출 방법
		 	- 참조변수.메서드명();				// 매개변수가 없는 경우
		 	- 참조변수.메서드명(값1, 값2, ...);	// 매개변수가 있는 경우
		 */
		
		Calculator c = new Calculator();
		
		// 변수 호출 방법
		c.a = 3;
		c.b = 98;
		
		// 메서드 호출 방법
		System.out.println("더하기 : " + c.add());	// return 값이 있기 때문에 매개변수 X...?
		System.out.println("빼기 : " + c.substract());
//		System.out.println("곱하기 : " + c.multiply());
		System.out.println("곱하기2 : " + c.multiply(100, 200));
		System.out.println("나누기 : " + Calculator.divide(c.a, c.b));
		// static이기 때문에 c.divide가 아닌 Calculator.divide로도 호출이 가능하다
	}

}

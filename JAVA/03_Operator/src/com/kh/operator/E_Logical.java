package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	/*	논리연산자	(&&, ||)
	 * 	- 두 개의 논리값을 연산해주는 연산자
	 * 	- 논리연산한 결과마저 논리값
	 * 
	 * 	논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 * 	논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true
	 * 
	 * */
	
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
		
//		e.method1();
//		e.method2();
		e.practice();
	}
	Scanner sc = new Scanner(System.in);

	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
				System.out.print("정수값을 입력해주세요 > ");
		int number = sc.nextInt();
		boolean result = (number >= 1) && (number <= 100);
		
		System.out.printf("%d는 1부터 100 사이의 값인가요? : %b", number, result);
	}
	
	public void method2() {
		// Short Cut Evaluation
		int number = 10;
		boolean result = false;	// boolean 초기값 기본은 false => 변수들 초기화부터 지정하고자 할 때!
		
		
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false == false
		
		result = (number < 5) && (++number > 0);	// number>5가 false이기 때문에 ++number>0 연산을 수행되지 않음.
		
		System.out.println(result); // false
		System.out.println(number);	// 10
		
		result = (++number > 0) && (number < 5);
		System.out.println(number);
		
		// true || true = true
		// false || true = true
		// true || false = true
		// false || false == false
		number = 10;		
		System.out.println();
		result = (number < 20) || (++number > 0);	// number<20이 true이기 때문에 ++number>0 연산을 수행하지 않고 결과값 도출.
		System.out.println(result);	// true
		System.out.println(number);	// 10
		
		// 예시 -> 로그인
		
	}
	
	/*	실습문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * */
	
	public void practice() {
		// A~Z : 65~90,	a~z: 97~122
		
//		System.out.print("알파벳을 입력해주세요 > ");
//		String s = sc.nextLine();
//		char text = s.charAt(0);
//		
//		boolean result2 = ((text >= 65) && (text <= 90)) || ((text >= 97) && (text <= 122));
//		
//		System.out.printf("%s는 알파벳인가요? : %s", text, result2);

		// 풀이
		// 1) 변수 초기화.
		char ch = '\u0000';	// 문자는 초기값이 '\u0000'을 통해서 함 (공백)
		boolean result = false;
		
		// 2) 
		System.out.print("문자 입력 > ");
//		String text = sc.nextLine();
//		ch = text.charAt(0);
		ch = sc.nextLine().charAt(0);
		
//		result = (65 <= ch && ch <= 90) || (97 <= ch && ch <= 122);
		result = ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
		
		System.out.println(result);
	}
	
	
	
	
	
	
	
}

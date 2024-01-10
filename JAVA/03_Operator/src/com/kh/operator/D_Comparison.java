package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {

	/*
	 * 비교연산자
	 * 
	 * a < b : a가 b보다 작은가? a > b : a가 b보다 큰가? a <= b : a가 b보다 작거나 같은가? a >= b : a가
	 * b보다 크거나 같은가? a == b : a와 b가 같은가? a != b : a와 b가 같지 않은가?
	 * 
	 * - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false를 반환 => 결과값이 boolean.
	 */

	public static void main(String[] args) {
		D_Comparison d = new D_Comparison();
//		d.method1();
		d.method2();
	}

	public void method1() {
		int a = 10;
		int b = 25;

		System.out.println("a == b : " + (a == b)); // false
		System.out.println("a <= b : " + (a <= b)); // true

		boolean result = a > b;
		System.out.println("result : " + result); // false

		System.out.println((a * 2) > (b / 5)); // true

		// 2로 나눴을 때의 나머지가 0인 경우 == 2로 나눠떨어진다의 의미 == 짝수
		// 2로 나눴을 때의 나머지가 1인 경우 == 2로 나누어떨어지지 않는다 == 홀수
		System.out.println("a가 짝수인가? : " + (a % 2 == 0)); // true
		System.out.println("b가 홀수인가? : " + (b % 2 != 0)); // true
		System.out.println("b가 홀수인가? : " + !(b % 2 == 0)); // true
		System.out.println("b가 홀수인가? : " + (b % 2 == 1)); // true

	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 > ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 > ");
		int num2 = sc.nextInt();
		
		System.out.println("첫번째 수가 두번째 수보다 큽니까? : " + (num1 > num2));
		System.out.println("첫번째 수가 짝수입니까? : " + (num1 % 2 == 0));
		System.out.println();
		
		// 문자와 숫자 간의 대소비교 가능 (문자마다 숫자가 있기 때문)
		System.out.println(num2 > 'A');	// A~Z : 65~90,	a~z: 97~122
	}
}

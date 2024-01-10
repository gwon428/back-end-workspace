package com.kh.operator;

import java.util.Scanner;

public class F_Triple {

	Scanner sc = new Scanner(System.in);

	/*
	 * 삼항 연산자 조건식(비교|논리) ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다. - 조건식의 결과가 true이면 값1, false이면 값2를 반환한다.
	 */

	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.method1_5();
//		f.practice1();
//		f.practice2();
//		f.practice3();
		f.practice3_5();
	}

	public void method1() { // void : return값이 없는 datatype임을 명시
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.print("정수를 입력하시오. > ");
		int i = sc.nextInt();
		String result = (i > 0 ? "양수" : "음수");
		// System.out.println도 void. 출력하는 역할만 하기 때문에 값1, 값2에 입력할 수 없음.
		System.out.println("입력한 정수는 " + result + "입니다.");
	}

	public void method1_5() {
		// 입력받은 정수가 양수인지 음수인지 판단, 0인 경우 0.
		System.out.print("정수를 입력하시오. > ");
		int i = sc.nextInt();
		String result = (i > 0 ? "양수" : (i == 0) ? "0" : "음수");
		System.out.println("입력한 정수는 " + result + "입니다.");
	}

	/*
	 * 실습 문제 1
	 * 
	 * 사용자에게 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 큰 경우 "결과가 100 이상입니다." 아닌 경우
	 * "결과가 100보다 작습니다." 출력
	 */

	public void practice1() {
		int i1 = 0;
		int i2 = 0;

		System.out.print("정수값 1 > ");
		i1 = sc.nextInt();
		sc.nextLine();

		System.out.print("정수값 2 > ");
		i2 = sc.nextInt();
		sc.nextLine();

		String result = (i1 * i2 >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.");
		System.out.println(result);

	}

	/*
	 * 실습 문제 2
	 * 
	 * 사용자에게 문자를 하나 입력 받아서 입력한 문자가 대문자이면 "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다." 출력
	 */

	public void practice2() {

		char ch = '\u0000';
		System.out.print("문자를 입력하십시오. > ");
		ch = sc.nextLine().charAt(0);

		String result = ('A' <= ch && ch <= 'Z') ? "알파벳 대문자이다." : "알파벳 대문자가 아니다.";
		System.out.println(result);
	}

	/*
	 * 실습 문제 3
	 * 
	 * 두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출력 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * 예시) 첫 번째 수 > 3 두 번째 수 > 4 연산자 입력(+ 또는 -) > +
	 * 
	 * 3 + 4 = 7
	 * 
	 * 
	 * 첫 번째 수 > 3 두 번째 수 > 4 연산자 입력(+ 또는 -) > -
	 * 
	 * 3 - 4 = -1
	 * 
	 * 연산자 입력(+ 또는 -) > * 잘못 입력했습니다.
	 */

	public void practice3() {
		System.out.print("첫 번째 수 > ");
		int i1 = sc.nextInt();
		sc.nextLine();

		System.out.print("두 번째 수 > ");
		int i2 = sc.nextInt();
		sc.nextLine();

		System.out.print("연산자 입력(+ 또는 -)");

		char ch = sc.nextLine().charAt(0);
		String result = (ch == '+') ? (i1 + "+" + i2 + "=" + (i1 + i2))
				: (ch == '-' ? (i1 + "-" + i2 + "=" + (i1 - i2)) : "잘못 입력했습니다.");
		System.out.println(result);

	}
	
	
	// 풀이
	
	public void practice3_5() {
		System.out.print("첫 번째 수 > ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("두 번째 수 > ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("연산자 입력(+ 또는 -) > ");
		char ch = sc.nextLine().charAt(0);
		
		// 삼항연산자
		String result = (ch == '+') ? (num1 + "+" + num2 + "=" + (num1 + num2)) : (ch == '-' ? String.format("%d - %d = %d", num1, num2, num1-num2) : "잘못 입력했습니다.");
		System.out.println(result);
		
		// 또다른 방법 printf
		if(ch == '+' || ch == '-') {
			System.out.printf("%d %c %d = %d", num1, ch, num2, (ch == '+' ? (num1+num2) : (num1-num2)));
		} else {
			System.out.println("잘못 입력했습니다.");
		}
		
		
		
	 }

}

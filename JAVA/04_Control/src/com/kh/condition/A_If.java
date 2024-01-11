package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if (조건식) { 조건식이 참(true)일 때 실행 }
	 * 
	 * - 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * 
	 */

	public void method1() {

		// 성적이 60점 이상이면 "합격입니다"

		System.out.print("성적 입력 > ");
		int score = Integer.parseInt(sc.nextLine());

		// 권장
		if (score >= 60) {
			System.out.println("합격입니다.");
		}

		// 중괄호 생략도 가능
		if (score >= 60)
			System.out.println("합격입니다.");

		if (score >= 60)
			System.out.println("합격입니다.");
		System.out.println("축하합니다22"); // if문 밖에 있는 것으로 인식
	}

	/*
	 * If-else문
	 * 
	 * if(조건문){ 조건식이 true일 때 실행 } else { 조건식이 false일 때 실행 };
	 * 
	 */

	public void method2() {

		// 성적이 60점 이상이면 "합격입니다", 아니면 "불합격입니다"를 출력
		System.out.print("성적 입력 > ");
		int score = Integer.parseInt(sc.nextLine());

		// 권장
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}

		// 삼항연산자
		String result = (score >= 60) ? "합격입니다." : "불합격입니다.";
		System.out.println(result);
		// System.out.println((score >= 60) ? "합격입니다." : "불합격입니다.");

	}

	public void method3() {
		System.out.println("이름 입력 > ");
		String name = sc.nextLine();
		// String은 클래스이기 때문에 비교하면 값이 일치하지 X

		System.out.println("name의 주소값 : " + System.identityHashCode(name)); // 1504109395
		System.out.println("본인 이름의 주소값 : " + System.identityHashCode("권예빈")); // 2047526627
		System.out.println(name == "권예빈"); // false
		// String -> 참조형 변수 (클래스 변수)는 주소값을 저장!
		System.out.println(name.equals("권예빈")); // true

		if (name.equals("권예빈")) {
			System.out.println("본인이다.");
		} else {
			System.out.println("본인이 아니다.");
		}
	}

	public void method4() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력

		System.out.print("숫자 입력 > ");
		int num = Integer.parseInt(sc.nextLine());

		// 삼항 연산자
		String result = num > 0 ? "양수" : num == 0 ? "0이다" : "음수";

		// if문
		if (num > 0) {
			System.out.println("양수");
		} else {
			if (num == 0) { // if문은 중첩 가능!
				System.out.println("0이다.");
			} else {
				System.out.println("음수");
			}
		}

	}

	/*
	 * if-else if-else문
	 * 
	 * if(조건식 1) { 조건식 1이 true일 때 실행 } else if (조건식 2) { 조건식 1이 false이면서 조건식 2가
	 * true일 때 실행 } else { 조건식 1, 조건식 2 모두 false일 때 실행 }
	 */

	public void method5() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력

		System.out.print("숫자 입력 > ");
		int num = Integer.parseInt(sc.nextLine());

		if (num > 0) {
			System.out.println("양수");
		} else if (num == 0) {
			System.out.println("0이다.");
		} else {
			System.out.println("음수");
		}

	}

	/*
	 * 사용자에게 점수 (0~100)를 입력받아서 점수별로 등급을 출력 90점 이상은 A등급 90점 미만 80점 이상은 B등급 80점 미만 70점
	 * 이상은 C등급 70점 미만 60점 이상은 D등급 60점 미만은 F등급
	 * 
	 */
	public void practice1() {
		System.out.print("점수 입력 (0~100) > ");
		int score = Integer.parseInt(sc.nextLine());

		if (score < 60) {
			System.out.println("F등급");
		} else if (score < 70) {
			System.out.println("D등급");
		} else if (score < 80) {
			System.out.println("C등급");
		} else if (score < 90) {
			System.out.println("B등급");
		} else {
			System.out.println("A등급");
		}

		String grade = sc.nextLine();
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.println(grade + "등급");

	}

	/*
	 * 세 정수를 입력했을 때 짝수만 출력 num1 입력 > 3 num2 입력 > 4 num3 입력 > 6
	 * 
	 * 4 6
	 * 
	 */
	public void practice2() {
		System.out.print("num1 입력 > ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("num2 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("num3 입력 > ");
		int num3 = Integer.parseInt(sc.nextLine());

		if (num1 % 2 == 0) System.out.println(num1);

		if (num2 % 2 == 0) System.out.println(num2);

		if (num3 % 2 == 0) System.out.println(num3);

	}

	public void practice2_5() {
		System.out.print("num1 입력 > ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("num2 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("num3 입력 > ");
		int num3 = Integer.parseInt(sc.nextLine());

		// if 하나 가지고! (중첩)비추천
		if (num1 % 2 == 0) {
			System.out.println(num1);

			if (num2 % 2 == 0) {
				System.out.println(num2);

				if (num3 % 2 == 0) {
					System.out.println(num3);
				}
			} else {
				if (num3 % 2 == 0) {
					System.out.println(num3);
				}
			}
		} else {
			if (num2 % 2 == 0) {
				System.out.println(num2);

				if (num3 % 2 == 0) {
					System.out.println(num3);

				} else {
					if (num3 % 2 == 0) {
						System.out.println(num3);
					}
				}
			}
		}

		// if ~ else if 사용! 중첩 없이! 비추천
		if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);

		} else if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0) {
			System.out.println(num1);
			System.out.println(num2);

		} else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num3);

		} else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 != 0) {
			System.out.println(num1);

		} else if (num1 % 2 != 0 & num2 % 2 == 0 && num3 % 2 == 0) {
			System.out.println(num2);
			System.out.println(num3);

		} else if (num1 % 2 != 0 & num2 % 2 == 0 && num3 % 2 != 0) {
			System.out.println(num2);

		} else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 == 0) {
			System.out.println(num3);

		} else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 != 0) {
		}
	}

	/*
	 * 정수 1개를 입력했을 때 음(minus)/양(plus)/(zero), 짝(even)/홀(odd) 출력
	 * 
	 * 정수 입력 > -3 minus odd
	 */

	public void practice3() {
		System.out.print("정수 입력 > ");
		int num = Integer.parseInt(sc.nextLine());

		if (num > 0) {
			System.out.println("양(plus)");
		} else if (num == 0) {
			System.out.println("(zero)");
		} else {
			System.out.println("음(minus)");
		}

		if (num != 0) {
			if (num % 2 == 0) {
				System.out.println("짝(even)");
			} else {
				System.out.println("홀(odd)");
			}
		}
	}

	public void practice3_5() {
		System.out.print("정수 입력 > ");
		int num = sc.nextInt();
		String result = "";
		String result2 = "";
		
		if(num>0) {
			result = "plus";
		} else if (num < 0) {
			result = "minus";
		} else {
			result = "zero";
		}
		
		if (num == 0) {
			result2 = "";
		} else if (num % 2 == 0) {
			result2 = "even";
		} else {
			result2 = "odd";
		}
		
		System.out.println(result);
		System.out.println(result2);
	}
	public static void main(String[] args) {
		A_If a = new A_If();

//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.practice1();
//		a.practice2();
//		a.practice2_5();
//		a.practice3();
		a.practice3_5();
	}

}

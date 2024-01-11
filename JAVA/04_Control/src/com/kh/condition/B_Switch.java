package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*	Switch문
	 * 
	 * 	switch(조건식){
	 * 		case 값1 :
	 * 			조건식의 결과가 값1과 같은 경우 실행 (값1 일치하고 break 만나기 전까지 실행)
	 * 			break;
	 * 		case 값2 :
	 * 			조건식의 결과가 값2와 같은 경우 실행 
	 * 			break;
	 * 		default :	
	 * 			조건식의 결과가 일치하는 case문이 없을 때 실행
	 * 	}
	 * 
	 * 	- case문의 수는 제한이 없다.
	 * 	- 조건식 결과는 정수, 문자, 문자열이어야 한다.
	 * 	- 조건문을 빠져나가려면 break가 필요하다.
	 *  - default는 생략 가능하다.
	 *  
	 * */
	
	public void method1() {
		// 숫자를 입력받아 1일 경우 "빨간색 입니다", 2일 경우 "파란색 입니다", 3일 경우 "초록색 입니다", 잘못 입력했을 경우 "잘못 입력했습니다." 출력
		
		System.out.print("숫자 입력 (1 ~ 3) > ");
		int num = sc.nextInt();
		
		if (num == 1) System.out.println("빨간색입니다.");
		else if (num == 2) System.out.println("파란색입니다.");
		else if (num == 3) System.out.println("초록색입니다.");
		else System.out.println("잘못 입력했습니다.");
		
		switch(num){
			case 1:
				System.out.println("빨간색입니다.");
				break;
			case 2:
				System.out.println("파란색입니다.");
				break;
			case 3:
				System.out.println("초록색입니다.");
				break;
			default:
				System.out.println("잘못 입력했습니다.");
		};		
	}
	
	
	public void practice1() {
		// 주민번호를 입력받아 남자인지 여자인지 출력
		System.out.print("주민번호 입력 > ");
		char no = sc.nextLine().charAt(7);
		
		switch(no) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		};
	}
	
	public void practice1_5() {
		System.out.println("주민번호 입력 > ");
		char no = sc.nextLine().charAt(7);
		// 문자를 문자열로 변환
//				String no1 = String.valueOf(no);
//				int num = Integer.parseInt(no1);
		String result = "";
		
		switch(Integer.parseInt(String.valueOf(no))) {
		case 1:
		case 3:
			result = "남자";
			break;
		case 2:
		case 4:
			result = "여자";
			break;
		default :
			result = "한국인이 아닙니다.";
		};
		System.out.println(result);
	}
	
	public void practice2() {
		// 등급별 권한 부여
		// 1 : 관리 권한, 글쓰기 권한, 읽기 권한
		// 2 : 글쓰기 권한, 읽기 권한
		// 3 : 읽기 권한
		
		System.out.print("등급 입력 > ");
		int grade = sc.nextInt();
		
		switch(grade) {
		case 1: System.out.println("관리 권한");
		case 2: System.out.println("글쓰기 권한");
		case 3: System.out.println("읽기 권한");
		}
	}
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
		
//		b.method1();
//		b.practice1();
//		b.practice1_5();
		b.practice2();
	}

}

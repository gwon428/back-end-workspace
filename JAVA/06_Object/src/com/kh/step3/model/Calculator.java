package com.kh.step3.model;

public class Calculator {

	/*	메서드(Method)
	 	- 작업을 수행하기 위한 명령문의 집합
	 	- 어떤 값을 입력받아서 처리하고 그 결과를 돌려준다.
	 	- 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음.
	 	- 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것을 권고
	 	
	 	리턴타입 메서드이름(타입 변수명, 타입 변수명, ...){	<-- 여기가 입력받는 곳
	 		// 메서드 호출 시 수행될 코드
	 		return [반환할결과값];					<-- 여기가 출력하는 곳
	 	}
	 	
	 	return문
	 	- 메서드에서 return을 만나면 종료 (반환할 결과값의 유무와 무관하게)
	 	- 반환값이 없는 'void'의 경우 return문만 사용하기도
	 	- [return으로 빠져나간다고 간주]
	 	- 반환값이 있는 경우 return문 뒤에 반환값을 지정해야 함
	 */
	// public int a, b; (가능!)
	public int a;
	public int b;

	public int add() {
		return a + b;
	}

	public int substract() {
		return a - b;
	}

	// 오버로딩!!! [훗날 기술면접] => 메서드명이 같으나 매개변수에 설정한 것이 다를 때 메서드를 다르게 인식 => [다형성.]
//	public int multiply() {
//		return a*b;
//	}
//	
//	public String multiply(int a) {
//		return "a * b";
//	}
	
	// 매개변수를 적용 -> 우선순위가 더 높음
	public int multiply(int a, int b) {
		return a * b;
	}
	
	/*	1. 인스턴스 메서드
	 		- 객체 생성 후, '참조변수.메서드명()' 호출
	 		- 인스턴스 변수나 인스턴스 메서드와 관련된 작업을 하는 메서드
	 	
	 	2. 클래스 메서드(static 메서드)
	 		- 객체 생성 없이 '클래스명.메서드명()' 호출
	 		- 인스턴스 변수나 인스턴스 메서드와 관련없는 작업을 하는 메서드
	 
	 */

//	public void divide_() {
//		System.out.printf("몫은 %d, 나머지는 %d", quotient(), remainder());
//	}

	// static은 객체 생성 전에 생김. 그런데 이 안에 (static이 아닌) 객체 생성 후에 올라갈 수 있는 변수들이 생성 전에는 존재하지 않기 때문에 오류가 남
	// 아예 static이 아니거나, 모두 다 static으로 넣어야 함. => 매개변수로 넣어버리는 방법 혹은 a, b를 처음 선언할 때부터 static으로 만드는 방법
	public static String divide(int a, int b) {
		return ("몫은 " + quotient(a, b) + ", 나머지는 " + remainder(a, b));
	}

	public static int quotient(int a, int b) {
		return a / b;
	}

	public static int remainder(int a, int b) {
		return a % b;
	}
	
}

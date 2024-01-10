package com.kh.variable;

public class A_Variable {

	/*
	 * 변수(Variable) - 값을 저장하는 '공간'
	 */

	public static void main(String[] args) {

		// 실행할 메소드가 있는 클래스를 생성(new)
		// 데이터타입(클래스도 데이터타입) 변수명 = new 클래스명();
		A_Variable variable = new A_Variable();

		// 생성한 클래스로 메소드 실행(호출)
//		variable.printValue();
//		variable.variableTest();
		variable.constant();
	}

	public void printValue() {

		// console에 원의 둘레와 원의 넓이를 출력하시오. (둘레 : 반지름(10) X 2 X 3.141592, 넓이: 반지름(10) X
		// 반지름(10) X 3.141592
		// 변수를 사용 X
		System.out.println(10 * 2 * 3.141592);
		System.out.println(10 * 10 * 3.141592);

		System.out.println("---------------");
		// 변수 사용
		int r = 10;
		double pi = 3.141592;

		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);

	}

	public void variableTest() {
		/*
		 * * 변수의 선언 * 자료형 변수명;
		 *
		 * - 자료형: 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보 (변수를 어디에 넣을지(?)) - 변수명: 변수의 이름으로
		 * 값을 읽고, 쓰고, 지우는 작업을 할 때 사용
		 * 
		 * * 변수의 초기화 * 변수명 = 값;
		 *
		 * - 변수에 처음으로 값을 저장하는 것 - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자 (a=b : b를 a에 저장한다.)
		 */

		// * 기본 자료형(Primitive type): 실제 값을 저장
		// 8개 -> boolean, char, byte, short, int, long, float, double
		// 스택 메모리에 생성된 공간에 실제 변수값이 저장
// 1. 논리형: 1byte(=8bit)
		boolean isTrue; // 변수 선언
		isTrue = true; // 변수 초기화

		boolean isFalse = false;// 변수 선언과 초기화
		// isFalse = 1; // 에러 => boolean datatype에 int를 저장하려고 했기 때문!

// 2. 문자형: 2byte(=16bit)
		char ch = 'a'; // ''만 가능. "" 불가능.
		// ch = 'ab'; // 에러 => char datatype은 한 글자만 가능.

// 3. 정수형(byte, short, int, long)
// 1) byte: 1byte(-128~127)	256 = 2^8
		byte bNum = 1;
		bNum = 127;
		// bNum = 128; // 에러 => 오버플로우(Overflow): byte 타입이 표현할 수 있는 최대 표현 범위보다 큰 수를 저장하려고
		// 했기 때문
		// bNum = -129; // 에러 => 언더플로우(UnderFlow)

// 2) short: 2byte 2^16
		short sNum = 128;

// 3) int: 4byte (기본)
		int iNum = 2000000000;

// 4) long: 8byte
		// 숫자 뒤에 'L' 또는 'l'을 붙여줘야 함.
		long lNum = 123456789045L;

// 4. 실수형(float, double)
// 1) float: 4byte
		// 실수 뒤에 'F' 또는 'f'를 붙여줘야 함.
		float fNum = 1.2F;

// 2) double: 8byte (기본)
		double dNum = 1.2;

		// * 참조 자료형: 4byte, 기본형을 제외한 나머지 (클래스)- 주소 값을 저장
		// 실제 데이터 값은 힙 메모리에 저장하고, 스택 메모리의 변수 공간에는 실제 변수 값이 저장된 힙 메모리의 위치 값을 저장.
// 1) 문자열(String) "" 가능!!
		String name = "이상현";
		String name2 = new String("이상현");
		System.out.println(name2);

		// * 변수의 네이밍 규칙 *
		// 1. 대소문자 구분한다.
		int number;
		// String number; - 에러! 자료형이 달라도 변수명이 같으면 에러 발생
		int NUMBER;
		int Number;
		// JAVA는 number, NUMBER, Number를 모두 다른 변수로 인식한다.

		// 2. 숫자로 시작하면 안 된다.
		// int 1age; - 에러! 숫자로 시작하면 안됨.
		int a2g3e4;

		// 3. 특수 문자는 '_', '$'만 사용이 가능하다.
		int _age; // 특수문자로는 시작 가능!
		int age$;

		// 4. 예약어(Reserved word)를 사용하면 안 된다.
		// int public;
		// int void;
		// int int;
		// int class;
		int class2;

		// 5. (권장사항) 낙타표기법(CamelCase)
		// 첫글자는 항상 소문자, 여러 단어가 오면 대문자로 구분
		int maxnumber;
		int maxNumber;
		int max_number; // 자바에서 X

	}

	public void constant() {
		/*
		 * 상수
		 * 
		 * final 자료형 변수명;
		 *
		 * - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용 - 초기화 이후에는 값을 변경할 수 없다.
		 */
		int age = 20;
		age = 25;
		System.out.println(age);

		final int AGE = 30;
		// AGE = 35; - 에러 발생! final로 상수 처리 했기 때문에 값이 변경될 수 X.

	}

}

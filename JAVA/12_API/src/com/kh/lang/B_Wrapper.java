package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
		B_Wrapper b = new B_Wrapper();
//		b.method1();
		b.method2();
	}
	// 제네릭스 -> Integer. 같은 형태로 써야하는 이유
	public void method1() {
		double dNum1 = 3.14;
		// Deprecated : 기능은 있지만 비권장할 경우 취소선
//		Double double1 = new Double(3.14);
		Double double1 = new Double(dNum1);
		double1 = 3.14;		// Boxing : 기본 자료형 -> Wrapper 클래스로 바꾼다

		int iNum2 = 3;
		Integer int1 = new Integer(3);
		int1 = 3;
		
		char ch3 = 'a';
		Character ch4 = new Character('a');
		ch4 = 'a';
		
		// UnBoxing : Wrapper -> 기본 자료형으로 바꾼다
		int iNum3 = Integer.parseInt("20");
		double dNum2 = Double.parseDouble("34.78");
	}
	
	// String과 Wrapper 클래스 간의 변경
	public void method2() {
		// UnBoxing : Wrapper -> 기본 자료형으로 바꾼다
		// 1. 문자열을 기본 자료형으로 변경 (parseXXX()를 통해서)
		int iNum = Integer.parseInt("20");
		double dNum = Double.parseDouble("34.78");
		
		// 2. 기본 자료형을 문자열로 변경
		// String의 valueOf() 메서드
		System.out.println(iNum + dNum);		// 54.78
		String str1 = String.valueOf(iNum);
		String str2 = String.valueOf(dNum);
		System.out.println(str1 + str2);		//2034.78
		
		// Wrapper 클래스에서 제공하는 valueOf().toString() 메서드
		String str3 = Integer.valueOf(iNum).toString();
		String str4 = Double.valueOf(dNum).toString();
		System.out.println(str3 + str4);		//2034.78
		
	}
	
	
}

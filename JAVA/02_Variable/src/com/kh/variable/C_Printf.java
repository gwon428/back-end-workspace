package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {

		// System.out.println(출력하고자하는값);	-- 출력 후 줄바꿈 발생 O
		// System.out.print(출력하고자하는값);	-- 출력만 함 (줄바꿈 발생 X)
		
		System.out.println("hello");
		System.out.print("hello");
		//hello
		//hello
		System.out.println("\n-----------------------------------------------");

		
		System.out.print("hello");
		System.out.println("hello");
		//hellohello
		
		System.out.println("-----------------------------------------------");
		
		System.out.print("hello\n");
		System.out.println("hello");
		//hello
		//hello
		
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		
		// System.out.printf("출력하고자하는형식(format)",출력하고자하는값, 값, ... );
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*	포맷으로 쓰이는 키워드
		 * %d: 정수
		 * %f: 실수
		 * %c: 문자
		 * %s: 문자열 (문자도 가능)
		 * */
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10%, 20%
		System.out.println(iNum1 + "% " + iNum2 + "%");
		System.out.printf("%d%% %d%%", iNum1, iNum2);		// %d%% -> %d + %% (%를 문자로 인식하겠다.)
		System.out.println("\n-----------------------------------------------");
		
		
		System.out.printf("%5d\n", iNum1);	//   10		(5d:5칸 공간 확보 후 양수 오른쪽 정렬( | | |1|0)
		System.out.printf("%-5d\n", -iNum2);	//  -20	(-5d: 5칸 공간 확보 후 음수 왼쪽 정렬(-|2|0| | )
		System.out.printf("%5d\n", 300);	//  300		( | |3|0|0)
		System.out.println("-----------------------------------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n", dNum1, dNum2);		// 무조건 소수점 아래 6번째 자리까지 (잘르거나 0이 더해더라도)
		//1.234568 4.530000
		// \t => tab.
		
		System.out.printf("%.3f\t%.2f\n", dNum1, dNum2);		// %.3f:소수점 아래 3번째 자리, %.2f:2번째 자리까지
		System.out.println("-----------------------------------------------");
		
		char ch = 'a';
		String str = "Hello";
		
//		System.out.printf("%c %10s %s\n", str);		// 실행 후 오류 (c != java.lang.String)
//		System.out.printf("%c %10s %s\n", ch, str);	// 실행 후 오류 (Format specifier '%s')
		System.out.printf("%c %10s", ch, str);
		System.out.println();
		System.out.printf("%c %10s %s\n", ch, str, str);
		System.out.printf("%c %10s %s\n", ch, str, str, str);	// 오류는 안 남.
		
		System.out.printf("%C %S", ch, str);	//A HELLO => 모두 대문자로만 출력.
		
	}

}

package com.kh.operator;

public class C_Arithmetic {

	/*	산술 연산자
	 * 	+ : 더하기
	 * 	- : 빼기
	 * 	* : 곱하기
	 * 	/ : 나누기
	 * 	% : 나머지
	 * 
	 * */
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		
//		c.method1();
		c.method2();
	}

	public void method1() {
		int num1 = 10;
		int num2 = 3;
		System.out.println(" + : " + num1 + num2);	//num1과 num2를 문자로 인식하게 되어 103으로 출력
		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 3
		System.out.println(" % : " + (num1 % num2)); // 1
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b;	// c=16, a=6
		int d = c / a;	// 16/6 = 2		// d=2
		int e = c % a;	// 16%6 = 4		// e=4
		int f = e++;	// 4 -> 5		// f=4, e=5
		int g = (--b) + (d--);	//9 + 2 = 11	// g=11, b=9, d=1
		int h = 2;
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		//			 6 + 9 / (15/	4)*(	11-	1)%(	6+	2)
		//			6 + 9 /		3	*		10	%		8
		// 			6 + 3*10%8
		//			6 + 30%8
		//			6+6
		System.out.println(i);
	}
}

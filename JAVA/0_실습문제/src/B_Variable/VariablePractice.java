package B_Variable;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		
		v.method1();
		v.method2();
		v.method3();
	}
	
	public void method1() {
		int adult = 2;
		int teen = 3;
		int adultP = 10000;
		int teenP = 7000;
		int adP = adult*adultP;
		int tP = teen*teenP;
		
		System.out.printf("성인 %d명 : %d원", adult, adP);
		System.out.println();
		System.out.printf("청소년 %d명 : %d원", teen, tP);
		System.out.println();
		System.out.println();
		System.out.printf("총 금액 : %d원", adP + tP);
	}
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		int a = x;
		x = y;
		y = z;
		z = a;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}
	public void method3() {
		System.out.print("문자열을 입력하세요 : ");
		String input = sc.nextLine();
		char first = input.charAt(0);
		char last = input.charAt(input.length()-1);
		
		System.out.println("첫번째 문자 : " + first);
		System.out.println("두번째 문자 : " + last);
	}
	
}

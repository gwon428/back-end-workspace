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
		
	}
	public void method3() {
		
	}
	
}

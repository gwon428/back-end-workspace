package com.kh.practice;
// 클래스 이름: com.kh.practice.VariablePractice
// FQCN (Fully Qualified Class Name)  완전한 클래스명
import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		
		v.method1();
		v.method2();
		v.method3();
		v.method4();
		v.method5();
	}

	public void method1() {
		int adult = 2;
		int teen = 3;
		int adPrice = 10000;
		int teenPrice = 7000;
		
		System.out.println("성인 " + adult + "명 : " + adPrice * adult + "원");
		System.out.println("청소년 " + teen + "명 : " + teenPrice * teen + "원");
		
		System.out.println("총 금액 : " + (adPrice*adult + teenPrice*teen) + "원");
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
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String input = sc.nextLine();
		char first = input.charAt(0);
		char last = input.charAt(input.length()-1);
		
		System.out.println("첫번째 문자 : " + first);
		System.out.println("두번째 문자 : " + last);
	}

	public void method4() {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("문자 : ");
		String input = sc1.nextLine();
		char text = input.charAt(0);
		
		char ch = (char) text;
		int num = ch;
		System.out.println("A unicode : " + num);
		System.out.println("B unicode : " + (num+1));
	}
	
	public void method5() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("국어 : ");
		int kor = sc2.nextInt();
		sc2.nextLine();
		
		System.out.print("영어 : ");
		int eng = sc2.nextInt();
		sc2.nextLine();
		
		System.out.print("수학 : ");
		int math = sc2.nextInt();
		sc2.nextLine();
		
		int sum = kor + eng + math;
		System.out.println("총점 : " + sum);
		
		double div = sum / 3;
		System.out.println(div);
		System.out.printf("평균 : %.2f", div);
	}
	
}

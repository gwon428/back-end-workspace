package B_Variable;

import java.util.Scanner;

public class CastingPractice {

	Scanner sc = new Scanner(System.in)
			;
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
		
//		c.method1();
		c.method2();
	}

	public void method1() {
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		System.out.println("A unicode : " + (int) ch);
		System.out.println("B unicode : " + ((int) ch + 1));
	}
	
	public void method2() {
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		sc.nextLine();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		sc.nextLine();
		
		int sum = kor + eng + math;
		System.out.printf("총점 : %d\n" , sum);
		
	
		double div = (sum) / 3.0;
		System.out.printf("평균 : %.2f", div);
	}
}

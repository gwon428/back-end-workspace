package B_Variable;

import java.util.Scanner;

public class CastingPractice {

	Scanner sc = new Scanner(System.in)
			;
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
		
		c.method1();
		c.method2();
	}

	public void method1() {
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		System.out.println("A unicode : " + (int) ch);
		System.out.println("B unicode : " + ((int) ch + 1));
	}
	
	public void method2() {
	}
}

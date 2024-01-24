package chap01;

import java.util.Scanner;

public class Median {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 정수의 중앙값을 구합니다.");
		System.out.print("a : ");
		int a = sc.nextInt();
		System.out.print("b : ");
		int b = sc.nextInt();
		System.out.print("c : ");
		int c = sc.nextInt();
		
		System.out.println("중앙값은 " + med(a, b, c) + "입니다.");
	}

	static int med(int a, int b, int c) {
		if (a >= b) {
			if (b >= c) {
				return b;
			} else if (a <= c) {
				return a;
			} else {
				return c;
			}
			
			// a < b
		} else if (a > c) {	
			return a; 
		} else if (b > c) {
			return c; 
		} else {
			return b; 
		}
	}
	
	

}

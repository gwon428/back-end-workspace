package chap01;

import java.util.Scanner;

public class Practice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Practice p = new Practice();
		
//		p.max4();
//		p.min3();
//		p.min4();
		p.med1();
	}
	
	public void max4() {
		// 네 값의 최댓값을 구하는 max4 메서드를 작성하세요.
		System.out.print("a : ");
		int a = sc.nextInt();
		
		System.out.print("b : ");
		int b = sc.nextInt();
		
		System.out.print("c : ");
		int c = sc.nextInt();
		
		System.out.print("d : ");
		int d = sc.nextInt();
		
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		if(d > max) max = d;
		
		System.out.println("최댓값 : " + max);
		
	}
	
	public void min3() {
		// 세 값의 최솟값을 구하는 min3 메서드를 작성하세요.
		System.out.print("a : ");
		int a = sc.nextInt();
		
		System.out.print("b : ");
		int b = sc.nextInt();
		
		System.out.print("c : ");
		int c = sc.nextInt();
		
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		
		System.out.println("최솟값 : " + min);
	}
	
	public void min4() {
		// 네 값의 최솟값을 구하는 min4 메서드를 작성하세요.
		System.out.print("a : ");
		int a = sc.nextInt();
		
		System.out.print("b : ");
		int b = sc.nextInt();
		
		System.out.print("c : ");
		int c = sc.nextInt();
		
		System.out.print("d : ");
		int d = sc.nextInt();
		
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		if (d < min) min = d;
		
		System.out.println("최솟값 : " + min);
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

	public void med1() {
		System.out.println("med (3, 2, 1) " + med(3, 2, 1));
		System.out.println("med (3, 2, 1) " + med(3, 2, 1));
		System.out.println("med (3, 1, 2) " + med(3, 1, 2));
		System.out.println("med (3, 2, 3) " + med(3, 2, 3));
		System.out.println("med (2, 1, 3) " + med(2, 1, 3));
		System.out.println("med (3, 3, 2) " + med(3, 3, 2));
		System.out.println("med (3, 3, 3) " + med(3, 3, 3));
		System.out.println("med (2, 2, 3) " + med(2, 2, 3));
		System.out.println("med (2, 3, 1) " + med(2, 3, 1));
		System.out.println("med (2, 3, 2) " + med(2, 3, 2));
		System.out.println("med (1, 3, 2) " + med(1, 3, 2));
		System.out.println("med (2, 3, 3) " + med(2, 3, 3));
		System.out.println("med (1, 2, 3) " + med(1, 2, 3));
	}
	
	static int med3(int a, int b, int c) {
		if((b>=a && c <= a) || (b <= a && c >= a)) {
			return a;
		} else if ((a>b && c < b) || (a < b && c > b)) {
			return b;
		} return c;
	}
	
	public void q5() {
		// 중앙값을 구하는 메서드는 med()이 아닌 med3()처럼 작성할 수도 있다. 하지만 med3()에 비해 효율이 떨어지는 이유는?
		// (b>=a && c <= a) || (b <= a && c >= a)을 뒤집은 (실질적으로 동일한) 판단이 다시 수행되기 때문
	}
	
	
	
}

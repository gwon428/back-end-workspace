package C_Operator;

import java.util.Scanner;

public class F_Triple {

	Scanner sc = new Scanner(System.in)
			;
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
		
//		f.method1();
//		f.method2();
		f.method3();
	}

	/*	실습 문제 1
	 * 
	 * 	사용자에게 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 큰 경우
	 * 	"결과가 100 이상입니다."
	 * 	아닌 경우
	 * 	"결과가 100보다 작습니다." 출력
	 * */
	public void method1() {
		System.out.print("정수 1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 : ");
		int num2 = sc.nextInt();
		
		String result = (num1 * num2 >= 100) ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		System.out.println(result);
	}
	
	/*	실습 문제 2
	 * 
	 * 	사용자에게 문자를 하나 입력 받아서 입력한 문자가 대문자이면 "알파벳 대문자이다."
	 * 	아닌 경우 "알파벳 대문자가 아니다." 출력
	 * */
	public void method2() {
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		String result = ('A' <= ch && ch <= 'Z')? "알파벳 대문자이다." : "알파벳 대문자가 아니다";
		System.out.println(result);
	}
	
	/*	실습 문제 3
	 * 
	 * 	두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출력
	 * 	단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * 	예시)
	 * 	첫 번째 수 > 3
	 *  두 번째 수 > 4
	 *  연산자 입력(+ 또는 -) > +
	 *  
	 *  3 + 4 = 7
	 *  
	 *  
	 * 	첫 번째 수 > 3
	 *  두 번째 수 > 4
	 *  연산자 입력(+ 또는 -) > -
	 *  
	 *  3 - 4 = -1
	 *  
	 *  연산자 입력(+ 또는 -) > *
	 *  잘못 입력했습니다.
	 * */
	public void method3() {
		System.out.print("첫 번째 수 > ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 수 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자 입력 (+ 또는 -) > ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch == '+') ? (num1 + " + " + num2 + " = " + (num1 + num2))
						: (ch == '-') ? String.format("%d - %d = %d", num1, num2, num1-num2) : "잘못 입력했습니다.";
		System.out.println(result);
		
	}
}


package C_Operator;

import java.util.Scanner;

public class E_Logical {
	
	static Scanner sc = new Scanner(System.in);

	
	/*	실습문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * */
	public static void main(String[] args) {
		char ch = '\u0000';	// 문자는 초기값이 '\u0000'을 통해서 함 (공백)
		boolean result = false;
		
		System.out.print("문자 입력 > ");
		ch = sc.nextLine().charAt(0);
		
		result = ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
		
		System.out.println(result);
	}


	
}

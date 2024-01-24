package chap01;

import java.util.Scanner;

public class JudgeSign {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("이 수는 양수입니다.");
		} else if (num < 0) {
			System.out.println("이 수는 양수입니다.");
		} else {
			System.out.println("이 수는 0입니다.");
		}
		
	}

}

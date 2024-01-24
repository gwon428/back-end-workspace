package chap01;

import java.util.Scanner;

public class Max3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("세 정수의 최댓값을 구합니다.");
		System.out.print("a의 값 : ");
		int a = sc.nextInt();
		System.out.print("b의 값 : ");
		int b = sc.nextInt();
		System.out.print("c의 값 : ");
		int c = sc.nextInt();

		// 순차(sequential)구조 : 여러 문장이 순차적으로 실행되는 구조
		int max = a;
		
		// 선택(selection)구조 : () 안에 있는 식을 평가한 결과에 따라 프로그램의 실행 흐름을 변경하는 if문
		if (b > max) max = b;
		if (c > max) max = c;

		System.out.println("최댓값은 " + max + "입니다.");
		
		// 알고리즘 : 어떤 문제를 해결하기 위한 절차. 명확하게 정의되고 순서가 있는 유한 개의 규칙으로 이루어진 집합
	}

}

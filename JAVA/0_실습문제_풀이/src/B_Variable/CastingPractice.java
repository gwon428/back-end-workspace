package B_Variable;

import java.util.Scanner;

public class CastingPractice {

	Scanner sc = new Scanner(System.in);;

	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();

//		c.method1();
		c.method2();
	}

	// 키보드로 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	public void method1() {
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);

		int num = ch; // 자동 형 변환
		System.out.println(ch + " unicode : " + num);

		char ch2 = (char) (num + 1);
		System.out.println(ch2 + " unicode : " + (int) ch2);
	}

	// 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	public void method2() {
		System.out.print("국어 : ");
		int kor = sc.nextInt();

		System.out.print("영어 : ");
		int eng = sc.nextInt();

		System.out.print("수학 : ");
		int math = sc.nextInt();

		int sum = kor + eng + math;
//		System.out.printf("총점 : %d\n" , sum);
		System.out.println("총점 : " + sum);

//		double div = (sum) / 3.0;
//		System.out.printf("평균 : %.2f", div);
		System.out.printf("평균 : %.2f", (double) sum / 3);

	}
}

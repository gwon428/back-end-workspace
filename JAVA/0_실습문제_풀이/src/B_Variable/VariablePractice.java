package B_Variable;

import java.util.Scanner;

public class VariablePractice {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();

//		v.method1();
//		v.method2();
		v.method3();
	}

	public void method1() {
		int adultPrice = 10000;
		int teenPrice = 7000;
		int adultCount = 2;
		int teenCount = 3;

		int adultTotal = adultCount * adultPrice;
		int teenTotal = teenCount * teenPrice;

		System.out.printf("성인 %d명 : %d원\n", adultCount, adultPrice);

		System.out.printf("청소년 %d명 : %d원\n\n", teenCount, teenPrice);

		System.out.printf("총 금액 : %d원\n", adultTotal + teenTotal);

	}

	// x=5, y=7, z=9의 값을 다음과 같이 출력하세요. (x=7, y=9, z=5)
	public void method2() {

		int x = 5;
		int y = 7;
		int z = 9;

		int tmp = x;
		x = y;
		y = z;
		z = tmp;

		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}

	public void method3() {
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();

		System.out.println("첫번째 문자 : " + str.charAt(0));
		System.out.println("두번째 문자 : " + str.charAt(str.length() - 1));
	}

}

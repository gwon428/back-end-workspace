package com.kh.loop;

import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);
	
	/*	while문
	 * 
	 * 	while(조건식){
	 * 		조건이 true일 경우 계속 실행
	 * 	}
	 * */
	
	// 1부터 5까지 출력
	public void method1() {
		// for문
		for (int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// while문
		int i = 1;
		while (i<=5) {
			System.out.println(i);
			i++;
		}
	}
	
	// 무한 루프 & break문 (while을 사용하는 것이 나음)
	/*	break문
	 * 
	 * 	- switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * ** - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다. **
	 * 
	 * */
	public void method2() {
//		for (;;) {
//			
//		}
		
		while (true) {
			System.out.println("숫자 입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			if (num == 0) {
				System.out.println("종료");
				break;
			}
		}
	}
	
	/*	do { } while 반복문
	 * 
	 * 	do {
	 * 		실행 코드
	 * 	} while (조건식);
	 * 
	 * */

	public void method3() {
		int number = 1;
		while (number == 0) {
			System.out.println("while문");
		}
		
		do {
			System.out.println("do - while문");
		} while (number == 0);
		// 실행 후 조건식으로 들어감
	}
	
	// 숫자 맞히기 게임
	/*	1과 100 사이의 값을 입력해서 임의로 지정한(Random)값을 맞히면 게임 끝!
	 * 게임이 끝나면 몇 번만에 숫자를 맞혔는지 출력!
	 * 
	 * 예 : 57)
	 * 1과 100 사이의 값 입력 > 35
	 * 더 큰 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 57
	 * 3번 만에 맞췃습니다.
	 * */
	
	public void method4() {
		double random = Math.random() * 100+1; // 1.0 <= random < 101.0
		random = (int) random;
		int i=1;
		while (true) {
			System.out.println("1과 100 사이의 값 입력 > ");
			int num = sc.nextInt();
			if (num == random) {
				System.out.println(i + "번 만에 맞췄습니다.");
				break;
			} else if (num > random ) {
				System.out.println("더 작은 값을 입력하세요.");
				i++;
			} else if (num < random) {
				System.out.println("더 큰 값을 입력하세요.");
				i++;
			}
		}
	}
	
	/*	--------------------------------
	 * 	1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * 	--------------------------------
	 *  선택 > 1
	 *  예금액 > 5000
	 *	--------------------------------
	 * 	1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * 	--------------------------------
	 *  선택 > 2
	 *  출금액 > 2000
	 *  --------------------------------
	 * 	1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * 	--------------------------------
	 *  선택 > 3
	 *  잔고 > 3000
	 *	--------------------------------
	 * 	1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * 	--------------------------------
	 *  선택 > 4
	 *  프로그램 종료
	 * 
	 * */
	public void method5() {
		int bal = 0;
		while(true) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
			System.out.println("--------------------------------");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.print("예금액 > ");
				bal += sc.nextInt();
			} else if (select == 2) {
				System.out.print("출금액 > ");
				bal -= sc.nextInt();
			} else if (select == 3) {
				System.out.println("잔고 > " + bal);
			} else if (select == 4) {
				System.out.println("프로그램 종료");
				break;
			}
		}		
	}
	
	public void method5_5() {
		int bal = 0;
		boolean b = true;
		while (b) {
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.print("예금액 > ");
				bal += sc.nextInt();
				break;
			case 2:
				System.out.print("출금액 > ");
				bal -= sc.nextInt();
				break;
			case 3:
				System.out.println("잔고 > " + bal);
				break;
			case 4:
				b = false;
				System.out.println("프로그램 종료");
				break;
			}

		}
		
	}
	public void method5_sol() {
		int bal = 0;
		boolean check = true;
		while (check) {
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				System.out.print("예금액 > ");
				bal += sc.nextInt();
				break;
			case 2:
				System.out.print("출금액 > ");
				int ex = sc.nextInt();
				if (ex > bal) System.out.println("잔고가 부족합니다 ㅠㅠ");
				bal -= sc.nextInt();
				break;
			case 3:
				System.out.println("잔고 > " + bal);
				break;
			case 4:
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
		
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
//		d.method5_5();
//		d.method5_sol();
	}

}

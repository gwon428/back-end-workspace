package com.kh.practice;

import java.util.Scanner;
import com.kh.practice.controller.LibraryController;

public class Application {

	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		lc.setMember(name, age);

		boolean check = true;
		while (check) {
			System.out.println("====메뉴====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				myPage();
				break;
			case 2:
				rentBook();
				break;
			case 3:
				check = false;
				break;
			}
		}
	}

	public void myPage() {
		System.out.println(lc.info());
	}

	public void rentBook() {
		for (int i = 0; i < lc.getBookList().length; i++) {
			System.out.println(i + "번 도서 : " + lc.getBookList()[i]);
		}
		System.out.print("대여할 도서 번호 선택 : ");
		int num = sc.nextInt();
		//만약 book이 cookbook -> coupon 여부 -> +1 혹은 유지
		// 만약 AccessAge와 비교해서 member의 나이가 적을 경우 대여 불가능
		if (num < lc.getBookList().length) {
			switch (num) {
			case 0:
				lc.info().setCookCoupon(+1);
				System.out.println("성공적으로 대여되었습니다.");
				lc.rent(num);
				break;
			case 1:
				System.out.println("성공적으로 대여되었습니다.");
				lc.rent(num);
				break;
			case 2:
				if(lc.ageCheck(lc.info().getAge())) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				} else {
					System.out.println("성공적으로 대여되었습니다.");
					lc.rent(num);
				}
				return;
			case 3:
				if(lc.ageCheck2(lc.info().getAge())) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				} else {
					System.out.println("성공적으로 대여되었습니다.");
					lc.rent(num);
				}
				return;
			}
		}
		

	}
}
package H_Polymorphism.practice;

import java.util.Scanner;
import H_Polymorphism.practice.controller.LibraryController;

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
		int age = sc.nextInt();
		lc.setMember(name, age);
		
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: myPage();
				break;
			case 2: rentBook();
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
		
	}

}

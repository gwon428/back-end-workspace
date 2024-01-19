package com.kh.example.practice4;

import java.util.Scanner;

import com.kh.example.practice4.controller.CircleController;
import com.kh.example.practice4.controller.RectangleController;
// View
public class Application {

	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	public static void main(String[] args) {
		Application app = new Application();
		
		app.mainMenu();
	}
	
	// 메인메뉴 출력
	public void mainMenu() {

		boolean check = true;
		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");

			int mm = Integer.parseInt(sc.nextLine());
			switch (mm) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	// 원메뉴 출력
	public void circleMenu() {
		System.out.println("==== 원 메뉴 ====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int cm = Integer.parseInt(sc.nextLine());
		
		switch (cm) {
		case 1:
			calcCircum();
			break;
		case 2:
			calcCircleArea();
			break;
		case 9:
//			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}
	
	// 사각형 메뉴 출력
	public void rectangleMenu() {
		System.out.println("==== 사각형 메뉴 ====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int rm = Integer.parseInt(sc.nextLine());
		
		switch (rm) {
		case 1:
			calcPerimeter();
			break;
		case 2:
			calcRectArea();
			break;
		case 9:
//			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}
	
	//x, y 좌표와 반지름을 받아 원의 정보와 원 둘레 출력
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.print("반지름 : ");
		int radius = Integer.parseInt(sc.nextLine());
		System.out.println(cc.calcCircum(x, y, radius));

	}
	
	// x, y 좌표와 반지름을 받아 원의 정보와 원 넓이 출력
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.print("반지름 : ");
		int radius = Integer.parseInt(sc.nextLine());
		System.out.println(cc.calcArea(x, y, radius));
	}
	//x, y 좌표와 반지름을 받아 사각형의 정보와 원 둘레 출력
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.print("높이 : ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("너비 : ");
		int width = Integer.parseInt(sc.nextLine());
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	// x, y 좌표와 반지름을 받아 사각형의 정보와 원 넓이 출력
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.print("높이 : ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("너비 : ");
		int width = Integer.parseInt(sc.nextLine());
		System.out.println(rc.calcArea(x, y, height, width));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

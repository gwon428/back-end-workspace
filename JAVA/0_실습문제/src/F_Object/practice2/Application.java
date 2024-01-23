package F_Object.practice2;

import java.util.Scanner;

import F_Object.practice2.controller.SnackController;

public class Application {

	SnackController controll = new SnackController();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		SnackController control = new SnackController();
		
		System.out.println(control.saveData(kind, name, flavor, numOf, price));
		
		System.out.println(control.confirmData());
		
		// 
	}

}

package com.kh.test6;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.test6.model.Food;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Food> list = new ArrayList<>();
		
		boolean check = true;
		while(check) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			
			System.out.print("번호 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) {
			case 1:
				System.out.print("추가할 음식 입력 : ");
				String name = sc.nextLine();
				System.out.print("칼로리 입력 : ");
				int kcal = Integer.parseInt(sc.nextLine());
				list.add(new Food(name, kcal));
				System.out.println("음식 정보가 추가 되었습니다.");
				break;
			case 2:
				for(Food f : list) {
					System.out.println(f);
				}
				break;
			case 3:
				System.out.print("삭제하고 싶은 음식 선택 : ");
				String name2 = sc.nextLine();
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name2)) {
						System.out.println(list.get(i) + "가 삭제되었습니다.");
						list.remove(list.get(i));
					}
				}
				break;
			case 4:
				System.out.println("프로그램 종료");
				check = false;
				break;
			}
		}
	}

}

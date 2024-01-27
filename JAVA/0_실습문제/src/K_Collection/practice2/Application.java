package K_Collection.practice2;

import java.util.Scanner;

import K_Collection.practice2.controller.SongController;

public class Application {

	Scanner sc = new Scanner(System.in);
	SongController controller = new SongController();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu(){
		
		System.out.println("==== 메인 메뉴 ====");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
		System.out.println("4. 특정 곡 검색");
		System.out.println("5. 특정 곡 삭제");
		System.out.println("6. 특정 곡 수정");
		System.out.println("7. 곡 명 오름차순 정렬");
		System.out.println("8. 가수 명 내림차순 정렬");
		System.out.println("9. 종료");
		
		try {
			int menu = 0;
			System.out.print("메뉴 번호 입력 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: 
				firstMenu();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void firstMenu() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		if(controller.addLast(title, singer)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			firstMenu();
		}
	}
	
	public void secondMenu() {
		System.out.println();
	}

}

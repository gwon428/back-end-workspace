package H_Polymorphism.practice;

/*	문제 추가! 도서를 3권까지 대여할 수 있도록 */
import java.util.Scanner;

import H_Polymorphism.practice.model.Book;
//import H_Polymorphism.practice.controller.LibraryController;
import H_Polymorphism.practice.model.Member;

public class Application_ {

	Scanner sc = new Scanner(System.in);
//	LibraryController lc = new LibraryController();
	Member m = new Member();
	
	// 한 사람에 대한 정보 => Member 객체 생성
//	String name = "";
//	int age = 0;
//	int coupon = 0;
//	String[] bookList = new String[3];
	
	int num = -1;
	
	// 책에 대한 정보 <= 시작부터 가지고 있는 정보이기 때문에 메인메뉴 시작 전에 선언
	// main 메서드에 넣으면 다른 메서드에서 사용할 수 없음! -> 전역변수로 빼서 생성
	Book[] books = {
			new Book("맛있는 지중해식 레시피", true),
			new Book("카페 샌드위치 마스터 클래스", false),
			new Book("원피스 107", 19),
			new Book("주술회전 24", 15)
	};
	
	// main에 바로 실행하면 전역변수를 static으로 설정해야 -> static 메모리 과부하 [static은 객체 생성을 해야 쓸 수 있기 때문에..?]
	public static void main(String[] args) {
		Application_ app = new Application_();
		app.mainMenu();
	}

	public void mainMenu() {

		System.out.print("이름 : ");
		m.setName(sc.nextLine()); 

		System.out.print("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine()));

		boolean check = true;

		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");

			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

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
		System.out.println(m);
	}

	public void rentBook() {
		
		for(int i=0; i < books.length; i++) {
			System.out.println(i + "번 도서 : " + books[i]);
		}

		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());
		
		// 사용자가 선택한 책 => 대여할 도서 정보를 받아온 것!!
		Book selectBook = books[num];

		// 새로운 리스트 초기화 (getter를 이용해서 기존 책 리스트를 가지고 오기 위해서 새로운 리스트에 담아둠)
		// String 배열.. => Book 배열
		Book[] newBookList = m.getBookList();
		
		for (int i = 0; i < newBookList.length; i++) {
			
			// setter를 통해 값을 입력하기 전에 새로운 리스트에 임시적으로 조건을 걸어 추가한 뒤
			if (newBookList[i] == null) {
				// 대여 가능 공간!
				
				// 쿠폰 관련
				if(selectBook.isCoupon()) {
					m.setcoupon(m.getcoupon() + 1); // coupon 보유가 true인 경우 쿠폰 수에 +1	
					newBookList[i] = books[num];
				}
				
				// 접근 제한 관련
				if(m.getAge() >= selectBook.getAccessAge()) {
					// member의 나이가 선택한 책의 접근 제한 나이보다 크거나 같을 때 대여 O
					newBookList[i] = books[num];
				}
				
				break;
			}
		}
		
		// 새로운 리스트에 담긴 정보들을 Member의 bookList에 저장함
		m.setBookList(newBookList);
		
		// 멤버의 나이가 선택한 책의 접근 제한 나이보다 작을 때
		if (m.getAge() < selectBook.getAccessAge()) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}

}

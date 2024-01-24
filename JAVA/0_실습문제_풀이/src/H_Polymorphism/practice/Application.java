package H_Polymorphism.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

	/*
	 	문제 추가!
	 	도서를 3권까지 대여할 수 있도록
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		
		// for문은 횟수나 범위가 정해져있을 때, while은 조건이 만족할 때까지 반복하도록 실행시키고자 할 때 사용
		
		// 대여할 도서 번호 (반복문 안에서 선언하면 계속 num이 0으로 초기화되기 때문에 반복문 밖으로 빼줘야 함)
		// 지금은 4권의 책만 있지만, 나중에 도서들이 더 추가될 경우 될 일이 없는 -1로 초기화하는 것이 좋음
		int num = -1;
		
		// cookBook을 대여했을 때 쿠폰이 될 수 있도록 
		int coupon = 0;
		
		String[] bookList = new String[3];
		
		
		// 무한루프문을 중단하기 위한 조건 
		boolean check = true;
		
		// '3. 프로그램 종료하기' 조건이 선택될 때까지 무한 루프에 넣기
		while(check) {
			// 프로그램을 종료하기 전까지 계속 반복해서 실행되는 부분
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			
			System.out.print("메뉴 번호 : ");
			// 선택한 메뉴 번호
			int menu = Integer.parseInt(sc.nextLine());
			

		
			// 도서 배열 설정
//			bookList = new String[4];
//			
//			bookList[0] = "0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
//			bookList[1] = "1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
//			bookList[2] = "2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]";
//			bookList[3] = "3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]";
			
			/* == 를 통한 조건 => switch. 범위를 통한 조건 등 => if문 */
			switch (menu) {
			case 1: // 마이페이지 메뉴(menu = 1)를 입력할 때마다 입력한 정보 출력
				// 도서 배열 인덱스를 통한 출력
//				System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=0, book=" + bookList[num]);
				
				// 도서 배열 없이 대여할 도서 번호에 따라 정보가 출력되도록 하는 조건문
//				if(num == 0) {
//					System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book);
//				} else if(num == 1) {
//					System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book);
//				} else if(num == 2 && age >= 19) {
//					System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book);
//				} else if(num == 3 && age >= 15) {
//					System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book);
//				} else {
//					System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=0, book=null]");
//				}
				
				// 기본 값도 null이고, 모든 조건의 실행문이 같기 때문에 조건문이 필요없어짐! => 하나로 통일 가능
				System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + Arrays.toString(bookList) + "]");
				break;
				
			case 2:
				// 도서 대여하기 메뉴(menu == 2)를 입력할 때마다 도서 4권의 정보 출력
				System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]");
				System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]");
				System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]");
				System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]");
				
//				for(int i=0; i<bookList.length;i++) {
//					System.out.println(i + "번 도서 : " + bookList[i]);
//				}
				
				System.out.print("대여할 도서 번호 선택 : ");
				num = Integer.parseInt(sc.nextLine());
				
				/*	
				  	Member 정보 수정
				 	- 대여하려는 책의 CookBook [coupon = true] 이면 cookCoupon 수를 하나 추가 (0번 도서를 대여할 때)     
				 	
				 	도서 대여 조건
				 	1. 도서가 0번부터 3번 사이에 있어야 성공적으로 대여
				 	2. accessAge가 Member의 age보다 큰 경우 '나이 제한으로 대여 불가능입니다.' 출력하고 대여되지 않도록
				 		-> 2번 메뉴 종료 후 1번 마이페이지 조회했을 때에도 Book 정보에 업데이트되지 않아야 함
				 */
				
				for(int i=0; i<bookList.length; i++) {
					if(bookList[i] == null) {
						// 대여 가능 공간을 만남! index가 null인 경우
						if (num == 0) {
							coupon ++;
							bookList[i] = "0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
						} else if (num == 1) {
							bookList[i] = "1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
						} else if (num == 2 && age >= 19){
							bookList[i] = "2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]";
						} else if (num == 3 && age >= 15) {
							bookList[i] = "3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]";
						} 
						break;
					}
					
				}
				// 0번 도서를 대여할 때마다 쿠폰을 1씩 추가!
//				if (num == 0) {
//					coupon ++;
//					bookList[0] = "0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
//				} else if (num == 1) {
//					bookList[0] = "1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
//				} else if (num == 2 && age >= 19){
//					bookList[0] = "2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]";
//				} else if (num == 3 && age >= 15) {
//					bookList[0] = "3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]";
//				}
				
				// 나이 제한 조건
				if(num == 2 && age < 19 || num == 3 && age < 15) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				} else {
					System.out.println("성공적으로 대여되었습니다.");
				}
				
//				System.out.println("Member [name=" + name + ", age=" + age + ", cookCoupon=0, book=" + book[num]);
				break;
				
			case 3:
				check = false;
				break;
			}
			
			
		}
		
		
	
	}

}

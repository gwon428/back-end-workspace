package com.kh;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.model.Book;
import com.kh.model.Member;
import com.kh.model.RentBook;

public class Application {

	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();

	public static void main(String[] args) {

		Application app = new Application();
		try {
			app.mainMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void mainMenu() throws SQLException {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");

			System.out.print("메뉴 번호 입력 : ");

			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	/* 반복문을 이용해서 책 리스트 출력 */
	public void printBookAll() throws SQLException {
//		bc.printBookAll();
		for(Book b : bc.printBookAll()) {
			System.out.println(b);
		}
	}

	// 2. 책 등록
	/*
	  	책 제목, 책 저자를 사용자한테 입력 받아
	 	등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
	 	실패하면 "책을 등록하는 데 실패했습니다." 출력
	 */
	public void registerBook() throws SQLException {
		System.out.print("책 제목 : ");
		String title = sc.nextLine();
		System.out.print("책 저자 : ");
		String author = sc.nextLine();
		
		boolean check = bc.registerBook(title, author);
		if (check) {
			System.out.println("성공적으로 책을 등록했습니다.");
		} else {
			System.out.println("책을 등록하는 데 실패했습니다.");
		}
	}

	// 3. 책 삭제
	/*	printBookAll(전체 책 조회)를 한 후,
	 	삭제할 책 번호를 선택을 사용자한테 입력 받아
	 	삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
	 	실패하면 "책을 삭제하는 데 실패했습니다." 출력
	 */
	public void sellBook() throws SQLException {
		printBookAll();
		System.out.print("삭제할 책 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		boolean check = bc.sellBook(num);
		if (check) {
			System.out.println("성공적으로 책을 삭제했습니다.");
		} else {
			System.out.println("책을 삭제하는 데 실패했습니다.");
		}
	}

	// 4. 회원가입
	/*	아이디, 비밀번호, 이름을 사용자한테 입력 받아
	 	회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
	 	실패하면 "회원가입에 실패했습니다." 출력
	 */
	public void registerMember() throws SQLException {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
	
		boolean check = bc.registerMember(new Member(id, pwd, name));
		if(check){
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
	}

	// 5. 로그인
	/*	아이디, 비밀번호를 사용자한테 입력 받아
	 	로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
	 	실패하면 "로그인에 실패했습니다." 출력
	 */
	public void login() throws SQLException {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		String name = bc.login(id, pwd);
		if(name != null) {
			System.out.println(name + "님, 환영합니다!");
			memberMenu();
		} else {
			System.out.println("로그인에 실패했습니다.");
		}
		
	}
	
	// 멤버 메뉴
	
	public void memberMenu() throws SQLException {
		boolean check = true;
		while(check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원 탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
				
			}
		}
	}
	// 1. 책 대여
	/*	printBookAll(전체 책 조회) 출력 후
	 	대여할 책 번호 선택을 사용자한테 입력 받아
	 	대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
	 	실패하면 "책을 대여하는 데 실패했습니다." 출력
	 */
	public void rentBook() throws SQLException {
		printBookAll();
		System.out.print("대여할 책 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		boolean check = bc.rentBook(num);
		if(check) {
			System.out.println("성공적으로 책을 대여했습니다.");
		} else {
			System.out.println("책을 대여하는 데 실패했습니다.");
		}
	}
	
	// 2. 내가 대여한 책 조회
	/*	내가 대여한 책들을 반복문을 이용하여 조회
	 	단, 반납 기한도 같이 조회 
	 	반납 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	 */
	public void printRentBook() throws SQLException {
		for(RentBook b : bc.printRentBook()) {
			System.out.println(b);
		}
	}
	
	// 3. 대여 취소
	/*	printRentBook(내가 대여한 책 조회) 출력 후
	 	취소할 대여 번호 선택을 사용자한테 입력 받아
	 	취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
	 	실패하면 "대여를 취소하는 데 실패했습니다." 출력
	 */
	public void deleteRent() throws SQLException {
		for(RentBook b : bc.printRentBook()) {
			System.out.println(b);
		}
		System.out.print("대여 취소할 책 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		boolean check = bc.deleteRent(num);
		if(check) {
			System.out.println("성공적으로 대여를 취소했습니다.");
		} else {
			System.out.println("대여를 취소하는 데 실패했습니다.");
		}
	}
	
	// 5. 회원 탈퇴
	/*	회원탈퇴에 성공하면 "회원 탈퇴 하였습니다ㅠㅠ" 출력
	 	실패하면 "회원탈퇴하는 데 실패했습니다." 출력
	 */
	public void deleteMember() throws SQLException {
		boolean check = bc.deleteMember();
		if(check) {
			System.out.println("회원 탈퇴 하였습니다ㅠㅠ");
		} else {
			System.out.println("회원탈퇴하는 데 실패했습니다.");
		}
	}
}

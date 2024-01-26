package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;

public class Application {

	Scanner sc = new Scanner(System.in);
	SongController controll = new SongController();
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();
		
		
	}
	
	private void mainMenu() {
		boolean check = true;
		
		while (check) {
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

				switch (menu) {
				case 1:
					firstMenu();
					break;
				case 2:
					secondMenu();
					break;
				case 3:
					printAllMenu();
					break;
				case 4:
					searchSongMenu();
					break;
				case 5:
					delMenu();
					break;
				case 6:
					modifyMenu();
					break;
				case 7:
					sortMenu();
					break;
				case 8:
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	// 1.  마지막 위치에 곡 추가
	public void firstMenu() {
		System.out.println("******마지막 위치에 곡 추가******");

		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		if (controll.insertLast(title, singer)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			firstMenu();
		}
	}
	
	// 2. 첫 위치에 곡 추가
	public void secondMenu() {
		System.out.println("******첫 위치에 곡 추가******");
		
		System.out.print("곡 명 : ");
		String title = sc.nextLine();

		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		if (controll.insertFirst(title, singer)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			firstMenu();
		}
	}
	
	// 3. 전체 곡 목록 출력
	public void printAllMenu() {
		System.out.println("******전체 곡 목록 출력******");
		for(Song s : controll.print()) {
			System.out.println(s);
		}
	}
	
	// 4. 특정 곡 검색
	public void searchSongMenu() {
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String keyword = sc.nextLine();
		System.out.println(controll.search(keyword) + "을 검색 했습니다.");
	}
	
	// 5. 특정 곡 삭제
	public void delMenu() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("삭제할 곡 명 : ");
		String del = sc.nextLine();
		Song delsong = controll.delete(del);
		
		if(delsong == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(delsong + "을 삭제 했습니다.");
		}
	}
	
	// 6. 특정 곡 수정
	public void modifyMenu() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String keyword = sc.nextLine();
		//Song search = controll.search(keyword);
		
		System.out.print("수정할 곡 명 : ");
		String modTitle = sc.nextLine();
		
		
		System.out.print("수정할 가수 명 : ");
		String modSinger = sc.nextLine();
		
		Song modsong = controll.modify(keyword, modTitle, modSinger);
		
		if(modsong == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			//search.setTitle(modTitle);
			//search.setSinger(modSinger);
			System.out.println(modsong.getSinger() + "-" + modsong.getTitle() + "의 값이 변경 되었습니다.");
		}
	}

	// 7. 곡명 오름차순 정렬
	public void sortMenu() {
		System.out.println("******곡 명 오름차순 정렬******");
		for(Song s : controll.sort()) {
			System.out.println(s);
		}
	}
}

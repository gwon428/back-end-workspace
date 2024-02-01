package K_Collection.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import K_Collection.practice2.controller.SongController;
import K_Collection.practice2.model.Song;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
//	ArrayList<Song> list = new ArrayList<>();
	// 싱글톤을 통한 객체 생성
	private SongController control = SongController.getInstance();
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();
	}
	
	private void mainMenu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("===== 메인 메뉴 =====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내림차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
					case 1:
						addLastList();
						break;
					case 2:
						addFirstList();
						break;
					case 3:
						printAll();
						break;
					case 4:
						searchSong();
						break;
					case 5:
						removeSong();
						break;
					case 6:
						updateSong();
						break;
					case 7:
						ascTitle();
						break;
					case 8:
						descArtist();
						break;
					case 9:
						System.out.println("종료");
						check = false;
						break;
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다 : " + e.getMessage());
			mainMenu();
		}
	}

	// 1. 마지막 위치에 곡 추가
	public void addLastList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		Song song = new Song(title, artist);
		boolean result = control.addLastList(song);
		if (result) {
			System.out.println("추가 성공");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			addLastList();
		}
		
	}
	
	// 2. 첫 위치에 곡 추가
	public void addFirstList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String artist = sc.nextLine();
		
		Song song = new Song(title, artist);
		boolean result = control.addFirstList(song);
		if (result) {
			System.out.println("추가 성공");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			addFirstList();
		}
	}
	
	// 3. 전체 곡 목록 출력
	public void printAll() {
		System.out.println("******전체 곡 목록 출력******");
		for(Song song : control.printAll()) {
			System.out.println(song);
		}
	}

	// 4. 특정 곡 검색
	public void searchSong() {
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		Song song = control.searchSong(title);
		if(song == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(song + " 을 검색했습니다.");
		}
	}
	
	// 5. 특정 곡 삭제
	public void removeSong() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		Song song = control.removeSong(title);
		
		if (song == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(song + "을 삭제했습니다.");
		}
		
	}
	
	// 6. 특정 곡 수정
	public void updateSong() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String title = sc.nextLine();
		
		System.out.print("수정할 가수 명 : ");
		String artist = sc.nextLine();
		
		Song update = new Song(title, artist);
		Song song = control.updateSong(search, update);
//		Song song = control.updateSong(search, title, artist);
		if (song == null)
			System.out.println("수정할 곡이 없습니다.");
		else
			System.out.println(song + "의 값이 변경됐습니다.");
		
	}
	
	// 7. 곡 명 오름차순 정렬
	// 클래스를 따로 만들어야 함
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		// 기존 배열을 건드리지 않기 위해 깊은 복사를 통해 새로운 배열을 만들어서 씀
		ArrayList<Song> clone = control.ascTitle();
		for (Song song : clone) {
			System.out.println(song);
		}
	}
	
	// 8. 가수 명 내림차순 정렬
	// 클래스를 따로 만들어야 함
	public void descArtist() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		// 기존 배열을 건드리지 않기 위해 깊은 복사를 통해 새로운 배열을 만들어서 씀
		ArrayList<Song> clone = control.descArtist();
		for (Song song : clone) {
			System.out.println(song);
		}
	}
}

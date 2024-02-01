package K_Collection.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import K_Collection.practice2.compare.ArtistDescending;
import K_Collection.practice2.compare.TitleAscending;
import K_Collection.practice2.model.Song;

public class SongController {
	
	// Application에 있던 list 선언을 controller로 옮겨오고, controller에서만 쓰일 것이기 때문에 private
	// DB라고 생각할 것
	private ArrayList<Song> list = new ArrayList<>();
	
	/*	싱글톤 패턴(Singleton Pattern)
	 	- 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	 	
	 * 싱글톤 패턴 규칙
	 
	 	1. 생성자가 private (캡슐화보다 더 정보 은닉이 뛰어난 패턴)	
			private SongController() {}
	 	2. 유일한 객체를 담을 static 변수	
	 		private static SongController instance;
	 	3. 객체를 반환하는 정적 메서드 추가
	 		public static SongController getInstance() {
				return instance;
			}
	 */
	private SongController() {}
	
	private static SongController instance;
	
	public static SongController getInstance() {
		// instance가 null일 경우 객체 생성.	
		if(instance == null) instance = new SongController();
		return instance;
	}
	
	
	// 1. 마지막 위치에 곡 추가
	public boolean addLastList(Song song) {
		if(!song.getTitle().equals("") && !song.getTitle().equals("")) {
			return list.add(song);
		}
		return false;
	}
	
	// 2. 첫 위치에 곡 추가
	public boolean addFirstList(Song song) {
//		list.add(0, new Song(title, singer));	// return 타입이 void.
		if(!song.getTitle().equals("") && !song.getTitle().equals("")) {
			list.add(0, song);
			return true;
		} else {
			return false;
		}
	}

	// 3. 전체 곡 목록 출력
	public ArrayList<Song> printAll() {
		return list;
	}

	// 4. 특정 곡 검색
	public Song searchSong(String title) {
		for(Song song : list) {
			if (song.getTitle().contains(title)) {
				return song;
			}
		}
		return null;
	}

	// 5. 특정 곡 삭제
	public Song removeSong(String title) {
		for(Song song : list) {
			if (song.getTitle().equals(title)) {
				int index = list.indexOf(song);
				return list.remove(index);		// list.remove 도 return 타입이 Song임
			}
		}
		return null;
	}

	// 6. 특정 곡 수정
	public Song updateSong(String search, Song update) {
		for(Song song : list) {
			if (song.getTitle().equals(search)) {
				return list.set(list.indexOf(song), update);
			} 
		}
		return null;
	}

	// 7. 곡 명 오름차순 정렬
	public ArrayList<Song> ascTitle() {
		ArrayList<Song> clone = (ArrayList<Song>) list.clone();
		Collections.sort(clone, new TitleAscending());
		return clone;
	}

	public ArrayList<Song> descArtist() {
		ArrayList<Song> clone = (ArrayList<Song>) list.clone();
		Collections.sort(clone, new ArtistDescending());
		return clone;
	}
}

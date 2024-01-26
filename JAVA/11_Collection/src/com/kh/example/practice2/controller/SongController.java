package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.model.Song;

public class SongController {
	
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	// 1번. 마지막 위치에 곡 추가
	public boolean insertLast(String title, String singer) {
		if ((!title.equals("")) && (!singer.equals(""))) {
			return songList.add(new Song(title, singer));
		} else {
			return false;
		}
	}
	
	// 2번. 첫 위치에 곡 추가
	public boolean insertFirst(String title, String singer) {
		if ((!title.equals("")) && (!singer.equals(""))) {
			songList.add(0, new Song(title, singer));
			return true;
		} else {
			return false;
		}
	}
	
	// 3번. 리스트 출력
	public ArrayList<Song> print() {
		return songList;
	}
	
	// 4번. 곡 검색
	public Song search(String keyword) {
		for (Song s : songList) {
			if (s.getTitle().contains(keyword)) {
				return s;
			} 
		} return null;
	}

	// 5번. 곡 삭제
	public Song delete(String keyword) {
		for (Song s : songList) {
			if (s.getTitle().equals(keyword)) {
				int index = songList.indexOf(s);
				return songList.remove(index);
			}
		} return null;
	}
	
	// 6. 곡 수정
	public Song modify(String keyword, String modTitle, String modSinger) {
		for (Song s : songList) {
			if (s.getTitle().equals(keyword)) {
				int index = songList.indexOf(s);
				return songList.set(index, new Song(modTitle, modSinger));
			} 
		} 
		return null;
	}
	
	public ArrayList<Song> sort() {
		Collections.sort(songList);
		return songList;
	}

}

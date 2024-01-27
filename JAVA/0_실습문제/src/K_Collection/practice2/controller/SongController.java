package K_Collection.practice2.controller;

import java.util.ArrayList;

import K_Collection.practice2.model.Song;

public class SongController {
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	public boolean addLast(String title, String singer){
		if(!title.equals("") && !singer.equals("")) {
			return songList.add(new Song(title, singer));
		} else {
			return false;
		}
	}
	
	public boolean addFirst(String title, String singer) {
		if(!title.equals("")&& !singer.equals("")) {
			songList.add(0, new Song(title, singer));
			return true;
		} else {
			return false;
		}
	}
	
	
	
}

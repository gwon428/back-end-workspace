package K_Collection.practice2.model;

public class Song {
	private String title;
	private String singer;
	
	public Song(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return title + " - "+ singer;
	}
	
	
	
}

package name.name2;

public class Game {
	private int id;
	private String name;
	private String box_art_url;
	
	public Game(int id, String name, String box_art_url) {
		this.id = id;
		this.name = name;
		this.box_art_url = box_art_url;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBox_art_url() {
		return box_art_url;
	}
}

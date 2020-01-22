public class Card {
	private String name;
	private int floorSticky, pintPrice, pubQuiz, atmosphere, music;

	public Card(String name, int floorSticky, int pintPrice, int pubQuiz, int atmosphere, int music) {
		this.name = name;
		this.floorSticky = floorSticky;
		this.pintPrice = pintPrice;
		this.pubQuiz = pubQuiz;
		this.atmosphere = atmosphere;
		this.music = music;

	}

	public String getName() {
		return name;
	}

	public int getFloorSticky() {
		return floorSticky;
	}

	public int getPintPrice() {
		return pintPrice;
	}

	public int getPubQuiz() {
		return pubQuiz;
	}

	public int getAtmosphere() {
		return atmosphere;
	}

	public int getMusic() {
		return music;
	}

}

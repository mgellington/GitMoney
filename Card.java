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
	public int getTopCatagory(){
		int maxCatagory = 0;
		int maxScore;
		for(int i = 0; i < 5; i++){
			maxScore = floorSticky;
			if(pintPrice > maxScore){
				maxCatagory = 1;
				maxScore = pintPrice;}
			if(pubQuiz > maxScore){
				maxCatagory = 2;
				maxScore = pubQuiz;}
			if(atmosphere > maxScore){
				maxCatagory = 3;
				maxScore = atmosphere;}
			if(music > maxCatagory){
				maxCatagory = 4;}
		}return maxCatagory;
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

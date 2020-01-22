
public class Player {
	private String name;
	private Card[] playerDeck;

	public Player(String n) {
		playerDeck = new Card[40];
		name = n;
	}

	//returns the top card from the player deck
	public Card getTopCard() {
		return playerDeck[0];
	}
	
	//method to push the contents of the Array to the top of the deck
	public void shiftDeck() {
		for (int i = 0; i<playerDeck.length-1; i++) {
			playerDeck[i] = playerDeck[i+1]; //setting the card at index i to be the card at the next index 
			if(playerDeck[i] == null) { //if i is null then we have probably gotten to the end of the deck
				playerDeck[i-1] = null; // in that case delete the last card - it has already been copied to the prevoius index 
			}
		}
	}

	//method to take an Array of Card objects and add them to the bottom of the player deck
	public void addCards(Card[] d) {
		int dIndex = 0;
		while (dIndex < d.length) {
			for (int i = 0; i < playerDeck.length-1; i++) {
				if (playerDeck[i] == null) {
					playerDeck[i] = d[dIndex];
					dIndex++;
				}
			}
		}

	}
}

import java.util.ArrayList;

public class Player {
	private int playerNumber;
	private Deck playerDeck;

	public Player(int n) {
		playerDeck = new Deck();
		playerNumber = n;
	}
	
	public void setDeck(Deck c) {
		playerDeck = c;	
	}

	public Deck getDeck() {
		return playerDeck;
	}

	// adds cards to the bottom of the deck (probably);
	public void addCards(Deck d) {
		playerDeck.addSetofCards(d);

	}
	
	
	//method to check if the player is the winner - they have all the cards 
	public Boolean isFull() {
		if (playerDeck.size() == 40) {
			return true;
		} else
			return false;
	}
	
	// method to check if the player has lost - if they have 0 cards 
	public Boolean isEmpty() {
		if (playerDeck.size() == 0) {
			return true;
		} else
			return false;
	}
}


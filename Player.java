import java.util.ArrayList;

public class Player {
	private String name;
	protected ArrayList<Card> playerDeck;

	public Player(String n) {
		playerDeck = new ArrayList<Card>();
		name = n;
	}
	
	public void setDeck(ArrayList<Card> c) {
		playerDeck = c;	
	}

	public ArrayList<Card> getDeck() {
		return playerDeck;
	}
	
	// returns the top card from the player deck
	public Card getTopCard() {
		Card topcard = playerDeck.get(0);
		playerDeck.remove(0);
		return topcard;
	}

	// adds cards to the bottom of the deck (probably);
	public void addCards(ArrayList<Card> c) {
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		tempDeck = playerDeck;
		tempDeck.addAll(c);
		this.setDeck(tempDeck);
	}
	
	//method to check if the player is the winner - they have all the cards 
	public Boolean isWinner() {
		if (playerDeck.size() == 40) {
			return true;
		} else
			return false;
	}
	
	// method to check if the player has lost - if they have 0 cards 
	public Boolean isLoser() {
		if (playerDeck.size() == 0) {
			return true;
		} else
			return false;
	}
}

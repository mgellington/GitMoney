import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> playerDeck;

	public Player(String n) {
		playerDeck = new ArrayList<Card>();
		name = n;
	}

	// returns the top card from the player deck
	public Card getTopCard() {
		Card topcard = playerDeck.get(0);
		playerDeck.remove(0);
		return topcard;
	}

	// adds cards to the bottom of the deck (probably);
	public void addCards(ArrayList<Card> c) {
		playerDeck.addAll(c);
	}

	
	public Boolean isWinner() {
		if (playerDeck.get(39) != null) {
			return true;
		} else
			return false;
	}

	public Boolean isLoser() {
		if (playerDeck.get(0) == null) {
			return true;
		} else
			return false;
	}
}
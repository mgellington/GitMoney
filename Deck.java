import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<card> mainDeck;

	public Deck() {
		mainDeck = new ArrayList<card>();
	}

	public void shuffleDeck() {
		/*
		 * shuffles list
		 */
		Collections.shuffle(mainDeck);
	}

	public void addCard(card x) {
		/*
		 * adds card tio end of list
		 */
		mainDeck.add(x);
	}

	public card getCard() {
		/*
		 * this will return the top card but also remove it from the list
		 * can be used when dealing the cards into each players hands
		 * 
		 * can use similar method for playing and moving into common pile
		 */
		card firstCard = mainDeck.get(0);
		mainDeck.remove(0);
		return firstCard;
	}
	public card seeCard(int x) {
		/*
		 * just returns the card at a given index
		 * card will remain in list
		 */
		
		card one = mainDeck.get(x);
		return one;
	}

	
}
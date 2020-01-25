import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> mainDeck;

	public Deck() {
		mainDeck = new ArrayList<Card>();
	}

	public void shuffleDeck() {
		/*
		 * shuffles list
		 */
		Collections.shuffle(mainDeck);
	}

	public void addCard(Card x) {
		/*
		 * adds card tio end of list
		 */
		mainDeck.add(x);
	}

	public Card getTopCard() {
		/*
		 * this will return the top card but also remove it from the list
		 * can be used when dealing the cards into each players hands
		 * 
		 * can use similar method for playing and moving into common pile
		 */
		Card firstCard = mainDeck.get(0);
		mainDeck.remove(0);
		return firstCard;
	}
	public void addSetOfCards(Deck cards){
		/*
		 *adds a lost of cards to the current deck
		 *such as adding the communal deck to a players hand
		 */	
		this.mainDeck.addAll(cards.getMainDeck());	
	}


	public ArrayList<Card> getMainDeck() {
		return mainDeck;
	}

	public Card seeCard(int x) {
		/*
		 * just returns the card at a given index
		 * card will remain in list
		 */
		
		Card one = mainDeck.get(x);
		return one;
	}

	public boolean isLoser(){
		/*
		 * checks is deck is empty
		 * can be used to see if there is a loser
		 * as a player lose if there hand is empty
		 */
		if(mainDeck.size() == 0){
			return true;
		}
		else return false;
	}
	public boolean isWinner(){
		/*
		 * check to see if there is 40 cards in the list
		 * as someone wins when they accumulate all 40 cards
		 */
		if(mainDeck.size() == 40){
			return true;
		}
		else return false;
	}

	
}
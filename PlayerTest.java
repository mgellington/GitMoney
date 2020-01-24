import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {
	ArrayList<Card> deck;
	Player testPlayer;
	Player testPlayer2;

	public PlayerTest() {
		deck = new ArrayList<Card>();
		testPlayer = new Player("Player1");
		Card C1 = new Card("Monster");
		Card C2 = new Card("Wizard");
		Card C3 = new Card("Zombie");
		deck.add(C1);
		deck.add(C2);
		deck.add(C3);
		testPlayer.setDeck(deck);

	}

	@Test
	public void testSetDeck() {
		assertSame(deck, testPlayer.getDeck(), "set Deck mush be the same as deck");
	}

	@Test
	public void testGetTopCard() {
		assertSame(deck.get(0), testPlayer.getTopCard(), "The top card should be");
	}

	@Test
	public void testAddCards() {

		ArrayList<Card> deck2 = new ArrayList<Card>();
		Card c4 = new Card("Henry");
		deck2.add(c4);
		testPlayer.addCards(deck2);

		ArrayList<Card> newDeck = new ArrayList<Card>();
		newDeck.addAll(deck);
		newDeck.addAll(deck2);

		assertSame(newDeck, testPlayer.getDeck(), "deck3 should be the same as player deck + deck 2");

	}

	@Test
	void testIsWinner() {
		// creating a new deck and filling it with 40 card objects
		ArrayList<Card> winDeck = new ArrayList<Card>();
		for (int i = 0; i < 40; i++) {
			winDeck.add(new Card("Card"));
		}

		// making a new Person object and assigning them the full deck
		Player testPlayer1 = new Player("Person");
		testPlayer1.setDeck(winDeck);
		assertSame(true, testPlayer1.isWinner(), "isWinner should return true");

		// a new person object - assigning a non-full deck to them
		ArrayList<Card> deck2 = new ArrayList<Card>();
		deck2.add(new Card("Card"));
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);

		assertSame(false, testPlayer2.isWinner(), "isWinner should return false");
	}

	@Test
	void testIsLoser() {

		ArrayList<Card> deck2 = new ArrayList<Card>();
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);

		assertSame(true, testPlayer2.isLoser(), "deck is empty so needs to return true");
		assertSame(false, testPlayer.isLoser(), "deck is not empty so needs to return false");
	}

}
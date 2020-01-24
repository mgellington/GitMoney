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
		
		ArrayList<Card> newDeck = new ArrayList<Card>();
		newDeck.add(new Card ("card"));
		newDeck.add(new Card ("another card"));

		ArrayList<Card> deck2 = new ArrayList<Card>();
		deck2.addAll(deck);
		deck2.addAll(newDeck);

		testPlayer.addCards(newDeck);
		assertSame(deck2, testPlayer.getDeck(), "Player deck should be same as deck2");
	}

	@Test
	void testIsWinner() {
		// a winner condition
		ArrayList<Card> winDeck = new ArrayList<Card>();
		for (int i = 0; i < 40; i++) {
			winDeck.add(new Card("Card"));
		}
		Player testPlayer1 = new Player("Person");
		testPlayer1.setDeck(winDeck);
		assertSame(true, testPlayer1.isWinner(), "isWinner should return true");

		// a non-winner condition
		ArrayList<Card> deck2 = new ArrayList<Card>();
		deck2.add(new Card("Card"));
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);

		assertSame(false, testPlayer2.isWinner(), "isWinner should return false");
	}

	@Test
	void testIsLoser() {
		
		// a loser condition
		ArrayList<Card> deck2 = new ArrayList<Card>();
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);
		assertSame(true, testPlayer2.isLoser(), "deck is empty so needs to return true");
		
		// a non-loser condition
		assertSame(false, testPlayer.isLoser(), "deck is not empty so needs to return false");
	}

}
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {
	

	@Test
	public void testSetDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		Card C1 = new Card("Monster");
		Card C2 = new Card("Wizard");
		Card C3 = new Card("Zombie");
		deck.add(C1);
		deck.add(C2);
		deck.add(C3);
		Player testPlayer = new Player("Person");
		testPlayer.setDeck(deck);
		assertSame(deck, testPlayer.getDeck(), "set Deck mush be the same as deck");
	}

	@Test
	public void testGetTopCard() {
		ArrayList<Card> deck = new ArrayList<Card>();
		Card C1 = new Card("Monster");
		Card C2 = new Card("Wizard");
		Card C3 = new Card("Zombie");
		deck.add(C1);
		deck.add(C2);
		deck.add(C3);
		Player testPlayer = new Player("Person");
		testPlayer.setDeck(deck);
		assertSame(deck.get(0), testPlayer.getTopCard(), "The top card should be");
	}

	@Test
	public void testAddCards() {
		ArrayList<Card> deck = new ArrayList<Card>();
		Card C1 = new Card("Monster");
		Card C2 = new Card("Wizard");
		Card C3 = new Card("Zombie");
		deck.add(C1);
		deck.add(C2);
		deck.add(C3);
		Player testPlayer = new Player("Person");
		testPlayer.setDeck(deck);

		ArrayList<Card> deck2 = new ArrayList<Card>();
		Card c4 = new Card("Henry");
		deck2.add(c4);
		testPlayer.addCards(deck2);

		ArrayList<Card> deck3 = new ArrayList<Card>();
		deck3.add(C1);
		deck3.add(C2);
		deck3.add(C3);
		deck3.add(c4);
		
	

		assertSame(deck3, testPlayer.getDeck(), "deck3 should be the same as player deck + deck 2");

	}

	@Test
	void testIsWinner() {
		ArrayList<Card> deck = new ArrayList<Card>();
		Card C1 = new Card("Monster");
		for (int i = 0; i < 40; i++) {
			deck.add(C1);
		}
		Player testPlayer = new Player("Person");
		testPlayer.setDeck(deck);
		assertSame(true, testPlayer.isWinner(), "isWinner should return true");

		ArrayList<Card> deck2 = new ArrayList<Card>();
		deck2.add(C1);
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);

		//
		assertSame(false, testPlayer2.isWinner(), "isWinner should return false");
	}

	@Test
	void testIsLoser() {
		ArrayList<Card> deck = new ArrayList<Card>();
		Card C1 = new Card("Monster");
		Card C2 = new Card("Wizard");
		Card C3 = new Card("Zombie");
		deck.add(C1);
		deck.add(C2);
		deck.add(C3);
		Player testPlayer = new Player("Person");
		testPlayer.setDeck(deck);

		ArrayList<Card> deck2 = new ArrayList<Card>();
		Player testPlayer2 = new Player("George");
		testPlayer2.setDeck(deck2);

		assertSame(true, testPlayer2.isLoser(), "deck is empty so needs to return true");
		assertSame(false, testPlayer.isLoser(), "deck is not empty so needs to return false");

		;
	}

}

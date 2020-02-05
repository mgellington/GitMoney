package commandline;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameModel {

	private Deck communalDeck;
	private Deck mainDeck;
	private ArrayList<Player> player;
	private int activePlayer;
	private int numOfRounds;
	private int numOfDraws;
	private int numAIPlayers;
	private CategoryTypes chosenCategory = null;
	private Player gameWinner;
	private Card roundWinningCard;


	// constructor for game instance
	public GameModel(int numAIPlayers, Deck inputDeck) {
		this.mainDeck = inputDeck;
		this.communalDeck = new Deck();
		this.mainDeck.shuffleDeck();
		int numOfRounds = 1;
		int numOfDraws = 0;
		player = new ArrayList<Player>();
		// sets you as player and adds to array list
		player.add(new Player());
		player.get(0).setName("You");
		// adds AI players to array list
		for (int i = 1; i < numAIPlayers; i++) {
			player.add(new Player());
			player.get(i).setName("AI Player " + i);
		}
		// deals cards to all players
		for (int j = 0; j < mainDeck.getMainDeck().size(); j++) {
			for (int k = 0; k < player.size(); k++) {
				player.get(k).addOneCard(mainDeck.getAndRemoveTopCard());
			}
		}
		activePlayer = randomFirstPlayer(numAIPlayers);
	}


	// randomises first player
	public int randomFirstPlayer(int numAIPlayers) {
		return new Random().nextInt(numAIPlayers);
	}

	// print human player their card - print method in Card class?


	// returns active players top category if AI player
	public CategoryTypes AIPlayerTopCategory(int activePlayer) {
		CategoryTypes topCategory = player.get(activePlayer).getDeck().getTopCard().getTopCategory().getType();
		return topCategory;
	}


	//increase round counter ??

	// getting all players top cards and moving them to main deck
	public void collectTopCards() {
		for (int i = 0; i < player.size(); i++) {
			mainDeck.addCard(player.get(i).getDeck().getAndRemoveTopCard());
		}
	}


	// finding round winner and returning their ID number; returns -1 if draw; returns -2 if method failed (testing)
	public int getRoundWinner(CategoryTypes chosenCategory) {

		int resultInt = -2; // initialised number that we don't want returned to make testing easier; change before turning in

		ArrayList<Card> topCards = mainDeck.getMainDeck();

		Card winningCard = topCards.get(0);
		int maxScore = 0;

		for (int i = 0; i < topCards.size() - 1; i++) {
			if (winningCard.matchCategory(chosenCategory).compareTo(topCards.get(i + 1).matchCategory(chosenCategory)) == 1) {
				if (topCards.get(i).matchCategory(chosenCategory).getScore() > maxScore) {
					maxScore = topCards.get(i).matchCategory(chosenCategory).getScore();
					winningCard = topCards.get(i);
					resultInt = i;
				}
			} else if (winningCard.matchCategory(chosenCategory).compareTo(topCards.get(i + 1).matchCategory(chosenCategory)) == 2) {
				if (topCards.get(i + 1).matchCategory(chosenCategory).getScore() > maxScore) {
					maxScore = topCards.get(i + 1).matchCategory(chosenCategory).getScore();
					winningCard = topCards.get(i + 1);
					resultInt = i + 1;
				}
			} else {
				resultInt = -1; // draw
			}
		}
		this.roundWinningCard=winningCard;
		return resultInt;
	}


	// moves cards from main deck to communal deck
	// if not draw, gives cards to winner and empties communal deck
	public void transferCards(int resultInt) {
		transferToCommunal(mainDeck);
		if (resultInt == -2) {
			System.out.println("we fucked up"); // take out later
		} else if (resultInt > -1) {
			activePlayer = resultInt; // sets activePlayer to index number of winner
			player.get(resultInt).addCards(communalDeck);
			emptyCommunal();
		}
	}


	// moves cards from main deck to communal deck and shuffles
	public void transferToCommunal(Deck cards) {
		//System.out.println("Trying to add "+cards.sizeOfDeck()+" cards");
		//System.out.println("To communaldeck of size: "+communalDeck.sizeOfDeck());
		//for (int k = 0; k < cards.sizeOfDeck(); k++) {
		//	System.out.println(cards.seeCard(k).toString());
		//}
		communalDeck.addSetOfCards(cards);
		//System.out.println("Trying to shuffle now");
		communalDeck.shuffleDeck();
	}


	// empties communal deck
	public void emptyCommunal() {
		this.communalDeck.getMainDeck().clear();
	}


	// check if player has no cards left, returns String of all players eliminated
	// removes eliminated players from player arraylist
	public String eliminateLoser() {
		String eliminated = "";
		for(int i = 0; i<player.size(); i++) {
			if(player.get(i).isEmpty()) {
				eliminated += player.get(i) + " has been ELIMINATED\n";
				player.remove(i);
				i--;
			}
		}return eliminated;
	}


	// checks if a player has won (full hand of 40 cards)
	// returns String announcing winner
	public String isGameOver() {
		String winner = "";
		for(int i=0; i<player.size(); i++) {
			if (player.get(i).isFull()) {
				// saving winner info (for stats) in gameWinner variable
				gameWinner = player.get(i);
				winner = player.get(i) + " has won the game!";
			}
		}return winner;
	}


	public int getNumOfRounds() {
		return numOfRounds;
	}

	// to be called at beginning of each round in TopTrumpsCLIApplication
	public void incrementNumOfRounds() {
		this.numOfRounds++;
	}

	public int getNumOfDraws() {
		return numOfDraws;
	}

	public Player getGameWinner() {
		return gameWinner;
	}

	public int getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(int activePlayer) {
		this.activePlayer=activePlayer;
	}

	public ArrayList<Player> getPlayer() {
		return player;
	}

	public Deck getMainDeck() {
		return mainDeck;
	}

	public int numberOfPlayers(){
		return player.size();
	}

	public Card getRoundWinningCard() {
		return roundWinningCard;
	}
}
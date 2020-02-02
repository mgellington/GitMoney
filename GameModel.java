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
	
	
	// constructor for game instance
	public GameModel(int numAIPlayers, Deck inputDeck) {
		this.mainDeck = inputDeck;
		this.mainDeck.shuffleDeck();
		int numOfRounds = 1;
		int numOfDraws = 0;
		
		player = new ArrayList<Player>();
		// sets you as player and adds to arraylist
		player.add(new Player());
		player.get(0).setName("You");
		
		// adds AI players to array list
		for (int i = 1; i < numAIPlayers; i++) {
			player.add(new Player());
			player.get(i).setName("AI Player" + i);
		}
			
		// deals cards to all players
		for (int j = 0; j < mainDeck.getMainDeck().size(); j++) {
			for (int k = 0; k < player.size(); k++) {
				player.get(j).addOneCard(mainDeck.getAndRemoveTopCard());
			}
		}
		activePlayer = randomFirstPlayer();
	}
	
		// randomises first player
	private int randomFirstPlayer() {
		return new Random().nextInt(numAIPlayers + 1);
	}
	
	//print human player their card - print method in Card class?
	
	
	private CategoryTypes AIPlayerTopCategory(int activePlayer) {
		CategoryTypes topCategory = player.get(activePlayer).getDeck().getTopCard().getTopCategory().getType();
		return topCategory;
	}
	
	
	
	
	
	
	private void newRound(){
		numOfRounds++;
		System.out.println("Round " + numOfRounds);
		System.out.println("Active player: " + activePlayer.getName());
		// insert printing the human player their top card
		roundResult();	
	}
	
	private int roundResult() {
		if(activePlayer == player.get(0)) {
			chosenCategory = chooseCategory();
			System.out.println("You have selected " + chosenCategory.getName());
		}
		else {
			chosenCategory = activePlayer.getDeck().getTopCard().getTopCategory().getType();
			System.out.println(activePlayer.getName() + " has selected " + chosenCategory.getName());
		}
		
		System.out.println(" on the " + activePlayer.getDeck().getTopCard().getName() + " card.");
		
		numOfRounds++;
		
		// logic for comparing the cards by category
		
		// array of all players current top cards
		Card[] current = new Card[player.size()];
		for (int i = 0; i < current.length; i ++) {
			current[i] = player.get(i).getDeck().getTopCard();
		}
		
		Card winningCard = current[0];
		boolean isDraw = false;
		
		int maxScore = 0;
		
		// comparing cards to chosen category
		for (int j = 0; j < current.length - 1; j++) {
			if (winningCard.matchCategory(chosenCategory).compareTo(current[j+1].matchCategory(chosenCategory)) == 1) {
				if (current[j].matchCategory(chosenCategory).getScore() > maxScore) {
					maxScore = current[j].matchCategory(chosenCategory).getScore();
					winningCard = current[j];
					isDraw = false;
				}
			} else if (winningCard.matchCategory(chosenCategory).compareTo(current[j+1].matchCategory(chosenCategory)) == 2) {
				if (current[j+1].matchCategory(chosenCategory).getScore() > maxScore) {
					maxScore = current[j + 1].matchCategory(chosenCategory).getScore();
					winningCard = current[j + 1];
					isDraw = false;
				}
			} else {
				isDraw = true;
			}
		}
		
		Player roundWinner = null;
		
		// changin array of top cards to array list
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (int x = 0; x < current.length; x++) {
			cardList.add(current[x]);
		}
		
		// adding array list to temporary deck, to add it to communal deck
		Deck tempDeck = new Deck(cardList);
		transferToCommunal(tempDeck);
		
		if (isDraw) {
			System.out.println("A Draw!");
			this.numOfDraws++;
			gameWinnerCheck();
			newRound();
		} else {
			// determine winner
			for (int i = 0; i < player.size(); i++) {
				if (winningCard == player.get(i).getDeck().getTopCard()) {
					roundWinner = player.get(i);
					System.out.println(player.get(i) + " has won the round!");
				}
			}
			
			roundWinner.addCards(communalDeck);
			emptyCommunal();
			gameWinnerCheck();
			newRound();

		}
		
		return 0;
		
	}
	
	public void gameWinnerCheck(){
		for(int i=0; i<player.size(); i++) {
			if (player.get(i).isFull()) {
				// saving winner info (for stats) in gameWinner variable
				gameWinner = player.get(i);
				System.out.println(player.get(i) + " has won the game!");
			}else if(player.get(i).isEmpty()) {
				System.out.println(player.get(i) + " has been ELIMINATED!");
				player.remove(i);
				
			}
			
		}
	}	
	
	
	
	
	public void transferToCommunal(Deck cards) {
		// adds card deck to communal deck and shuffles
		this.communalDeck.addSetOfCards(cards);
		this.communalDeck.shuffleDeck();
		
	}
	
	public void emptyCommunal() {
		this.communalDeck.getMainDeck().clear();
	}

	public int getNumOfRounds() {
		return numOfRounds;
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


}

package commandline;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameModel {
	
	private Deck communalDeck;
	private Deck mainDeck;
	private Player[] player;
	private Player activePlayer;
	private int numOfRounds;
	private int numOfDraws;
	private int numAIPlayers;
	
	
	// constructor for game instance
	private GameModel() {
		this.mainDeck = new Deck();
	}
	
	// this will only deal the main deck at the start of the game
	private void deal() {
		// iterates through array list of players
		// deal 1 card to each 
		this.mainDeck.shuffleDeck();
		
		
		for(int i=mainDeck.getMainDeck().size(); i >= 0; i++) {
			for (int j = 0; j < player.length; j++) {
				player[j].addOneCard(mainDeck.getAndRemoveTopCard());
			}
		}
		// incomplete method
	}
	
	//print human player their card - print method in Card class?
	
	public CategoryTypes chooseCategory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which catagory would you like to play? \nPlease choose from the following catagories and enter a number from 1 to 5."
				+ "\n1 - Floor Stickiness\n2 - Pint Price\n3 - Pub Quiz Quality\n4 - Atmosphere\n5 - Music Quality");
		int userChoice = scanner.nextInt();
		CategoryTypes chosenCategory = null;
		
		
		if(userChoice == 1) {
			chosenCategory = CategoryTypes.FLOOR;
		}else if(userChoice == 2) {
			chosenCategory = CategoryTypes.PINT;
		}else if(userChoice == 3) {
			chosenCategory = CategoryTypes.QUIZ;
		}else if(userChoice == 4) {
			chosenCategory = CategoryTypes.VIBES;
		}else if(userChoice == 5) {
			chosenCategory = CategoryTypes.TUNES;
		}else {
			System.out.println("Input not recognised. Please try again.");
			chooseCategory();
		}	
		// returns string of chosen category name
		return chosenCategory;
	}
	
	public void startGame(int AIPlayers) {
		this.numAIPlayers = AIPlayers;
		player = new Player[AIPlayers +1];
		this.numOfRounds = 1;
		
		for (int i = 0; i < player.length; i++) {
			if (i == 0) {
				player[i].setName("You");
			} else {
				player[i].setName("AI Player " + i);
			}
		}
	}
	
	// randomises first player
	private int randomFirstPlayer() {
		return new Random().nextInt(numAIPlayers + 1);
	}
	
	private int roundResult(CategoryTypes chosenCategory) {
		if(activePlayer == player[0]) {
			System.out.println("You have selected " + chosenCategory.getName());
		}
		else {
			chosenCategory = activePlayer.getDeck().getTopCard().getTopCategory().getType();
			System.out.println(activePlayer.getName() + " has selected " + chosenCategory.getName());
		}
		
		System.out.println(" on the " + activePlayer.getDeck().getTopCard().getName() + " card.");
		
		numOfRounds++;
		
		// logic for comparing the cards by category
		
		Card[] current = new Card[player.length];
		for (int i = 0; i < current.length; i ++) {
			current[i] = player[i].getDeck().getTopCard();
		}
		
		Card winningCard = current[0];
		boolean isDraw = false;
		
		// add variable for max score for determining draw
		
		for (int j = 0; j < current.length - 1; j++) {
			if (winningCard.matchCategory(chosenCategory).compareTo(current[j+1].matchCategory(chosenCategory)) == 1) {
				winningCard = current[j];
				isDraw = false;
			} else if (winningCard.matchCategory(chosenCategory).compareTo(current[j+1].matchCategory(chosenCategory)) == 2){
				winningCard = current[j + 1];
				isDraw = false;
			} else {
				isDraw = true;
			}
		}
		
		Player roundWinner = null;
		
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (int x = 0; x < current.length; x++) {
			cardList.add(current[x]);
		}
		
		Deck tempDeck = new Deck(cardList);
		transferToCommunal(tempDeck);
		
		if (isDraw) {
			handleDraw();
		} else {
			// determine winner
			for (int i = 0; i < player.length; i++) {
				if (winningCard == player[i].getDeck().getTopCard()) {
					roundWinner = player[i];
				}
			}
			
			roundWinner.addCards(communalDeck);
			emptyCommunal();

		}
		
		return 0;
		
	}
	
	public void handleDraw() {
		this.numOfDraws++;
		// handle draw
		// restart round
		// record stats?
	}
	
	public void handleWin() {
		//restart round
		//set stats?
	}
	
	public void transferToCommunal(Deck cards) {
		// adds card deck to communal deck and shuffles
		this.communalDeck.addSetOfCards(cards);
		this.communalDeck.shuffleDeck();
		
	}
	
	public void emptyCommunal() {
		this.communalDeck.getMainDeck().clear();
	}
	


}

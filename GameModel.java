package commandline;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class GameModel {
	
	private Deck communalDeck;
	private Deck mainDeck;
	private ArrayList<Player> player;
	private Player activePlayer;
	private int numOfRounds;
	private int numOfDraws;
	private int numAIPlayers;
	private CategoryTypes chosenCategory = null;
	private Player gameWinner;
	
	
	// constructor for game instance
	private GameModel() {
		this.mainDeck = new Deck();
		startGame(numAIPlayers);
	}
	
	// this will only deal the main deck at the start of the game
	private void startDeal() {
		// iterates through array list of players
		// deal 1 card to each 
		this.mainDeck.shuffleDeck();
		
		for (int i = 0; i < mainDeck.getMainDeck().size(); i++) {
			for (int j = 0; j < player.size(); j++) {
				player.get(j).addOneCard(mainDeck.getAndRemoveTopCard());
			}
		}
		// incomplete method
		// Card toString in TopTrumpsCLIApplication
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
		player = new ArrayList<Player>();
		this.numOfRounds = 1;

		// sets you as player and adds to arraylist
		player.add(new Player());
		player.get(0).setName("You");
		
		// adds AI players to array list
		for (int i = 1; i < numAIPlayers; i++) {
			player.add(new Player());
			player.get(i).setName("AI Player" + i);
		}
		startDeal();
		activePlayer = player.get(randomFirstPlayer());
	}
	
	// randomises first player
	private int randomFirstPlayer() {
		return new Random().nextInt(numAIPlayers + 1);
	}
	
	private void newRound(){
		numOfRounds++;
		System.out.println("Round " + numOfRounds);
		System.out.println("Active player: " + activePlayer);
		// insert printing the human player their top card
		
		// if the active player is the human player..
		if(activePlayer.equals(player.get(0))){
			chooseCategory();
		}
		// calling roundResult method
		roundResult(chosenCategory);	
	}
	
	private int roundResult(CategoryTypes chosenCategory) {
		if(activePlayer == player.get(0)) {
			System.out.println("You have selected " + chosenCategory.getName());
		}
		else {
			chosenCategory = activePlayer.getDeck().getTopCard().getTopCategory().getType();
			System.out.println(activePlayer.getName() + " has selected " + chosenCategory.getName());
		}
		
		System.out.println(" on the " + activePlayer.getDeck().getTopCard().getName() + " card.");
		
		numOfRounds++;
		
		// logic for comparing the cards by category
		
		Card[] current = new Card[player.size()];
		for (int i = 0; i < current.length; i ++) {
			current[i] = player.get(i).getDeck().getTopCard();
		}
		
		Card winningCard = current[0];
		boolean isDraw = false;
		
		int maxScore = 0;
		
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
		
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (int x = 0; x < current.length; x++) {
			cardList.add(current[x]);
		}
		
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
	
//	public void handleDraw() {
//		this.numOfDraws++;
//		// handle draw
//		// restart round
//		// record stats?
//	}
//	
//	public void handleWin() {
//		//restart round
//		//set stats?
//	}
	
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


}

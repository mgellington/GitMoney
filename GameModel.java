package commandline;
import java.util.Scanner;
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
		this.mainDeck = mainDeck;
	}
	
	// this will only deal the main deck at the start of the game
	private void deal() {
		// iterates through array list of players
		// deal 1 card to each 
		mainDeck.shuffleDeck();
		
		for(int i=0; i < mainDeck.getSize(); i++) {
			player[i].getDeck().addCard(mainDeck.d)
		}
	}
	
	//print human player their card - print method in Card class?
	
	public String chooseCategory() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Which catagory would you like to play? \nPlease choose from the following catagories and enter a number from 1 to 5."
				+ "\n1 - Floor Stickiness\n2 - Pint Price\n3 - Pub Quiz Quality\n4 - Atmosphere\n5 - Music Quality");
		
		int userChoice = scanner.nextInt();
		String chosenCategory = null;
		if(userChoice == 1) {
			chosenCategory = "Floor Stickiness";
		}else if(userChoice == 2) {
			chosenCategory = "Pint Price";
		}else if(userChoice == 3) {
			chosenCategory = "Pub Quiz Quality";
		}else if(userChoice == 4) {
			chosenCategory = "Atmosphere";
		}else if(userChoice == 5) {
			chosenCategory = "Music Quality";
		}else {
			System.out.println("Input not recognised. Please try again.");
			chooseCategory();
		}
			
		// returns string of chosen category name
		// scanner input 
		return chosenCategory;
	}
	
	public void startGame(int AIPlayers) {
		this.numAIPlayers = AIPlayers;
		player = new Player[AIPlayers +1];
		
		for (int i = 0; i < player.length; i++) {
			if (i == 0) {
				player[i].setName("You");
			} else {
				player[i].setName("AI Player " + i);
			}
		}
	}
	
	private int randomPlayer() {
		return new Random().nextInt(numAIPlayers +1);
	}
	
	private int roundResult(int chosenCategory) {
		if(activePlayer == player[0]) {
			System.out.println("You have selected " + chosenCategory);
		}
		else {
			System.out.println(activePlayer.getName() + " has selected " + activePlayer.getTopCard().getTopCatagory());
		}
		System.out.println(" on the " + activePlayer.getTopCard() + " card.");
		
		numOfRounds++;
		
		// logic for comparing the cards by category
		
	}

}

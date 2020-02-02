package commandline;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

		/* Initialising variables & objects needed for dialogue */
		Scanner s = new Scanner(System.in);
		int userInput;
		GameModel game;
		boolean gameOver;
		CategoryTypes chosenCategory = null;
		Deck deckOfAllCards;
		ArrayList<Player> allTestPlayers;
		Deck testDeck;

/**
		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
 */
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			/* Dialogue #1: ask user if he wants to see game statistics or play the game or quit */
			userInput = promptUserInput("Please enter (1) for starting a new game," +
					" (2) for viewing previous game statistics, or (3) for quitting the program.", new int[] {1, 2, 3});
			if (userInput==2){

				//add code here for viewing game statistics

			} else if(userInput==3){
				System.exit(0);
			}

			/* Dialogue #2: ask user how many AI players to include in the game */
			userInput = promptUserInput("Please type number of AI players you wish to play against."+
					" Minimum 1 and maximum 4 AI players permitted.", new int[] {1, 2, 3, 4});

			/* Initialising game below */

			/* ######## Add code here to extract all cards from database and store them in a deck object */

			//deckOfAllCards = extractDeckFromDataBase(filepath)
			// the above method is expected to be included in one of the database classes

			deckOfAllCards = new Deck();

			deckOfAllCards.addCard(new Card("QMU", 75, 15, 34, 56, 76));
			deckOfAllCards.addCard(new Card("OldSchoolHouse", 44, 43, 87, 27, 87));
			deckOfAllCards.addCard(new Card("Dram", 67, 44, 23, 89, 24));
			deckOfAllCards.addCard(new Card("GUU", 55, 33, 22, 11, 25));

			System.out.println("ok up to creating deckOfAllCards");

            game = new GameModel(userInput,deckOfAllCards);

			System.out.println("ok up to constructing GameModel");

			allTestPlayers = game.getPlayer();

			System.out.println("Contents of the GameModel:");
			for (int k = 0; k < allTestPlayers.size(); k++) {
				System.out.println("Player name:"+allTestPlayers.get(k).getName());
				testDeck = allTestPlayers.get(k).getDeck();
				System.out.println("Pub name:"+testDeck.seeCard(0).getName()+" "+testDeck.getTopCard().toString());
			}


            //game = new GameModel(userInput (# of players),deckOfAllCards object);

			/* ######## Add code here to initialise a GameModel object by calling the constructor
			* - Constructor needs to: - initialise player objects (AI player number defined by user, 1-4)
			*                         - initialise mainDeck (aka activeDeck) and communalDeck objects and clone deck
			*                         - shuffle Deck
			*                         - deal out cards from mainDeck to players
			*                         - set all game stats to zero (TIP: could also collect all game stats in a
			*                           separate object of class GameStats)
			*                         - randomly select first active player (TIP: use integer indicating player number)
			*                           (have a separate method to randomly provide a number)
			*/

			/* For the above constructor method need the following supporting methods within the class:

			public void startDeal()
			which the takes cards one by one from this.mainDeck (aka activeDeck?) and deals them to each player's deck

			public int getActivePlayer()
			which is getter method that returns who is the active player - i.e. returns an int representing player number
			 */

			/* Dialogue Loop:
			 *  On each round:
			 *  -- if the user is active player, show their top card and then ask them to choose category
			 *  -- if an AI player is active, play the rounds automatically,
			 *     so that the AI chooses category and then cards are compared  */
            gameOver = false;
            while (!gameOver) {

				//while(user is not activePlayer i.e. (game.getActivePLayer()!=1){

					//need method public Category chooseAICategory(# ID of active player i.e. game.getActivePLayer())
					//where active AI player chooses their category based on highest value on their top card

					//need method public void collectTopCards()
					//which collects and puts everyone's top card in mainDeck (aka activeDeck) here

					//need method public int getRoundWinner(Category object chosen by active AI player)
					//which determines the winner of the round and returns the integer # number of the winning player
					//it also needs to allow for draw (using say number -1)

					//need method public void giveCardsToRoundWinner()
					//which moves cards in mainDeck (aka activeDeck) & communalDeck to winner (or moves them to communalDeck if draw)

					//need method public String eliminateLosers()
					//which iterates through remaining players and removes them from the ListArray if they have no cards left
					//method should also return a String message which says which players have been eliminated

					//###### IMPORTANT: consider here what to do if there is a draw in the final game and no cards

					//need method public String isGameOver()
					//which returns a message to the user if there is only one player left (winner)

					//need method public int nextActivePlayer()
					//which selects next active player - use this method also in constructor for consistency & simplicity
					//increase round count here

				//}

				// needs method public String displayUserTopCard()
				// which returns user's top card - write a method in both Card and GameModel classes for completeness

				userInput = promptUserInput("Which catagory would you like to play? \nPlease choose" +
						" from the following catagories and enter a number from 1 to 5."
						+ "\n1 - Floor Stickiness\n2 - Pint Price\n3 - Pub Quiz Quality\n4 - Atmosphere\n5 - Music"+
						" Quality", new int[] {1, 2, 3, 4, 5});

				//include a line here for displaying the user's choice of category to the user

				//reuse method public void collectTopCards()

				//reuse method public int getRoundWinner(Category object chosen by active AI player)

				//reuse method public void giveCardsToRoundWinner()

				//reuse method public String eliminateLosers()

				//###### IMPORTANT: consider here what to do if there is a draw in the final game and no cards

				//reuse method public String isGameOver()

				//reuse method public int nextActivePlayer()

			}





		}

	}

	// Method for prompting user for input until user types valid input
	private static int promptUserInput(String userMessage, int[] userOptions){
		Scanner s = new Scanner(System.in);
		int userInput;
		while (true) {
			System.out.println(userMessage);
			userInput = s.nextInt();
			s.nextLine();
			if (!(userInput == 0)) {
				if (contains(userOptions, userInput)) {
					return userInput;
				}
			}
			System.out.println("Invalid user input. Please enter one of the options provided.");
		}
	}

	// Method for checking if an array contains a value
	public static boolean contains(int[] array, int value) {
		for(int item:array){
			if (item==value) {
				return true;
			}
		}
		return false;
	}

}

// additional notes:
// game is expected to have a 'test log' that stores a log of every action that happens in the game
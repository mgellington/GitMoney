package commandline;

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

					//need method public String isGameOver()


					//which
					//test if gameOver here
					//select next active player here

					//consider here what to do if there is a draw in the final game and no cards

				//}


				// display user's top card here

				userInput = promptUserInput("Which catagory would you like to play? \nPlease choose" +
						" from the following catagories and enter a number from 1 to 5."
						+ "\n1 - Floor Stickiness\n2 - Pint Price\n3 - Pub Quiz Quality\n4 - Atmosphere\n5 - Music"+
						" Quality", new int[] {1, 2, 3, 4, 5});

				//include here a line diplaying the user's choice of category to the user
				//put everyone's top card in mainDeck (activeDeck) here
				//determine the winner of the round here
				//move cards in communal deck to winner here (or keep them there if draw)
				//test if gameOver here
				//select next active player here

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
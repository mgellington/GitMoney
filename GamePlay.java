import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GamePlay {
	private Deck mainDeck = new Deck();

	public GamePlay() {
	}

	public Deck getMainDeck() {
		return mainDeck;
	}

	public void inputTxt() throws FileNotFoundException {
		/*
		 * inputs attributes into card objects and into deck
		 * need to change file name accordingly
		 */
		Scanner scanner = new Scanner(new File("/Users/markmorrison/Desktop/StarCitizenDeck.txt"));
		while (scanner.hasNextLine()) {
			String name = scanner.next();
			int sticky = scanner.nextInt();
			int pintPrice = scanner.nextInt();
			int pubQuiz = scanner.nextInt();
			int atmosphere = scanner.nextInt();
			int music = scanner.nextInt();
			mainDeck.addCard(new Card(name, sticky, pintPrice, pubQuiz, atmosphere, music));
		}
	}

}
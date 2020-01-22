import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		Deck main = game.getMainDeck();
		try {
			game.inputTxt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String str = "";
		for(int i = 0; i < 40; i++) {
				Card one = main.seeCard(i);
				str += one.getName() + " ";
		}
		System.out.println(str);
		
		main.shuffleDeck();
		
		/*
		 * prints out the names of the cards just to test shuffling
		 */
		
		String st = "";
		for(int i = 0; i < 40; i++) {
				Card one = main.seeCard(i);
				st += one.getName() + " ";
		}
		System.out.println(st);
		
	}

}

/**
 * @author Name: Lauri Lehtola
 * Student ID: 1000115
 */

public class CommunalDeck extends Deck{

    // initialising array of Card objects with initial size of 40
    private Card cards[] = new Card[40];

    // Constructor
    public CommunalDeck(Card[] cards){
        this.cards = cards;
    }

    // inherits shuffleCards method from Deck
    public void shuffleCards(){
        super();
    }


    // method telling if the communal deck is empty
    public boolean isEmpty(){
        return (this.cards[0] == null);
    }

}

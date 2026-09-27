import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    ArrayList<Card> cards;
    Deck parentDeck;
    int numShown;


    /**
     * A constructor to make a hand
     * @param numCards - the number of cards to put in the hand, assume it is a valid number 1-10
     * @param deck - the deck from where the cards come. The hand will be always aware of this deck
     */
    public Player(int numCards, Deck deck){
        this.cards = new ArrayList<>();
        for (int i = 0; i < numCards; i ++){
            cards.add(deck.dealCard());
        }
        this.parentDeck = deck;
        this.numShown = 0;
    }

    /**
     * Tells the hand to print all the cards with their value displayed. Useful for debugging, but not used in the actual game
     */
    public void printHand(){
        for (int i = 0; i < 10; i++){
            System.out.print(cards.get(i).getValue() + " ");
        }
        System.out.println();
    }
    /**
     * Prints the hand the way the player would see. If a card is face down, 'X' is printed instead of the card value
     */
    public void showHand(){
        for (int i = 0; i < 5; i++){
            System.out.print(cards.get(i).face() + " ");
        }
        System.out.println();
        for (int i = 5; i < 10; i ++){
            System.out.print(cards.get(i).face() + " ");
        }
        System.out.println();
    }

    /**
     * Checks if all the cards are face up
     * @return true for yes, false for no
     */
    public boolean allShown(){
        return numShown == cards.size();
    }

    /**
     * Checks if this hand has one the game
     * @return true for yes, false for no
     */
    private boolean won(){
        return cards.size()==1 && this.allShown();
    }

    /**
     * Checks if the deck can recieve the specified card
     * @param c - the card trying to enter the deck
     * @return - false if the spot Card c is trying to take is already flipped/filled
     * or if card C's position is outside the range of the deck;
     * true otherwise
     */
    public boolean validCard(Card c){
        int pos = c.getPosition();
        if (c.getPosition()>=cards.size()){
            return false;
        }
        else if (pos == -1){//auto-invalid for kings and queens
            return false;
        }
        else if (pos==10){//jack
            return true;
        }
        //If the card trying to be replaced is already face up, or not a jack
        //Jacks can be re-placed
        if (cards.get(pos).isShown() && !cards.get(pos).getValue().equals("J")){
            return false;
        }
        return true;
    }

    //Assume that the hand can take Card c and that Card c is valid
    /**
     * A card enters the hand, and the hand updates accordingly
     * @pre Card c can be taken by the hand (validCard( c ) == true)
     * @param c - the card entering the deck
     * @return the card that got kicked out by Card c
     */
    public Card takeCard(Card c){
        Card r; //temp holder for the card to be returned
        int pos = c.getPosition();
        if (pos == 10){//card is a jack
            Scanner scan = new Scanner(System.in);
            while (0 <= pos && pos <= 9){
                System.out.print("Please enter at what position you would like this card: ");
                pos = scan.nextInt();
            } 
            scan.close();  
        }
        //TODO add logic for jacks
        r = cards.remove(pos);
        c.show();//need to flip the card over to prevent stack overflow
        cards.add(pos, c);
        this.showHand();
        System.out.println(r.getValue() + " was removed from your hand");
        if (this.validCard(r)){
            return this.takeCard(r);
        }
        return r;
    }
}

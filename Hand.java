import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;
    Deck parentDeck;
    int numShown;

    /**
     * A constructor to make a hand
     * @param numCards - the number of cards to put in the hand, assume it is a valid number 1-10
     * @param deck - the deck from where the cards come. The hand will be always aware of this deck
     */
    public Hand(int numCards, Deck deck){
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
     * @return - false if the spot Card c is trying to take is already flipped/filled, or if card C's position is outside the range of the deck, true otherwise
     */
    public boolean validCard(Card c){
        if (c.getPosition() == -1){//auto-invalid for kings and queens
            return false;
        }
        else if (c.getPosition()==10){//jack
            return true;
        }
        if (cards.get(c.getPosition()).isShown()){
            return false;
        }
        return true;
    }

    //Assume that the hand can take Card c and that Card c is valid
    /**
     * A card enters the hand, and the hand updates accordingly
     * **Preconditon** Card c can be taken by the hand
     * @param c - the card entering the deck
     * @return the card that got kicked out by Card c
     */
    public Card takeCard(Card c){
        Card r;
        if (c.getPosition()!=10){//valid card, not a jack
            r = 
        }
    }
}

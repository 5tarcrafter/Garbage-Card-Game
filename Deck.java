/**
 * A class that manages the storing, dealing, shuffling of a deck of cards
 */
import java.util.ArrayList;

public class Deck {
    //Arraylists were chosen because they preserve order, sorry hash
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> discard = new ArrayList<>();

    /**
     * Constructor for Deck
     * Creates a deck of 52 cards
     * Cards do not have suits as that is not important in Garbage
     * Shuffles the deck at the end of creation
     */
    public Deck(){
        for (int i = 0; i < 4; i++){//loop for times for the four suites
            deck.add(new Card("A", 0));
            for (int j = 2; j <= 10; j++){
                deck.add(new Card(Integer.toString(j), j-1));
            }
            deck.add(new Card("J", 10)); //because jack can go anywhere
            deck.add(new Card("Q", -1)); //queen goes nowhere
            deck.add(new Card("K", -1)); //king goes nowhere
        }
        //this.printCards();
        this.shuffle();
    }

    /**
     * Shuffles the deck
     * Noted : not the most efficient, and has a change of leaving the deck unchaged
     * TODO change?
     */
    public void shuffle(){
        int size = deck.size();
        for(int i = 0; i < size; i++){
            deck.add((int)(Math.random()*size), deck.remove(i));
        }
    }

    /**
     * Prints all the cards in the deck
     * Useful for debugging and not much else
     */
    public void printCards(){
        for (Card c : this.deck){
            System.out.print(c.getValue() + " ");
        }
        System.out.println();
    }

    /**
     * Adds a card to the discard pile
     * @param c - the card to be add to to the discard pile
     */
    public void returnCard(Card c){
        discard.add(c);
    }

    /**
     * Takes the top card (0 index) card in the deck, removes it, and returns
     * If after removing a card, 
     * @return card at index 0
     */
    public Card dealCard(){
        Card r = deck.removeFirst();
        if (deck.size() == 0){
            deck.addAll(discard);
            this.shuffle();
            discard.clear();
        }
        return r;
    }

    /**
     * Deals a card to a player
     * Card is removed from the deck to avoid duplicates
     * @param player - the player recieving the card
     */
    public void dealCard(Player player){
        this.discard.add(player.takeCard(this.dealCard()));
    }

    /**
     * Prints out the two cards the player may choose from
     * Will not be used for actual gameplay, as the player is not supposed to know what deck card is
     */
    public void cardOptions(){
        System.out.println("Deck: " + deck.getFirst().getValue());
        System.out.println("Discard: " + discard.getLast().getValue());
    }
}

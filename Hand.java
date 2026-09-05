import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand(int numCards, Deck deck){
        this.cards = new ArrayList<>();
        for (int i = 0; i < numCards; i ++){
            cards.add(deck.dealCard());
        }
    }

    public void printHand(){
        for (int i = 0; i < 10; i++){
            System.out.print(cards.get(i).getValue() + " ");
        }
        System.out.println();
    }

    public void showHand(){
        for (int i = 0; i < 5; i++){
            System.out.print(cards.get(i).face() + " ");
        }
        System.out.println();
        for (int i = 5; i < 10; i ++){
            System.out.print(cards.get(i).face() + " ");
        }
    }
}

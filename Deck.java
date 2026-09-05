import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        for (int i = 0; i < 4; i++){//loop for times for the four suites
            deck.add(new Card("A"));
            for (int j = 2; j <= 10; j++){
                deck.add(new Card(Integer.toString(j)));
            }
            deck.add(new Card("J"));
            deck.add(new Card("Q"));
            deck.add(new Card("K"));
        }
        this.printCards();
        this.shuffle();
    }

    public void shuffle(){
        int size = deck.size();
        for(int i = 0; i < size; i++){
            deck.add((int)(Math.random()*size), deck.remove(i));
        }
    }

    public void printCards(){
        for (Card c : this.deck){
            System.out.print(c.getValue() + " ");
        }
        System.out.println();
    }
}

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> discard = new ArrayList<>();

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

    public void returnCard(Card c){
        discard.add(c);
    }

    public Card dealCard(){
        Card r = deck.removeFirst();
        if (deck.size() == 0){
            deck.addAll(discard);
            this.shuffle();
            discard.clear();
        }
        return r;
    }

    public void dealCard(Hand player){
        this.discard.add(player.takeCard(this.dealCard()));
    }

    public void cardOptions(){
        System.out.println("Deck: " + deck.getFirst().getValue());
        System.out.println("Discard: " + discard.getLast().getValue());
    }
}

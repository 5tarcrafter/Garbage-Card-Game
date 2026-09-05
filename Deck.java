import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        for (int i = 0; i < 4; i++){//loop for times for the four suites
            deck.add(new Card('A'));
        }
    }
}

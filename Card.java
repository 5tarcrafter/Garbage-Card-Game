
/**
 * A class representing card
 * All comments are made assuming the reader understands how the card game Garbage works
 * @author 5tarcrafter
 */
public class Card {
    private String value; //the value of the Card, Ace-King
    /**
     * Below is for `position` variable
     * where the card may sit in the game of Garbage.
     * position is 0-9 for ace-10 due to 0-indexing
     * position is 10 for Jacks and -1 for Kings and Queens
     */
    private int position;
    //char suit; //suit not matter in garbage
    private boolean shown = false; //is the card face up?

    /**
     * A constructor for Card
     * @param val - the value of the card
     * @param position - the position the card can take
     */
    public Card(String val, int position){
        this.value = val;
        this.position = position;
    }

    /**
     * Getter for value of card
     * @return value
     */
    public String getValue(){return this.value;}

    /**
     * Getter for the shown boolean
     * @return shown
     */
    public boolean isShown(){return this.shown;}

    /**
     * Getter for card's position
     * @return position
     */
    public int getPosition(){return this.position;}

    /**
     * Returns how the card would appear to a player
     * If the card is face down, the value is hidden and `X` is returned
     * Otherwise the card is visable and has it's value known
     * @return `X` if shown == false, otherwise the value of the card
     */
    public String face(){
        if (this.shown){
            return this.value;
        }
        return "X";
    }

    /**
     * flips the card face-up
     */
    public void show(){this.shown = true;}

    /**
     * flips the card face-down
     */
    public void hide(){this.shown = false;}
}

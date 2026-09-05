public class Card {
    char value;
    //char suit; //suit not matter in garbage
    boolean shown = false;

    public Card(char a){
        this.value = a;
    }

    public char getValue(){return this.value;}

    public boolean isShown(){return this.shown;}

    public void flip(){this.shown = !this.shown;}

    public void show(){this.shown = true;}

    public void hide(){this.shown = false;}
}

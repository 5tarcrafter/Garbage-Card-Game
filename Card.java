public class Card {
    private String value;
    //char suit; //suit not matter in garbage
    private boolean shown = false;

    public Card(String a){
        this.value = a;
    }

    public String getValue(){return this.value;}

    public boolean isShown(){return this.shown;}

    public void flip(){this.shown = !this.shown;}

    public void show(){this.shown = true;}

    public void hide(){this.shown = false;}
}

//import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Hello, World!");
    System.out.print("Please enter number of players: ");
    int numPlayers = scan.nextInt();
    System.out.println("Number of players: " + numPlayers);
    Deck deck = new Deck();
    System.out.println("the deck is");
    deck.printCards();
    Hand[] players = new Hand[numPlayers];
    players[0] = new Hand(10, deck);
    System.out.println("the deck after making one hand");
    deck.printCards();
    System.out.println("and the hand is");
    players[0].printHand();
    System.out.println("but the player will see");
    players[0].showHand();

    boolean won = false;
    int input;
    while (!won){
        System.out.println("Card options:");
        deck.cardOptions();
        System.out.print("Press 1 for deck, and 2 for discard pile: ");
        input = scan.nextInt();
        while (input != 1 || input != 2){
            System.out.println("Invalid option. Please try again.");
            System.out.print("Press 1 for deck, and 2 for discard pile: ");
            input = scan.nextInt();
        }
        if (input == 1){
            deck.dealCard(players[0]);
        }
    }


    //start the shutdown actions here
    scan.close();
}
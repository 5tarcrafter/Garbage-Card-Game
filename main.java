import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Hello, World!");
    System.out.print("Please enter number of players: ");
    int numPlayers = scan.nextInt();
    scan.close();
    System.out.println("Number of players: " + numPlayers);
    Hand[] players = new Hand[numPlayers];
    players[0] = new Hand(10);
}
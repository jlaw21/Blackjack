import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Player p = new Player();
        Player d = new Player();
        Deck deck = new Deck();
        final int NUMCARDS = 2;

        //Place Bet
        System.out.println("How much would you like to bet? You can bet up to " + p.getScore());
        int bet = read.nextInt();

        //Deal
        deck.shuffle();
        for(int i = 0; i < NUMCARDS; i++){
            p.addCard(deck.dealCard());
            d.addCard(deck.dealCard());
        }

        System.out.println("You have: ");
        System.out.println(p);
        System.out.println("Dealer has: ");
        System.out.println("Facedown" + "\t\t" + d.playCard(1).toString());

        //Sum Hand -- add a method in player class

        //Hit or Stand (P)
        //Hit or Stand (D)
        //Compare P and D
        //Payout


    }
}

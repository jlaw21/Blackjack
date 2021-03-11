import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Player p = new Player();
        Player d = new Player();
        Deck deck = new Deck();
        final int NUMCARDS = 2;
        String hitOrStand = "h";
        int bet;

        do {
            //Place Bet
            System.out.println("How much would you like to bet? You can bet up to " + p.getScore() + ". Bet 0 to exit.");
            bet = read.nextInt();

            if (bet == 0) {
                break;
            } else {
                p.subtractScore(bet);
                read.nextLine();
                p.newHand();
            }

            //Deal
            deck.shuffle();
            for (int i = 0; i < NUMCARDS; i++) {
                p.addCard(deck.dealCard());
                d.addCard(deck.dealCard());
            }

            //Hit or Stand (P)
            do {
                System.out.println("You have: ");
                System.out.println(p);
                System.out.println("Dealer has: ");
                System.out.println("Facedown" + "\t\t" + d.playCard(1).toString());

                //Sum Hand -- add a method in player class
                System.out.println("\n*********************************");
                System.out.println("Hand is showing: " + p.sumHand());
                System.out.println("*********************************\n");

                if (p.sumHand() == 21) {
                    System.out.println("\n#################");
                    System.out.println("Natural 21.");
                    System.out.println("#################\n");
                    hitOrStand = "s";
                } else if (p.sumHand() > 21) {
                    System.out.println("\n#################");
                    System.out.println("You bust.");
                    System.out.println("#################\n");
                    hitOrStand = "s";
                } else {
                    System.out.println("Would you like to (H)it or (S)tand?");
                    hitOrStand = read.nextLine();
                }

                if (hitOrStand.equalsIgnoreCase("h")) {
                    p.addCard(deck.dealCard());
                }

            } while (hitOrStand.equalsIgnoreCase("h"));

            //Hit or Stand (D)
            while (d.sumHand() <= 16 && p.sumHand() <= 21) {
                d.addCard(deck.dealCard());
            }
            System.out.println("\nDealer has: " + d);
            System.out.println("\n*********************************");
            System.out.println("Dealer is showing: " + d.sumHand());
            System.out.println("*********************************\n");

            //Compare P and D//Payout
            if (p.sumHand() >= 21 || d.sumHand() > p.sumHand()) {
                System.out.println("You lose. You lost your bet. Your score is now: " + p.getScore());
            } else if (p.sumHand() > d.sumHand()) {
                p.addScore(bet * 2);
                System.out.println("You win. You earned " + bet * 2 + " points. Your score is now: " + p.getScore());
            } else {
                p.addScore(bet);
                System.out.println("Tied score. Your score is now: " + p.getScore());
            }
        }while(bet > 0);

        System.out.println("Thank you for playing.");
        System.out.println("Your final score is: " + p.getScore());
    }
}

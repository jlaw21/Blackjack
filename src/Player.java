import java.util.ArrayList;

public class Player {

    int score;


    ArrayList<Card> hand = new ArrayList<>();

    public Player(){
        score = 100;
    }

    public void addCard(Card card){

        hand.add(card);

    }

    public Card playCard(int cardPosition){

        return hand.get(cardPosition);

    }

    public void discardCard(int cardPosition){

        hand.remove(cardPosition);

    }

    public void newHand(){
        hand.clear();
    }

    public void addScore(int add){
        score += add;
    }

    public void subtractScore(int subtract){
        score -= subtract;
    }

    public void setScore(int value){
        score = value;
    }

    public int getScore(){
        return score;
    }

    public String toString(){

        String output = "";
        for(Card card: hand){
            if(card.getSuit()=="Diamonds"){
                output += (card.toString() + "\t");
            }else{
                output += (card.toString() + "\t\t");
            }

        }

        return output;
    }
    //BLACKJACK SPECIFIC
    public int sumHand(){




    }


}

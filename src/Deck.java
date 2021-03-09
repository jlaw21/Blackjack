public class Deck {

    final int NUMCARDS = 52;
    int deckPosition = 0;


    Card[] deck = new Card[NUMCARDS];


    public Deck(){
        int slot = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                deck[slot] = new Card(j, i);
                slot++;
            }
        }
    }

    public void shuffle(){

        for(int i = deck.length-1; i > 0; i--){  //this is better, my bad ... oof ...

            int rand = (int)(Math.random() * i); //no need for a +1 since indexes start at 0 so multiplying by 52 is a rando between 1 and 51

            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    //Notice that we are returning an object. We want our placeholder for the deck to be global, because if its local, it will get reassigned
    public Card dealCard(){

        if(deckPosition == NUMCARDS){
            shuffle();
            deckPosition = 0;
        }

        Card card = deck[deckPosition];
        deckPosition++;

        return card;

    }


    //Personal preference for the toString method to be last.

    public String toString(){
        String output = "";
        for(Card card: deck){
            output += (card.toString() + "\n") ;
        }
        return output;
    }

}

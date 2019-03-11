import java.util.ArrayList;

public class Hand {
    int numCards;
    ArrayList<Card> cardsInHand;
    public Hand(){
        cardsInHand = new ArrayList<>();
        numCards = 0;
    }

    public String toString(){
        String hand = "";
        for(int i = 0; i < cardsInHand.size(); i++){
            hand += cardsInHand.get(i).toString() + " ";
        }
        return hand;
    }
}

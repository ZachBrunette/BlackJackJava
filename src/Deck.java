import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> playDeck;
    public Deck(int numOfDecks){
        playDeck = new ArrayList<>();
        for(int deckNum = 0; deckNum < numOfDecks; deckNum++){
            for(CardSuit cs : CardSuit.values()){
                for(CardRank cr : CardRank.values()){
                    playDeck.add(new Card(cs, cr));
                }
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();
        ArrayList<Card> tempDeck = new ArrayList<>();
        int randomIndex;
        Card randCard;
        while(playDeck.size() > 0){
            randomIndex = rand.nextInt(playDeck.size());
            randCard = playDeck.remove(randomIndex);
            tempDeck.add(randCard);
        }
        playDeck = tempDeck;
    }

    public Card drawCard(){
        return playDeck.remove(0);
    }
}

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> playDeck;
    public Deck(int numOfDecks){
        playDeck = new ArrayList<>();
        for(int deckNum = 0; deckNum < numOfDecks; deckNum++){
            for(CardSuit cs : CardSuit.values()){
                for(CardRank cr : CardRank.values()){
                    playDeck.add(new Card(cs, cr));
                    System.out.println("Created card: " + playDeck.get(playDeck.size()-1).toString());
                    System.out.println("Number of cards in deck: " + playDeck.size());
                }
            }
        }
    }
}

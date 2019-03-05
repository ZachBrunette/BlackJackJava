public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(CardSuit suit, CardRank rank){
        this.cardSuit = suit;
        this.cardRank = rank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public String toString(){ return "" + cardRank.getRank() + cardSuit.getSuit();}
}

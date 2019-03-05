public enum CardSuit {
    SPADE("s"),
    HEART("h"),
    CLUB("c"),
    DIAMOND("d");

    private final String suit;

    CardSuit(String suit){
        this.suit = suit;
    }

    String getSuit(){
        return suit;
    }
}

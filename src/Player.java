public class Player {
    private Hand playerHand;
    int score;
    public Player(){
        playerHand = new Hand();
        score = 0;
    }

    public void addCard(Card card){
        playerHand.cardsInHand.add(card);
        score += card.getCardRank().getValue();
    }

    public String getPlayerHand() {
        return playerHand.toString();
    }

    public int getScore(){
        return score;
    }
}

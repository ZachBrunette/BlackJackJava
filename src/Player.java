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

    public Hand getPlayerHand() {
        return playerHand;
    }

    public boolean checkBlackjack(){
        if(score == 21) {
            System.out.println("You got Blackjack!");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean check21(){
        if(score >= 21){
            return true;
        }
        else{
            return false;
        }
    }
}

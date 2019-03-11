public class Dealer {
    private Hand dealerHand;
    int score;

    public Dealer(){
        dealerHand = new Hand();
        score = 0;
    }

    public void addCard(Card card){
        dealerHand.cardsInHand.add(card);
        score += card.getCardRank().getValue();
    }

    public Card getDealerFaceUpCard(){
        return dealerHand.cardsInHand.get(1);
    }

    public Hand getDealerHand(){
        return dealerHand;
    }

    public boolean checkBlackjack(){
        if(score == 21) {
            System.out.println("Dealer got Blackjack!");
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

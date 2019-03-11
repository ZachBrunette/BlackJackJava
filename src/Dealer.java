public class Dealer {
    private Hand dealerHand;
    int score;

    public Dealer(){
        dealerHand = new Hand();
        score = 0;
    }

    public void addCard(Card card){
        dealerHand.cardsInHand.add(card);
    }

    public String getDealerFaceUpCard(){
        return dealerHand.cardsInHand.get(1).toString();
    }

    public String getDealerHand(){
        return dealerHand.toString();
    }
}

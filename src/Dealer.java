public class Dealer {
    private Hand dealerHand;
    private int score;

    public Dealer(){
        dealerHand = new Hand();
        score = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        score = 0;
        boolean containsSoftAce = false; //soft ace is an ace that has a value of 11 instead of 1
        for(int i = 0; i < dealerHand.cardsInHand.size(); i++){
            score += dealerHand.cardsInHand.get(i).getCardRank().getValue();
            if(dealerHand.cardsInHand.get(i).getCardRank().getRank().equals("A")){
                if(!containsSoftAce){ //hands can only have one soft ace
                    containsSoftAce = true;
                    score += 10;
                }
            }
            if(containsSoftAce){
                if(score > 21){ //soft ace changes value from 11 to 1 if score is over 21
                    score -= 10;
                }
            }
        }
        return score;
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

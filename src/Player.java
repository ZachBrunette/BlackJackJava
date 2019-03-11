public class Player {
    private Hand playerHand;
    private int score;
    public Player(){
        playerHand = new Hand();
        score = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        score = 0;
        boolean containsSoftAce = false; //soft ace is an ace that has a value of 11 instead of 1
        for(int i = 0; i < playerHand.cardsInHand.size(); i++){
            score += playerHand.cardsInHand.get(i).getCardRank().getValue();
            if(playerHand.cardsInHand.get(i).getCardRank().getRank().equals("A")){
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
        playerHand.cardsInHand.add(card);
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

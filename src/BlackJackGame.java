import java.util.Scanner;

//TODO soft aces
//TODO player money
//TODO reshuffle deck

public class BlackJackGame {
    Scanner scanner;
    Player player;
    Deck newDeck;
    Dealer dealer;
    boolean nextRound;
    public BlackJackGame(){
        scanner = new Scanner(System.in);
        System.out.print("Choose the number of decks you want to play with: ");
        newDeck = new Deck(scanner.nextInt());
        player = new Player();
        dealer = new Dealer();
    }

    public void run(){
        newDeck.shuffle();
        nextRound = true;
        while(nextRound){
            playRound();
            System.out.print("Play next round? Y or N: ");
            switch(scanner.next().toLowerCase()){
                case "y":
                    nextRound = true;
                    break;
                case "x":
                    nextRound = false;
                    break;
            }
        }


    }

    public void playRound(){
        boolean playerTurnOver = false;
        boolean dealerTurnOver = false;
        player.getPlayerHand().cardsInHand.clear();
        dealer.getDealerHand().cardsInHand.clear();
        player.score = 0;
        dealer.score = 0;
        String playerChoice;
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        System.out.println("Dealer's face up card: " + dealer.getDealerFaceUpCard().toString());
        System.out.println("Your cards: " + player.getPlayerHand().toString());
        System.out.println("Your score: " + player.score);
        playerTurnOver = player.checkBlackjack();
        if(dealer.getDealerFaceUpCard().getCardRank().getValue() >= 10){
            dealerTurnOver = dealer.checkBlackjack();
        }
        while(!dealerTurnOver){
            while(!playerTurnOver){
                if(player.getPlayerHand().cardsInHand.size() == 2){
                    System.out.print("Choose to hit(h), stay(s), split(p), double(d): ");
                }
                else{
                    System.out.print("Choose to hit(h), stay(s): ");
                }
                playerChoice = scanner.next();
                playerTurnOver = evaluatePlayerChoice(playerChoice);
                System.out.println("Your cards: " + player.getPlayerHand().toString());
                System.out.println("Your score: " + player.score);
            }
            if(player.score > 21){
                dealerTurnOver = true;
            }
            else{
                dealerTurnOver = dealerAI();
            }
            System.out.println("Dealer turn over");
            System.out.println("Dealer's cards: " + dealer.getDealerHand().toString());
            System.out.println("Dealer score: " + dealer.score);
            System.out.println("Your score: " + player.score);
            System.out.println("" + checkWinner());
        }

    }

    public boolean evaluatePlayerChoice(String choice){
        switch(choice){
            case "h":
                player.addCard(newDeck.drawCard());
                return player.check21();
            case "s":
                return true;
            case "p":
                //TODO split logic
                return false;
            case "d":
                player.addCard(newDeck.drawCard());
                return true;
                //TODO money logic for double down
            default:
                System.out.println("Invalid choice, choose again");
                return false;
        }
    }

    public boolean dealerAI(){
        while(dealer.score < 21){
            switch(dealer.score){
                case 17:
                    if(player.score > 17){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 18:
                    if(player.score > 18){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 19:
                    if(player.score > 19){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 20:
                    if(player.score > 20){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                default: //dealer score is 16 or lower, dealer must draw
                    dealer.addCard(newDeck.drawCard());
            }
        }
        return true;
    }

    public String checkWinner(){
        if(player.score > 21){
            return "You lose!";
        }
        else if(player.score <= 21){
            if (dealer.score > 21) {
                return "You win!";
            }
            else {
                if(player.score > dealer.score){
                    return "You win!";
                }
                else if(dealer.score == player.score){
                    return "Push! Money returned";
                }
                else if(player.score < dealer.score){
                    return "You lose!";
                }
                else{
                    return "ERROR";
                }
            }
        }
        return "this should never be used";
    }

}

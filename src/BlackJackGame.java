import java.util.Scanner;

//TODO soft aces
//TODO player money

public class BlackJackGame {
    Scanner scanner;
    Player player;
    Deck newDeck;
    int numDecks;
    Dealer dealer;
    boolean nextRound;
    public BlackJackGame(){
        scanner = new Scanner(System.in);
        System.out.print("Choose the number of decks you want to play with: ");
        numDecks = scanner.nextInt();
        newDeck = new Deck(numDecks);
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
                default:
                    System.out.println("Error: incorrect key entered");
                    nextRound = false;
            }
        }


    }

    public void playRound(){
        boolean playerTurnOver = false;
        boolean dealerTurnOver = false;
        player.getPlayerHand().cardsInHand.clear();
        dealer.getDealerHand().cardsInHand.clear();
        player.setScore(0);
        dealer.setScore(0);
        if(newDeck.playDeck.size() <= 10){
            newDeck = new Deck(numDecks);
            newDeck.shuffle();
            System.out.println("Reshuffling Deck......");
        }
        String playerChoice;
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        System.out.println("Dealer's face up card: " + dealer.getDealerFaceUpCard().toString());
        System.out.println("Your cards: " + player.getPlayerHand().toString());
        System.out.println("Your score: " + player.getScore());
        playerTurnOver = player.checkBlackjack();
        dealer.setScore(dealer.getScore());
        dealerTurnOver = dealer.checkBlackjack();
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
                System.out.println("Your score: " + player.getScore());
            }
            if(player.getScore() > 21){
                dealerTurnOver = true;
            }
            else{
                dealerTurnOver = dealerAI();
            }
            System.out.println("Dealer turn over");

        }
        System.out.println("Dealer's cards: " + dealer.getDealerHand().toString());
        System.out.println("Dealer score: " + dealer.getScore());
        System.out.println("Your score: " + player.getScore());
        System.out.println("" + checkWinner());

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
        while(dealer.getScore() < 21){
            switch(dealer.getScore()){
                case 17:
                    if(player.getScore() > 17){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 18:
                    if(player.getScore() > 18){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 19:
                    if(player.getScore() > 19){ //player winning, dealer draws
                        dealer.addCard(newDeck.drawCard());
                    }
                    else{ //dealer has better or equal score, turn over
                        return true;
                    }
                    break;
                case 20:
                    if(player.getScore() > 20){ //player winning, dealer draws
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
        if(player.getScore() > 21){
            return "You lose!";
        }
        else if(player.getScore() <= 21){
            if (dealer.getScore() > 21) {
                return "You win!";
            }
            else {
                if(player.getScore() > dealer.getScore()){
                    return "You win!";
                }
                else if(dealer.getScore() == player.getScore()){
                    return "Push! Money returned";
                }
                else if(player.getScore() < dealer.getScore()){
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

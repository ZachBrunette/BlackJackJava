import java.util.Scanner;

public class BlackJackGame {
    Scanner scanner;
    Player player;
    Deck newDeck;
    Dealer dealer;
    public BlackJackGame(){
        scanner = new Scanner(System.in);
        System.out.print("Choose the number of decks you want to play with: ");
        newDeck = new Deck(scanner.nextInt());
        player = new Player();
        dealer = new Dealer();
    }

    public void run(){
        newDeck.shuffle();
        playRound();

    }

    public void playRound(){
        boolean playerTurnOver = false;
        boolean dealerTurnOver = false;
        String playerChoice;
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        System.out.println("Dealer's face up card: " + dealer.getDealerFaceUpCard().toString());
        System.out.println("Your cards: " + player.getPlayerHand().toString());
        System.out.println("Your score: " + player.getScore());
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
                switch(playerChoice){
                    case "h":
                        player.addCard(newDeck.drawCard());
                        playerTurnOver = player.check21();
                        break;
                    case "s":
                        playerTurnOver = true;
                        break;
                    case "p":
                        //TODO split logic
                        break;
                    case "d":
                        player.addCard(newDeck.drawCard());
                        playerTurnOver = true;
                        //TODO money logic for double down
                        break;
                    default:
                        // d
                }
                System.out.println("Your cards: " + player.getPlayerHand().cardsInHand.toString());
                System.out.println("Your score: " + player.getScore());

            }
        }

    }

}

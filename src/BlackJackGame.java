import java.util.Scanner;

public class BlackJackGame {
    Scanner scanner;
    Player player;
    Deck newDeck;
    Dealer dealer;
    public BlackJackGame(){
        // TODO game constructor
    }

    public void run(){
        scanner = new Scanner(System.in);
        System.out.println("Choose the number of decks you want to play with: ");
        newDeck = new Deck(scanner.nextInt());
        player = new Player();
        dealer = new Dealer();
        newDeck.shuffle();
        playRound();

    }

    public void playRound(){
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        player.addCard(newDeck.drawCard());
        dealer.addCard(newDeck.drawCard());
        System.out.println("Dealer's face up card: " + dealer.getDealerFaceUpCard());
        System.out.println("Your cards: " + player.getPlayerHand());
        System.out.println("Your score: " + player.getScore());
    }
}

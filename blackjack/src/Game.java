package blackjack;
public class Game {
    private Deck deck, discarded;   // Decks to hold the main deck and the discarded cards
    private Dealer dealer;  // The dealer object representing the dealer in the game
    private Player player;  // The player object representing the player in the game
    private int wins, losses, pushes;   // Variables to keep track of game outcomes

    public Game(){
        wins = 0; losses = 0; pushes = 0;   // Initialize the win, loss, and push counters to zero
        deck = new Deck(true);  // Create a new full deck of cards
        discarded = new Deck(); // Create an empty deck to hold discarded cards
        dealer = new Dealer();
        player = new Player();
        deck.mix(); // Shuffle the deck before starting the game
        startRound();   // Start a new round of the game
    }

    private void startRound(){
        // If the game has been played before, show the round results and discard hands
        if(wins > 0 || losses > 0 || pushes > 0){
            System.out.println();
            System.out.println("Starting a new round...");
            System.out.println("Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHand(discarded);    // Discard the dealer's hand
            player.getHand().discardHand(discarded);    // Discard the player's hand
        }

        if(deck.cardsLeft() < 4){
            // If the deck has less than four cards, reload the deck with discarded cards and shuffle
            deck.reloadDeck(discarded);
        }

        // Deal two cards to the dealer and two cards to the player
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();    //Show the dealer's first card and hide the second card
        player.printHand(); // Show the player's hand

        // Check for cases of Blackjack (player/dealer has a hand value of 21 with two cards)
        if(dealer.hasBlackjack()){
            dealer.printHand();

            if(player.hasBlackjack()){
                System.out.println("You both have Blackjack - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has Blackjack - loss.");
                losses++;
                startRound();
            }
        }
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack - win!");
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);   // Let the player make their decision to Hit or Stand

        // Check if the player has busted (hand value over 21) and update the round results
        if(player.getHand().handValue() > 21){
            System.out.println("You've busted, over 21.");
            losses++;
            startRound();
        }

        dealer.printHand(); // Show the dealer's full hand after the player's turn
        while(dealer.getHand().handValue() < 17){
            dealer.hit(deck, discarded);    // Dealer's turn: Hit until the hand value is at least 17
        }

        // Determine the round result based on the final hand values of the player and dealer
        if(dealer.getHand().handValue() > 21){
            System.out.println("Dealer busts.");
            wins++;
        }
        else if(dealer.getHand().handValue() > player.getHand().handValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().handValue() > dealer.getHand().handValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Push.");
        }
        startRound();   // Start a new round after the current round is completed
    }
}

package blackjack;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;   // ArrayList to hold the cards in the hand

    public Hand() {
        hand = new ArrayList<Card>();   // Initialize the hand as an empty ArrayList
    }

    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());  // Take a card from the deck and add it to the hand
    }

    public void discardHand(Deck discardDeck){
        discardDeck.addCards(hand); // Discard all cards from the hand and add them to the discard deck
        hand.clear();   // Clear the hand after discarding the cards
    }

    public String toString() {
        String output = "";
        for (Card card : hand) {
            output += card + " - "; // Print a string representation of the cards in the hand.
        }
        return output;
    }

    public int handValue() {
        int value = 0;  // Variable to store the total value of the hand
        int aceCount = 0;   // Variable to count the number of aces in the hand

        for (Card card : hand) {
            value += card.getValue();   // Calculate the total value of the hand by adding each card's value
            if (card.getValue() == 11) {
                aceCount++; // Count the number of aces in the hand (cards with value 11)
            }
        }
        // If the value of the hand is over 21 and there are aces consider their value as 1 instead of 11
        if (value > 21 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                aceCount--;
                value -= 10;
            }
        }
        return value;   // Return the final total value of the hand
    }

    public Card getCard(int index){
        return hand.get(index); // Get the card at the specified index in the hand
    }
}

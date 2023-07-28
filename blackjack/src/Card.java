package blackjack;

public class Card {
    private Rank rank;  // The rank of the card (e.g., Ace, King, Queen, etc.)
    private Suit suit;  // The suit of the card (e.g., Hearts, Diamonds, Clubs, Spades)

    public Card(Suit suit, Rank rank){
        this.rank = rank;    // Initialize the rank of the card
        this.suit = suit;   // Initialize the suit of the card
    }

    public int getValue(){

        return rank.rankValue;  // Return the numerical value associated with the rank of the card
    }

    public Suit getSuit(){

        return suit;    // Return the suit of the card
    }

    public Rank getRank(){

        return rank;    // Return the rank of the card
    }

    public String toString(){
        // Return a string representation of the card
        return ("[" + rank + " of " + suit + "] (value: " + this.getValue() + ")");
    }

    public Card(Card card){
        this.suit = card.getSuit(); // Create a copy of the card by copying its suit
        this.rank = card.getRank(); // Create a copy of the card by copying its rank
    }
}

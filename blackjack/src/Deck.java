package blackjack;
import java.util.ArrayList;
import java.util.Random;
public class Deck {
    private ArrayList<Card> deck;   // ArrayList to hold the cards in the deck

    public Deck(){
        deck = new ArrayList<Card>();   // Initialize the deck as an empty ArrayList
    }

    public String toString(){
        String output = "";

        for(Card card: deck){
            output += card; // Print a string representation of the cards in the deck
            output += "\n";
        }
        return output;
    }

    public Deck(boolean createDeck){
        deck = new ArrayList<Card>();
        if(createDeck){
            // If createDeck is true, create a full deck combining all possible suits and ranks
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void mix(){
        ArrayList<Card> mixed = new ArrayList<Card>();
        while(deck.size()>0){
            // Randomly select a card from the deck and add it to the mixed deck
            int cardTake = (int)(Math.random()*(deck.size()-1));
            mixed.add(deck.get(cardTake));
            deck.remove(cardTake);
        }
        deck = mixed;   // Set the deck to the newly mixed deck
    }

    public Card takeCard(){
        // Take the first card from the deck and remove it from the deck
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;
    }

    public boolean hasCards(){
        if(deck.size() > 0){    // Return true if the deck has cards, false otherwise
            return true;
        }
        else{
            return false;
        }
    }

    public void emptyDeck(){
        deck.clear();   // Clear all cards from the deck
    }

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public void reloadDeck(Deck discarded){
        // Reload the deck by adding the cards from the discarded deck, then mix the deck
        this.addCards(discarded.getCards());
        this.mix();
        discarded.emptyDeck();  // Empty the discarded deck
        System.out.println("Ran out of cards, shuffling the discarded pile");
    }

    public ArrayList<Card> getCards(){
        return deck;    // Return the ArrayList containing all the cards in the deck
    }

    public int cardsLeft(){
        return deck.size(); // Return the number of cards left in the deck
    }
}

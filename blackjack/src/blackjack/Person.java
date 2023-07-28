package blackjack;

public abstract class Person {
    private Hand hand; // The hand of cards held by the person
    private String name; // The name of the person

    public Person(){
        this.hand = new Hand(); // Create a new empty hand for the person
        this.name = ""; // Initialize the name as an empty string
    }

    public Hand getHand(){
        return this.hand; // Get the current hand of the person
    }

    public void setName(String name){
        this.name = name; // Set the name of the person to the provided name
    }

    public boolean hasBlackjack(){
        // Check if the hand value is 21, this indicates a blackjack
        if(this.getHand().handValue() == 21){
            return true; // Return true if the person has a blackjack
        }
        else{
            return false; // Return false if the person doesn't have a blackjack
        }
    }

    public void printHand(){
        // Print the name of the person and their current hand with its value
        System.out.println(this.name + "'s hand is:");
        System.out.println(this.hand + " Hand value: " + this.hand.handValue());
    }

    public void hit(Deck deck, Deck discarded){
        // If the deck is empty, reload it with cards from the discarded deck
        if(!deck.hasCards()){
            deck.reloadDeck(discarded);
        }
        // Take a card from the deck and add it to the person's hand
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card"); // Print a message indicating the person received a card
        this.printHand(); // Print the updated hand of the person
    }
}

package blackjack;

public class Dealer extends Person{
    public Dealer(){
        super.setName("Dealer");
    }

    public void printFirstHand(){
        System.out.println("The dealer's hand is:");
        System.out.println(super.getHand().getCard(0)); // Print the first card (face-up)
        System.out.println("The second card is face down.");    // Print that the second card is hidden
    }
}

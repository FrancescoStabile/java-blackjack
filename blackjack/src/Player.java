package blackjack;

import java.util.Scanner;

public class Player extends Person {
    public Player() {
        super.setName("Player");
    }

    Scanner input = new Scanner(System.in); // Create a Scanner object to read user input

    public void makeDecision(Deck deck, Deck discarded) {
        int decision = 0; // Variable to store the player's decision (Hit or Stand)
        boolean isNum = true; // Variable to validate if the input is a number

        while (isNum) {
            try {
                System.out.println("Would you like to Hit(1) or Stand(2)");
                decision = input.nextInt(); // Read the player's decision from the user
                isNum = false; // Mark isNum as false to exit the loop
            } catch (Exception e) {
                System.out.println("Not valid, choose (1) or (2)");
                input.next(); // Clear the invalid input from the scanner to avoid an infinite loop
            }
        }

        if (decision == 1) {
            this.hit(deck, discarded); // Player chooses to hit (get another card from the deck)
            if (this.getHand().handValue() > 20) {
                return; // If the player's hand value is over 20 (21 or bust), stop making decisions
            } else {
                this.makeDecision(deck, discarded); // Recursively continue making decisions if the hand value is <= 20
            }
        } else {
            System.out.println("You stand."); // Player chooses to stand (no more cards are drawn)
        }
    }
}

package blackjack;

public enum Suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");
    String cardSuit;

    Suit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String toString(){
        return cardSuit;
    }
}

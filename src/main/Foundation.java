package main;

public class Foundation extends StackCards {

    private Suit suit;

    public Foundation(Suit suit) {
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public boolean acceptMovement(Card card){
        return (this.getSuit() == card.getSuit() && 
               (card.getValue() == 1 && this.getCards().empty()||card.getValue() - this.getLastValue() == 1));
    }
}

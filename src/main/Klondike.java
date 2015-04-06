package main;

public class Klondike {
    
    protected Deck deck;

    protected Waste waste;
    
    public int getSizeWaste() {
        return this.waste.getCards().size();
    }

    public int getSizeDeck() {
        return this.deck.getCards().size();
    }
}

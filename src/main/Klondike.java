package main;

public class Klondike {
    
    protected StackCards deck;

    protected StackCards waste;
      
    public int getSizeWaste() {
        return this.waste.getCards().size();
    }

    public int getSizeDeck() {
        return this.deck.getCards().size();
    }
    
    public StackCards getWaste() {
        return waste;
    }

    public void setWaste(StackCards waste) {
        this.waste = waste;
    }
}

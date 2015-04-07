package main;

public class Klondike {

    protected StackCards deck;

    protected StackCards waste;

    protected StackCards tableau;

    public int getSizeWaste() {
        return this.waste.getCards().size();
    }

    public int getSizeDeck() {
        return this.deck.getCards().size();
    }

    public int getSizeTableau() {
        return this.tableau.getCards().size();
    }

    public StackCards getWaste() {
        return waste;
    }

    public void setWaste(StackCards waste) {
        this.waste = waste;
    }

    public StackCards getTableau() {
        return tableau;
    }

    public void setTableau(StackCards tableau) {
        this.tableau = tableau;
    }
    
    
}

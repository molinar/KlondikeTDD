package main;

public class MoveCardController {

    private Deck deck;

    private Waste waste;
 
    public MoveCardController(int sizeDeck, int sizeWaste) {
        this.deck = new Deck(sizeDeck);
        this.waste = new Waste(sizeWaste);
    }

    public void moveFromDeckToWaste() {
        if (this.deck.getCards().empty()) {
            for (int i = 0; i < this.getSizeWaste(); i++) {
                this.deck.getCards().push(this.waste.getCards().peek());
            }
            this.waste.getCards().clear();
        } else {
            Card card = this.deck.getCards().pop();
            this.waste.getCards().push(card);
        }
    }

    public int getSizeDeck() {
        return this.deck.getCards().size();
    }

    public int getSizeWaste() {
        return this.waste.getCards().size();
    }

}

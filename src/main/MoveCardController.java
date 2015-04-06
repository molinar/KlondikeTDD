package main;

public class MoveCardController extends Klondike{

    public MoveCardController(int sizeDeck, int sizeWaste) {
        this.deck = new Deck(sizeDeck);
        this.waste = new Waste(sizeWaste);
    }

    public void moveFromDeckToWaste() {
        if (this.deck.getCards().empty()) {
            for (int i = 0; i < this.getSizeWaste(); i++) {
                this.deck.getCards().push(this.waste.getCards().peek()).setUncovered(false);
            }
            this.waste.getCards().clear();
        } else {
            Card card = this.deck.getCards().pop();
            this.waste.getCards().push(card).setUncovered(true);
        }
    }
}

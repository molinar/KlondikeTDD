package main;

public class MoveCardController extends Klondike {

    public MoveCardController(int sizeDeck, int sizeWaste) {
        this.deck = new StackCards(sizeDeck);
        this.waste = new StackCards(sizeWaste);
    }

    public MoveCardController() {
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
    
    public void moveToFoundation(Foundation foundation, StackCards stackCards) {
        if (foundation.acceptMovement(stackCards.getCards().peek())) {
            foundation.getCards().push(stackCards.getCards().pop());
        }
    }
}

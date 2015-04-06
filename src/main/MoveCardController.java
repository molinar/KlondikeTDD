package main;

public class MoveCardController extends Klondike{
    
    public MoveCardController(int sizeDeck, int sizeWaste) {
        this.deck = new StackCards(sizeDeck);
        this.waste = new StackCards(sizeWaste);
    }
    
    public MoveCardController(){
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
    
    public void moveFromWasteToFoundation(Foundation foundation){
        if(foundation.getSuit() == this.waste.getCards().peek().getSuit() && 
          (this.waste.getCards().peek().getValue() == 1 && foundation.getCards().empty())){
            foundation.getCards().push(this.waste.getCards().pop());
        }else if(foundation.getSuit() == this.waste.getCards().peek().getSuit() && 
          this.waste.getCards().peek().getValue() - foundation.getCards().peek().getValue() == 1){
            foundation.getCards().push(this.waste.getCards().pop());
        }
    }    
}

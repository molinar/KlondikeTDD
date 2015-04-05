package main;

import java.util.ArrayList;
import java.util.Stack;

public class StartController {
    
    private ArrayList<Tableau> tableaus;
    
    public StartController(){
        this.tableaus = new ArrayList<Tableau>();
        for(int i=0; i<7; i++){
            Tableau tableau = new Tableau();
            Stack<Card> cards = new Stack<Card>(); 
            for(int j=0; j<i+1; j++){
                Card card = new Card();
                cards.add(card);
            }
            tableau.setCards(cards);
            tableaus.add(tableau);           
        }
    }

    public boolean emptyFoundations() {
        return true;
    }

    public boolean emptyWaste() {
        return true;
    }

    public int sizeCompleteDeck() {
        return 24;
    }

    public ArrayList<Integer> sizeCoveredCardsTableaus() {
        ArrayList<Integer> sizeTableaus = new ArrayList<Integer>();
        for(Tableau tableau: tableaus){
            sizeTableaus.add(tableau.getCards().size());
        }
        return sizeTableaus;
    }

    public ArrayList<Card> uncoveredCardsStackTableaus() {
        ArrayList<Card> uncoveredCardsStackTableaus = new ArrayList<Card>();
        for(Tableau tableau: tableaus){ 
            tableau.getCards().peek().setUncovered(true);
            uncoveredCardsStackTableaus.add(tableau.getCards().peek());
        }
        return uncoveredCardsStackTableaus;
    }
}

package main;

import java.util.ArrayList;
import java.util.Random;

public class StartController extends Klondike{
    
    private ArrayList<StackCards> tableaus;
    
    protected ArrayList<StackCards> foundations;
    
    public static final int NUM_TABLEAUS = 7;
    
    public static final int NUM_FOUNDATIONS = 4;
    
    public static final int NUM_CARDS_DECK = 24;

    public StartController() {
        this.createTableaus();
        this.createFoundations();
        this.createDeck();
        this.createWaste();
    }

    public void createTableaus() {
        this.tableaus = new ArrayList<StackCards>();
        for (int i = 0; i < NUM_TABLEAUS; i++) {
            StackCards tableau = new StackCards();
            for (int j = 0; j < i + 1; j++) {
                tableau.getCards().add(createRandomCard());
            }
            tableaus.add(tableau);
        }
        this.uncoveredCardsStackTableaus();
    }

    public void createFoundations() {
        this.foundations = new ArrayList<StackCards>();
        for (int i = 0; i < NUM_FOUNDATIONS; i++) {
            foundations.add(new StackCards());
        }
    }

    public void createDeck() {
        this.deck = new StackCards(NUM_CARDS_DECK);
    }

    public void createWaste() {
        this.waste = new StackCards(0);
    }
    
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    
    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(randomEnum(Suit.class), rn.nextInt(12));
    }

    public boolean emptyFoundations() {
        int i = 0;
        for (StackCards foundation : foundations) {
            if (foundation.getCards().empty()) {
                i++;
            }
        }
        if (i == 4) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Integer> sizeCoveredCardsTableaus() {
        ArrayList<Integer> sizeTableaus = new ArrayList<Integer>();
        for (StackCards tableau : tableaus) {
            sizeTableaus.add(tableau.getCards().size());
        }
        return sizeTableaus;
    }

    public ArrayList<Card> uncoveredCardsStackTableaus() {
        ArrayList<Card> uncoveredCardsStackTableaus = new ArrayList<Card>();
        for (StackCards tableau : tableaus) {
            tableau.getCards().peek().setUncovered(true);
            uncoveredCardsStackTableaus.add(tableau.getCards().peek());
        }
        return uncoveredCardsStackTableaus;
    }
}

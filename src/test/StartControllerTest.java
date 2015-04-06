package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Card;
import main.StartController;

public class StartControllerTest {
    
    private StartController startController;
    
    @Before
    public void before(){
        startController = new StartController();
    }
    
    @Test
    public void emptyFoundationsTest(){
        assertTrue(startController.emptyFoundations());
    }
    
    @Test
    public void emptyWasteTest(){
        assertEquals(0, startController.sizeWaste());
    }
    
    @Test
    public void sizeCompleteDeckTest(){
        assertEquals(24, startController.sizeDeck());
    }
    
    @Test
    public void sizeCoveredCardsTableausTest(){
        ArrayList<Integer> sizeTableaus = startController.sizeCoveredCardsTableaus();
        assertEquals(7,sizeTableaus.size());
        for(int i = 0; i < sizeTableaus.size();i++) {
            assertEquals(new Integer(i+1),sizeTableaus.get(i));
        }
    }
    
    @Test
    public void uncoveredCardsStackTableausTest(){
        ArrayList<Card> uncoveredCardsStackTableaus = startController.uncoveredCardsStackTableaus();
        assertEquals(7,uncoveredCardsStackTableaus.size());
        for(Card uncoveredCardStack : uncoveredCardsStackTableaus) {
            assertTrue(uncoveredCardStack.isUncovered());
        }
    }
}

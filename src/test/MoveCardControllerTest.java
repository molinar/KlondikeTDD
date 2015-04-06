package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.MoveCardController;
import main.StartController;

public class MoveCardControllerTest {
    
    StartController startController = new StartController();
    
    @Before
    public void before(){
        startController.createTableaus();
        startController.createFoundations();
    }
    
    @Test
    public void moveFromDeckToWasteTest(){
        MoveCardController moveCardController1 = new MoveCardController(24,0);
        moveCardController1.moveFromDeckToWaste();
        assertEquals(23, moveCardController1.getSizeDeck());
        assertEquals(1, moveCardController1.getSizeWaste());
        
        MoveCardController moveCardController2 = new MoveCardController(0,20);
        moveCardController2.moveFromDeckToWaste();
        assertEquals(20, moveCardController2.getSizeDeck());
        assertEquals(0, moveCardController2.getSizeWaste());
        
        MoveCardController moveCardController3 = new MoveCardController(1,0);
        moveCardController3.moveFromDeckToWaste();
        assertEquals(0, moveCardController3.getSizeDeck());
        assertEquals(1, moveCardController3.getSizeWaste());
        
        MoveCardController moveCardController4 = new MoveCardController(2,2);
        moveCardController4.moveFromDeckToWaste();
        assertEquals(1, moveCardController4.getSizeDeck());
        assertEquals(3, moveCardController4.getSizeWaste());
        
        MoveCardController moveCardController5 = new MoveCardController(10,2);
        moveCardController5.moveFromDeckToWaste();
        assertEquals(9, moveCardController5.getSizeDeck());
        assertEquals(3, moveCardController5.getSizeWaste());
        
        MoveCardController moveCardController6 = new MoveCardController(0,1);
        moveCardController6.moveFromDeckToWaste();
        assertEquals(1, moveCardController6.getSizeDeck());
        assertEquals(0, moveCardController6.getSizeWaste());
    }

}

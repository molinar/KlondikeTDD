package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
        assertTrue(startController.emptyWaste());
    }
    
    @Test
    public void completeDeckTest(){
        assertEquals(24, startController.completeDeck().size());
    }
    
    @Test
    public void completeRandomTableauTest(){
    }

}

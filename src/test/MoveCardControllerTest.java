package test;

import org.junit.Before;

import main.MoveCardController;
import main.StartController;

public class MoveCardControllerTest {
    
    MoveCardController moveCardController;
    StartController startController = new StartController();
    
    @Before
    public void before(){
        startController.createTableaus();
        startController.createFoundations();
        startController.createWaste();
    }

}

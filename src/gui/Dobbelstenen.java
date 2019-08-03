
package gui;

import domein.DomeinController;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;


public class Dobbelstenen extends TilePane{
    private ArrayList<Button> Dices;
    private DomeinController dc;
    private SpelOverzicht so;
    
    
    public  Dobbelstenen(SpelOverzicht so,DomeinController dc){
        this.dc=dc;
        this.so=so;
        
       buildGui(); 
        
        
    }
    private void buildGui(){
        Dices=new ArrayList<Button>();
        
    }
    
    
}

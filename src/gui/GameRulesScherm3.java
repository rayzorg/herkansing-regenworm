/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author bjorn
 */
public class GameRulesScherm3 extends BorderPane{
    
    private final DomeinController dc;
    private final Startscherm sts;
    private final GameRulesScherm2 grs2;
    private final GameRulesScherm grs;
    
    
    
    public GameRulesScherm3(Startscherm sts, GameRulesScherm grs, GameRulesScherm2 grs2, DomeinController dc){
        this.sts = sts;
        this.grs = grs;
        this.grs2 = grs2;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){
        
        getStylesheets().add("/css/gamerulesscherm3.css");
        
        BorderPane bp = new BorderPane();
        HBox knop = new HBox();
        
        
        
        
        
        Button btnBack = new Button();
        btnBack.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent evt) 
            {
                
                Stage stage = (Stage) getScene().getWindow();
                stage.setScene(sts.getScene());
            }
        });
        
        btnBack.setId("btnBack");
        btnBack.setPrefSize(100, 100);
        
        
        Button btnArrowLeft = new Button();
        btnArrowLeft.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent evt) 
            {
                btnArrowLeftOnAction(evt);
                
            }
        });
        
        btnArrowLeft.setId("btnArrowLeft");
        btnArrowLeft.setPrefSize(100, 100);
       
        
        
        
        knop.getChildren().addAll(btnArrowLeft, btnBack);
        
        
        knop.setAlignment(Pos.BOTTOM_CENTER);
        knop.setPadding(new Insets(15));
        knop.setSpacing(15);
        
        
        
        
        bp.setBottom(knop);
        
        this.setCenter(bp);
        
    }
    
    private void btnArrowLeftOnAction(ActionEvent event)
    {
        GameRulesScherm2 grs2 = new GameRulesScherm2(sts, grs, dc);
        Scene scene = new Scene(grs2, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
    }
}
    


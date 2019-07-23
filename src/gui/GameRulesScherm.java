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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bjorn
 */
public class GameRulesScherm extends BorderPane{
private final DomeinController dc;
    private final Startscherm sts;
    
    
    public GameRulesScherm(Startscherm sts, DomeinController dc){
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){
        
        getStylesheets().add("/css/gamerulesscherm.css");
        
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
        
        
        Button btnArrowRight = new Button();
        btnArrowRight.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent evt) 
            {
                btnArrowRightOnAction(evt);
                
            }
        });
        
        btnArrowRight.setId("btnArrowRight");
        btnArrowRight.setPrefSize(100, 100);
       
        
        
        
        knop.getChildren().addAll(btnBack, btnArrowRight);
        
        
        knop.setAlignment(Pos.BOTTOM_CENTER);
        knop.setPadding(new Insets(15));
        knop.setSpacing(15);
        
        
        
        
        bp.setBottom(knop);
        
        this.setCenter(bp);
        
    }
    
    private void btnArrowRightOnAction(ActionEvent event)
    {
        GameRulesScherm2 grs2 = new GameRulesScherm2(sts, this, dc);
        Scene scene = new Scene(grs2, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
    }
}
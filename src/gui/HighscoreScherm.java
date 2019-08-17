/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class HighscoreScherm extends BorderPane{
    private final DomeinController dc;
    private final Startscherm sts;
    
    
    public HighscoreScherm(Startscherm sts, DomeinController dc){
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){
        
        getStylesheets().add("/css/highscoreScherm.css");
        
        BorderPane bp = new BorderPane();
        HBox knop = new HBox();
        VBox vbox = new VBox();
        GridPane gp = new GridPane();
        
        Label lblHighscores = new Label("Highscores");
        lblHighscores.setId("lblHighscores");
        System.out.printf("%s",dc.getHighScore());
        
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
        
        // gp (gridpane) voor de highscores
        
        lblHighscores.setAlignment(Pos.CENTER);
        lblHighscores.setPadding(new Insets(-100,0,0,0));
        
        knop.getChildren().add(btnBack);
        vbox.getChildren().addAll(lblHighscores, gp);
        
        knop.setAlignment(Pos.BOTTOM_CENTER);
        knop.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);
        
        
        bp.setCenter(vbox);
        bp.setBottom(knop);
        
        this.setCenter(bp);
        
    }
}

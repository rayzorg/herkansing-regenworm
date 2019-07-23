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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author bjorn
 */
public class Startscherm extends BorderPane {
    
    private final  DomeinController dc;
    
    public Startscherm(DomeinController dc) {
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){

        
       
//Panes/Boxes/CSS *********************************************************************    
        getStylesheets().add("/css/startscherm.css");
        GridPane gpane = new GridPane();
        //setCancelDefault fzoiets vr via escape terug naar vorig scherm
        
//Start button ************************************************************************   
        
        Button btnStart = new Button();
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnStartOnAction(ae);
            }
        });
        
        btnStart.setId("btnStart");
        btnStart.setPrefSize(200, 50);
        //btnStart.prefHeightProperty().bind(this.heightProperty().multiply(1));
        
//Resume button ************************************************************************           
        // Enkel resume game als er al een game in het spel is!
        Button btnResume = new Button();
        btnResume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnResumeOnAction(ae);
            }
        });
        
        btnResume.setDisable(true);
        btnResume.setId("btnResume");
        btnResume.setPrefSize(200, 50);
        //btnResume.prefHeightProperty().bind(this.heightProperty().multiply(1));
        
//Highscores button ************************************************************************   
        Button btnHighScores = new Button();
        btnHighScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnHighscoresOnAction(ae);
            }
        });
        
        btnHighScores.setId("btnHighScores");
        btnHighScores.setPrefSize(200, 50);
        //btnHighscores.prefHeightProperty().bind(this.heightProperty().multiply(1));
        
        
//Rules button ************************************************************************   
        Button btnGameRules = new Button();
        btnGameRules.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnGameRulesOnAction(ae);
            }
        });
        
        btnGameRules.setId("btnGameRules");
        btnGameRules.setPrefSize(200, 50);
       // btnHighscores.prefHeightProperty().bind(this.heightProperty().multiply(1));
        
//Centering van de Gridpane ***************************************************************
        
        gpane.add(btnStart, 0, 0);
        gpane.add(btnResume, 0, 1);
        gpane.add(btnHighScores, 0, 2);
        gpane.add(btnGameRules, 0, 3);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(50,5,5,5));
        gpane.setHgap(1);
        gpane.setVgap(1);
        setCenter(gpane);
        
    }
    
    private void btnStartOnAction(ActionEvent event)
    {
        //dc.deleteData() = mogelijke methode om nieuw spel te starten
        SpelersSettings ss = new SpelersSettings(this, dc);
        Scene scene = new Scene(ss, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        
    }
    
    private void btnHighscoresOnAction(ActionEvent event)
    {
        HighscoreScherm hs = new HighscoreScherm(this, dc);
        Scene scene = new Scene(hs, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
     
    }
    
    
    private void btnResumeOnAction(ActionEvent event)
    {/*
        // dc aanspreken + vullen met sepl dat laatste werd opgeslagen en onderbroken
        dc.vulDomein();
        OverzichtScherm overzichtscherm = new OverzichtScherm(dc,dc.geefSpelInfo()[1],1);
        Scene scene = new Scene(overzichtscherm,1250,700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
    */
    }
    
    private void btnGameRulesOnAction(ActionEvent event)
    {
        GameRulesScherm grs = new GameRulesScherm(this, dc);
        Scene scene = new Scene(grs, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
    }
}

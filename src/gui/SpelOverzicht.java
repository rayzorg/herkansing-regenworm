/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author bjorn
 */
public class SpelOverzicht extends BorderPane{
    private final DomeinController dc;
    public int dbl = 0;
    public int dblValue = 0;
    public boolean worm = false;
    //public int berekenScore = 0;
    private final Startscherm sts;
    private int wormenWinnaar;
    private String winnaar;
    

    public SpelOverzicht(Startscherm sts, DomeinController dc) // login???
    {
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui() 
    {
//Panes/Boxes ******************************************************************  
        getStylesheets().add("/css/speloverzicht.css");
        //BorderPane bp = new BorderPane();
        VBox bckgrndLeft = new VBox();
        bckgrndLeft.setId("VBbckgrndLeft");
        bckgrndLeft.setPrefSize(300, 600);
        
        VBox bckgrndRight = new VBox();
        bckgrndRight.setId("VBbckgrndRight");
        bckgrndRight.setPrefSize(300, 600);
        
        VBox vboxMiddle = new VBox();
        
        GridPane gpCenter = new GridPane();
        GridPane gpLeft = new GridPane();
        GridPane gpRight = new GridPane();
        
        HBox info = new HBox();
        HBox tileRow = new HBox();
        HBox throwOrStop = new HBox();
        
        
        
        

//Labels/Textfields ************************************************************
        //TextFields
        wormenWinnaar = 5;
        winnaar = "Speler 1";
        
        
        Label lblOutputGame = new Label();
        lblOutputGame.setId("lblOutputGame");
         
        lblOutputGame.setPrefSize(300, 100);
        
        Label lblAantalDblOver = new Label();
        lblAantalDblOver.setId("lblAantalDblOver8");
        lblAantalDblOver.setPrefSize(200, 125);
        
        //Labels
        //currentPlayer.getnaam
          ArrayList <Button> btnDices =new ArrayList<>();
          ArrayList <Button> btnUpperTilesPlayers =new ArrayList<>(); // op basis van het aantal spelers aan deze array de upper tile buttons toevoegen
        int g=0;
        
       
        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
            
            String naam=dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText();
            Label lblCurrentPlayer = new Label(String.format("huidige speler : %n %s",dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText())); // voor in Leftgp te zetten
            gpLeft.add(lblCurrentPlayer, g, 0);
            
            Label lblSpeler1 = new Label(dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText());  
            Button btnUpperTileSpeler1 = new Button();
            btnUpperTilesPlayers.add(btnUpperTileSpeler1);
            
            
         
            
            gpRight.add(lblSpeler1, g, spelers);
            gpRight.add(btnUpperTileSpeler1, g+1, spelers); // bovensteTegel van een player maar voorlopig gebruiken we dit als tijdelijke replacement
            
            
             
             //btn1        
        
            btnUpperTileSpeler1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnUpperTileSpeler1OnAction(ae);
            }
            });
        
            btnUpperTileSpeler1.setId("btnUpperTileSpeler1");
            btnUpperTileSpeler1.setPrefSize(100, 160);
            
            //////////////////////////
           
        
        
        }
        

//btns voor bovensteTegelsStapels----------------------------------------------


/*
//btn1        
        
        btnUpperTileSpeler1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnUpperTileSpeler1OnAction(ae);
            }
        });
        
        btnUpperTileSpeler1.setId("btnUpperTileSpeler1");
        btnUpperTileSpeler1.setPrefSize(100, 160);
      */  



       
        
        
        
        
        
        
        
        Label lblScoreCurrentPlayer = new Label(String.format("Score: %d", dc.berekenScore()));
            gpLeft.add(lblScoreCurrentPlayer, g, 1);
        
        // Label lblScoreCurrentPlayer = new Label(String.format("Score: %d", dc.berekenScore()));
         //gpLeft.add(lblScoreCurrentPlayer, 0, 1);
         
        Button IDdbl = new Button(); // passieve knop wordt gebruikt voor een controle
        
        int huidigeSpeler = 0; // als tegel is genomen wordt huidigeSpeler verhoogt (++) -> if huidigeSpeler == spelerArrayListSize dan huidige speler = 0
        
        Button btnStop = new Button();
        btnStop.setDisable(true);
        Button btnGooi = new Button();
        btnStop.setDisable(false);
        
        Button btnNieuwSpel = new Button();
        btnNieuwSpel.setId("btnNieuwSpel");
        btnNieuwSpel.setPrefSize(220, 50);
        
      /*  btnNieuwSpel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnNieuwSpelOnAction(ae);
            }
        });*/
        
        
        
        Button btnSaveAndQuit = new Button();
        
        
        
        Button btnTegel21 = new Button();
        btnTegel21.setDisable(true);
        Button btnTegel22 = new Button();
        btnTegel22.setDisable(true);
        Button btnTegel23 = new Button();
        btnTegel23.setDisable(true);
        Button btnTegel24 = new Button();
        btnTegel24.setDisable(true);
        Button btnTegel25 = new Button();
        btnTegel25.setDisable(true);
        Button btnTegel26 = new Button(); 
        btnTegel26.setDisable(true);
        Button btnTegel27 = new Button();
        btnTegel27.setDisable(true);
        Button btnTegel28 = new Button();
        btnTegel28.setDisable(true);
        Button btnTegel29 = new Button();
        btnTegel29.setDisable(true);
        Button btnTegel30 = new Button();
        btnTegel30.setDisable(true);
        Button btnTegel31 = new Button();
        btnTegel31.setDisable(true);
        Button btnTegel32 = new Button();
        btnTegel32.setDisable(true);
        Button btnTegel33 = new Button();
        btnTegel33.setDisable(true);
        Button btnTegel34 = new Button();
        btnTegel34.setDisable(true);
        Button btnTegel35 = new Button();
        btnTegel35.setDisable(true);
        Button btnTegel36 = new Button();
        btnTegel36.setDisable(true);
        
        Button btnDice1 = new Button();
        btnDices.add(btnDice1);
        btnDice1.setDisable(true);
        //btnDice1.setId("btnDiceDisabled");
        
        Button btnDice2 = new Button();
        btnDices.add(btnDice2);
        btnDice2.setDisable(true);
       // btnDice2.setId("btnDiceDisabled");
        
        Button btnDice3 = new Button();
        btnDices.add(btnDice3);
        btnDice3.setDisable(true);
       // btnDice3.setId("btnDiceDisabled");
        
        Button btnDice4 = new Button();
        btnDices.add(btnDice4);
        btnDice4.setDisable(true);
       // btnDice4.setId("btnDiceDisabled");
        
        Button btnDice5 = new Button();
        btnDices.add(btnDice5);
        btnDice5.setDisable(true);
       // btnDice5.setId("btnDiceDisabled");
        
        Button btnDice6 = new Button();
        btnDices.add(btnDice6);
        btnDice6.setDisable(true);
       // btnDice6.setId("btnDiceDisabled");
        
        Button btnDice7 = new Button();
        btnDices.add(btnDice7);
        btnDice7.setDisable(true);
      //  btnDice7.setId("btnDiceDisabled");
        
        Button btnDice8 = new Button();
        btnDices.add(btnDice8);
        btnDice8.setDisable(true);
       // btnDice8.setId("btnDiceDisabled");
        
       
        
        //btn Save & Quit --------------------------------------------------------
        
        btnSaveAndQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnSaveAndQuitOnAction(ae);
            }
        });
        
        btnSaveAndQuit.setId("btnSaveAndQuit");
        btnSaveAndQuit.setPrefSize(220, 50);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Label lblScoreCurrentPlayer = new Label(String.format("Score: %d", dc.berekenScore()));
        
        
         
            
//Buttons **********************************************************************
        
        
        
        

//btns voor bovensteTegelsStapels----------------------------------------------



//btn1        
        
      /*  btnUpperTileSpeler1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnUpperTileSpeler1OnAction(ae);
            }
        });
        
        btnUpperTileSpeler1.setId("btnUpperTileSpeler1");
        btnUpperTileSpeler1.setPrefSize(100, 160);
      
*/
//btns vr tegelRij--------------------------------------------------------
        
        btnTegel21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel21OnAction(ae);
            }
        });
        
        btnTegel21.setId("btnTegel21");
        btnTegel21.setPrefSize(100, 160);
        
        
        btnTegel22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel22OnAction(ae);
            }
        });
        
        btnTegel22.setId("btnTegel22");
        btnTegel22.setPrefSize(100, 160);
        
        
        btnTegel23.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel23OnAction(ae);
            }
        });
        
        btnTegel23.setId("btnTegel23");
        btnTegel23.setPrefSize(100, 160);
        
        
        btnTegel24.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel24OnAction(ae);
            }
        });
        
        btnTegel24.setId("btnTegel24");
        btnTegel24.setPrefSize(100, 160);
        
       
        btnTegel25.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel25OnAction(ae);
            }
        });
        
        btnTegel25.setId("btnTegel25");
        btnTegel25.setPrefSize(100, 160);
        
        
        btnTegel26.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel26OnAction(ae);
            }
        });
        
        btnTegel26.setId("btnTegel26");
        btnTegel26.setPrefSize(100, 160);
        
        
        btnTegel27.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel27OnAction(ae);
            }
        });
        
        btnTegel27.setId("btnTegel27");
        btnTegel27.setPrefSize(100, 160);
        
        
        btnTegel28.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel28OnAction(ae);
            }
        });
        
        btnTegel28.setId("btnTegel28");
        btnTegel28.setPrefSize(100, 160);
        
        
        btnTegel29.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel29btnTegel21OnAction(ae);
            }
        });
        
        btnTegel29.setId("btnTegel29");
        btnTegel29.setPrefSize(100, 160);
        
        
        btnTegel30.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel30OnAction(ae);
            }
        });
        
        btnTegel30.setId("btnTegel30"); 
        btnTegel30.setPrefSize(100, 160);
        
        
        btnTegel31.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel31OnAction(ae);
            }
        });
        
        btnTegel31.setId("btnTegel31");
        btnTegel31.setPrefSize(100, 160);
        
        
        btnTegel32.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel32OnAction(ae);
            }
        });
        
        btnTegel32.setId("btnTegel32");
        btnTegel32.setPrefSize(100, 160);
        
        
        btnTegel33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel33OnAction(ae);
            }
        });
        
        btnTegel33.setId("btnTegel33");
        btnTegel33.setPrefSize(100, 160);
        
        
        btnTegel34.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel34OnAction(ae);
            }
        });
        
        btnTegel34.setId("btnTegel34"); 
        btnTegel34.setPrefSize(100, 160);
        
        
        btnTegel35.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel35OnAction(ae);
            }
        });
        
        btnTegel35.setId("btnTegel35");
        btnTegel35.setPrefSize(100, 160);
        
        
        btnTegel36.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
               // btnTegel36OnAction(ae);
            }
        });
        
        btnTegel36.setId("btnTegel36");
        btnTegel36.setPrefSize(100, 160);
        
        
        
//btnsDblst----------------------------------------------------------

/*
       for(int l = 0; l < btnDices.size(); l++){
            btnDices.get(l).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
           /* if(dc.berekenScore() >=21){
                if(dc.getGekozen().contains(6)){
                            //Output label miss instellen op wat er gebeurt bv tegel verloren of tegel nemen of alles werd al is gepakt en tegel verloren
                            
                            for(int b=0;b<dc.getSpelersArrayList().size();b++){
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(b)).isEmpty()){
                                    nietAllemaalLeeg = true;
                                }
                            }
                            
                            if(nietAllemaalLeeg == true){
                            
                                    for(int j=0;j<dc.getSpelersArrayList().size();j++){
                                        if(!dc.eigenStapel(dc.getSpelersArrayList().get(j)).isEmpty()){  
                                            int itemVanI = dc.eigenStapel(dc.getSpelersArrayList().get(i)).size(); 
                                            item=dc.eigenStapel(dc.getSpelersArrayList().get(j)).size();
                                            nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(j)).get((Integer)item-1);
                                            if(dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                                if(nieuw == dc.berekenScore()){
                                                    steal = true;
                                                    theSteal = nieuw;
                                                    victim = j;
                                                }
                                            }
                                            else if(nieuw == dc.berekenScore() && nieuw != dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)itemVanI-1)){
                                                steal = true;
                                                theSteal = nieuw;
                                                victim = j;
                                            }
                                        }
                                        
                                    }
                            }
                            
                            
                           
                            for(int teg1 : dc.getTegelStapel()){
                                if(teg1 == dc.berekenScore()){
                                    tegelInRij = true;
                                }
                            }
                            
                            
                            for(int teg2 : dc.getTegelStapel()){
                                if(teg2 < dc.berekenScore()){
                                    lagereTegel = true;
                                }
                            }
                        
                                
                            

                            if(tegelInRij == false && steal == false  && lagereTegel == false){
                                System.out.printf("%nMaar jammer, er is geen enkele tegel beschikbaar die voldoet aan jouw score...%n");
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                    System.out.printf("%nJe verliest een tegel.");
                                
                                    item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                    nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                    //bovenste tegel checken
                                    item2=dc.getTegelStapel().size();
                                    int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                    try{
                                        if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                            System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                           
                                        }
                                    }catch(IndexOutOfBoundsException e){
                            
                                    }
                        
                                    if(nieuw>nieuw2){
                                        dc.getTegelStapel().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }else{
                                        dc.getOmgedraaideTegels().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }
            //einde checken
                                }
                    //einde checken
                            }
                
                            else if(tegelInRij == true ){
                      
                                System.out.printf("%n%nTegelrij: %n%s%n", dc.getTegelStapel().toString());
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else {
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                            
                                System.out.printf("%n%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                
                                while(dc.getKiesTegel()>dc.berekenScore() || !dc.getTegelStapel().contains(dc.getKiesTegel())){
                                    System.out.printf("Je moet een tegel nemen die lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                         
                   
                            else if(steal == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                                
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(dc.getKiesTegel()>dc.berekenScore() || dc.getKiesTegel()< 21){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                  
                                if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }
                            
                                else{
                                    while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore() ){
                                        System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                        dc.setKiesTegel(input.nextInt());
                                    }
                                    if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }else{
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                    dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                                    }
                                }
                            }
                      
                            else if(lagereTegel == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                    }
                                }
                            
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore()){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is en lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                        }
                    
                        else {
                            System.out.printf("%n%nJammer, je beurt was niet succesvol aangezien je geen worm hebt kunnen bemachtigen... ");
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                System.out.printf("%nJe verliest een tegel.");
                                
                                item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                //bovenste tegel checken
                                item2=dc.getTegelStapel().size();
                                int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                try{
                                    if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                        System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                            
                                }
                        
                                if(nieuw>nieuw2){
                                    dc.getTegelStapel().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }else{
                                    dc.getOmgedraaideTegels().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }
            //einde checken

                                
                            }
                        }
                    
                        System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                        System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                    
                        for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                            } else{
                                System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                            }
                        }
                    
                        dc.resetAantalDobbelsteen();
                        dc.resetScore();
                        dc.getGekozen().clear();
                        dc.getGeworpen().clear();
                          
                     
                        break;}
                }}
            );
        };
*/

//dice1
        
        
        btnDice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                
                
                    if(btnDice1.getId() == "btnDice1"){                      // als de button1 bv ge lijk is aan de afbeelding van een dobbelsteen met symbool 1 dan wordt setSymbool op 1 gezet
                        dc.setSymbool(1);
                    }
                    else if(btnDice1.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice1.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice1.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice1.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice1.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
        
                    lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore())); // zolang score onder de 21 dan disable je de stop knop
                    if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                    
                    switch(dc.berekenAantalDobbelsteen()){                      // label van dobbelstenen over id geven van de correcte hoeveelheid
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                    
                    IDdbl.setId(btnDice1.getId());                           // String IDdbl wordt gelyk gezet aan ID van deze button want in volgend blokje 
                                                                        // code zou het kunnen dat deze button ID met zichzelf wordt vergeleken en dan dus verkeerd wordt vergeleken
                    
                    for(int i = 0; i < btnDices.size(); i++){           // alle dobbelstenen die eenzelfde symbool hebben al dat je hebt 
                        if(IDdbl.getId() == btnDices.get(i).getId()){               // genomen worden onzichtbaargezet en gedisabled want anders kan men ze nog nemen
                            btnDices.get(i).setDisable(true);               // En ook worden deze uit de arraylist van btnDices geremoved zodat ze by nieuwe "gooi" niet meer meedoen
                            btnDices.get(i).setId("btnDiceDisabled");
                            btnDices.remove(btnDices.get(i));
                        }
                    }
                    
                    if(dc.berekenAantalDobbelsteen() == 0){               // als dobbelstenen op zijn wordt gooi en stop op disabled gezet (tegel pakken en dan volgende zijn beurt)
                    btnGooi.setDisable(true); 
                    btnStop.setDisable(true);
                    }
                
                
                
         
                for(int i = 0; i < btnDices.size(); i++){            // alles onzichtbaar zetten alsof je opnieuw dobbelstenen in handen neemt en gooit
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
                
                
                // tegel pakken
                
                
                
                if(dc.berekenScore() >=21 && dc.getGekozen().contains(6)){
                    int s;
                    boolean steal = false;
                    int theVictim = 0;
                    int item=dc.eigenStapel(dc.getSpelersArrayList().get(huidigeSpeler)).size();
                    int nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(huidigeSpeler)).get((Integer)item-1);
                    int huidigeSpeler = 0;
                    switch(dc.berekenScore()){
                        case 21:for(s=0; s< btnUpperTilesPlayers.size(); s++){          // for loop om te loopen over uppertiles andere spelers
                                    if(btnUpperTilesPlayers.get(s).getId() == "btnTegel21"){
                                        steal = true;
                                        theVictim = s;
                                    }
                                }
                        
                                if(btnTegel21.getId() == "btnTegel21"){
                                    btnTegel21.setDisable(false);
                                    break;
                                }
                                else if(steal == true){
                                    btnUpperTilesPlayers.get(theVictim).setDisable(false);
                                    break;
                                }
                                else{
                                    if(!dc.eigenStapel.isEmpty()){
                                        dc.eigenStapel(dc.getSpelersArrayList().get(huidigeSpeler)).remove((Integer)nieuw);
                                        if(huidigeSpeler != dc.spelersArrayList.size()){
                                            huidigeSpeler++;
                                        }
                                        else{
                                            huidigeSpeler = 0;
                                        }
                                    }
                                    else{
                                        if(huidigeSpeler != dc.spelersArrayList.size()){
                                            huidigeSpeler++;
                                        }
                                        else{
                                            huidigeSpeler = 0;
                                        }
                                    }
                                }
                        case 22: btnTegel21.setDisable(false);
                                 btnTegel22.setDisable(false);
                        case 23: btnTegel21.setDisable(false);
                                 btnTegel22.setDisable(false);
                                 btnTegel23.setDisable(false);
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                                    
                    }
                    
                }
                
            }
        });
       
        
        btnDice1.setPrefSize(100, 130);

//dice2         
        
        
        btnDice2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice2.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice2.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice2.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice2.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice2.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice2.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                }
                
               switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice2.getId()); 
                
                for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                             
                
                dc.getGekozen().add(dc.getSymbool());
                
                
                
                
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
       
        
        btnDice2.setPrefSize(100, 130);
 
//dice3         
        
        btnDice3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice3.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice3.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice3.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice3.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice3.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice3.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                
                switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice3.getId()); 
                
                for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
     
        
        btnDice3.setPrefSize(100, 130);

//dice4           
        
        btnDice4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice4.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice4.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice4.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice4.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice4.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice4.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                
               switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice4.getId()); 
                
              for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
        
        
        btnDice4.setPrefSize(100, 130);

//dice5        
        
        btnDice5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice5.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice5.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice5.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice5.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice5.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice5.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                
                switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice5.getId()); 
                
               for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
               
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
        
        
       
        btnDice5.setPrefSize(100, 130);

//dice6        
        
        btnDice6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice6.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice6.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice6.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice6.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice6.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice6.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                
                switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice6.getId()); 
                
                for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
        
        
       
        btnDice6.setPrefSize(100, 130);
        
        
//dice7        
        btnDice7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice7.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice7.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice7.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice7.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice7.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice7.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                        btnStop.setDisable(false);
                    }
                
               switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice7.getId()); 
                
               for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
            }
        });
        
        
        btnDice7.setPrefSize(100, 130);
        
        
//dice8        
        btnDice8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    if(btnDice8.getId() == "btnDice1"){
                        dc.setSymbool(1);
                    }
                    else if(btnDice8.getId() == "btnDice2"){
                        dc.setSymbool(2);
                    }
            
                    else if(btnDice8.getId() == "btnDice3"){
                        dc.setSymbool(3);
                    }
            
                    else if(btnDice8.getId() == "btnDice4"){
                        dc.setSymbool(4);
                    }
                    else if(btnDice8.getId() == "btnDice5"){
                        dc.setSymbool(5);
                    }
                    else if(btnDice8.getId() == "btnDice6"){
                        dc.setSymbool(6);
                        
                    }
                
                
                lblScoreCurrentPlayer.setText(String.format("%d", dc.berekenScore()));
                if(dc.berekenScore() >= 21){
                btnStop.setDisable(false);
                }
                
             switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
                IDdbl.setId(btnDice8.getId()); 
                
               for(int i = 0; i < btnDices.size(); i++){
                    if(IDdbl.getId() == btnDices.get(i).getId()){
                        btnDices.get(i).setDisable(true);
                        btnDices.get(i).setId("btnDiceDisabled");
                        btnDices.remove(btnDices.get(i));
                    }
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
                
         
                for(int i = 0; i < btnDices.size(); i++){
                    btnDices.get(i).setId("btnDiceDisabled");
                    btnDices.get(i).setDisable(true);
                }
                
                if(dc.berekenAantalDobbelsteen() == 0){
                    btnGooi.setDisable(true);
                }
                
                dc.getGekozen().add(dc.getSymbool());
                
                // controle vr worm in worp     !gekozen.contains(6) dan tegel verloren en volgende zijn beurt
                // nodige resets
                dc.getGeworpen().clear();
                
            }
        });
        
        for(int k=0;k<btnDices.size();k++){
            if(IDdbl.getId()==btnDices.get(k).getId()){
                btnDices.remove(btnDices.get(k));
            }
        }
            
        
        btnDice8.setPrefSize(100, 130);
        

//btns Gooi en Stop ----------------------------------

//btnGooi
 
       
             //  HBox dices=new HBox();
             
        /*btnGooi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
             
        
                  
           
                dc.rolDobbelsteen();
                
              switch(dc.berekenAantalDobbelsteen()){
                        case 0: lblAantalDblOver.setId("lblAantalDblOver0");
                                break;
                        case 1: lblAantalDblOver.setId("lblAantalDblOver1");
                                break;
                        case 2: lblAantalDblOver.setId("lblAantalDblOver2");
                                break;
                        case 3: lblAantalDblOver.setId("lblAantalDblOver3");        
                                break;
                        case 4: lblAantalDblOver.setId("lblAantalDblOver4");
                                break;
                        case 5: lblAantalDblOver.setId("lblAantalDblOver5");
                                break;
                        case 6: lblAantalDblOver.setId("lblAantalDblOver6");
                                break;
                        case 7: lblAantalDblOver.setId("lblAantalDblOver7");
                                break;
                        case 8: lblAantalDblOver.setId("lblAantalDblOver8");
                                break;
                    }
                
            //System.out.printf("%s",dc.getGeworpen().toString());
                
       /*          for (int k = 1; k < 7; k++) {
                    System.out.printf(" %n" + k + ": " + dc.getZijde()[k]);
                    
                }
                 Scanner input = new Scanner(System.in);
                 System.out.printf("%n%nKies symbool gegooide dobbelsteen: ");
                dc.setSymbool(input.nextInt());
                
                
                  System.out.printf("%nAantal Dobbelstenen over: " + dc.berekenAantalDobbelsteen());
                  dc.getGeworpen().clear();
                  dc.rolDobbelsteen();
                  System.out.printf("%s",dc.getGeworpen().toString());
                
                 for (int k = 1; k < 7; k++) {
                    System.out.printf(" %n" + k + ": " + dc.getZijde()[k]);
                    
                }
                
                 System.out.printf("%n%nKies symbool gegooide dobbelsteen: ");
                dc.setSymbool(input.nextInt());
                
                System.out.printf("%nAantal Dobbelstenen over: " + dc.berekenAantalDobbelsteen());
                  
                  
                //show berekenAantalDobbelsteen vanboven in wit vakje
                
             //opnieuw coderen want hier worden de aantal dobbelstenen over random weergegeven 
             //AANTAL DOBBELSENEN WORDT OOK NEGATIEF NA ELK GOOI BEURT
            
             ////////////////////////////////////////////////////////////////////////////////////////////////////////
          for(int b=0; b< dc.berekenAantalDobbelsteen(); b++){
                
                    switch(dc.getGeworpen().get(b)){
                        case 1: btnDices.get(b).setId("btnDice1");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(1)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 2: btnDices.get(b).setId("btnDice2");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(2)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 3: btnDices.get(b).setId("btnDice3");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(3)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 4: btnDices.get(b).setId("btnDice4");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(4)){
                                    btnDices.get(b).setDisable(true);
                                //break;  
                                }
                               break; 
                        case 5: btnDices.get(b).setId("btnDice5");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(5)){
                                    btnDices.get(b).setDisable(true);
                                
                                }
                               break;
                        case 6: btnDices.get(b).setId("btnDice6");
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(6)){
                                    btnDices.get(b).setDisable(true);
                                
                                }
                               break;
                    }
                }
            
                System.out.printf("%d",dc.berekenAantalDobbelsteen());
                if(dc.getGekozen().containsAll(dc.getGeworpen())){
                    lblAantalDblOver.setId("lblAantalDblOver0");
                    btnGooi.setDisable(true);
                    btnStop.setDisable(true);
                }
            }
        });
   
        btnGooi.setId("btnGooi");
        btnGooi.setPrefSize(200, 50);  */
        
 //btnStop            
              
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                    btnDices.add(btnDice1);
                    btnDices.add(btnDice2);
                    btnDices.add(btnDice3);
                    btnDices.add(btnDice4);
                    btnDices.add(btnDice5);
                    btnDices.add(btnDice6);
                    btnDices.add(btnDice7);
                    btnDices.add(btnDice8);
                    dc.resetAantalDobbelsteen();
                    dc.resetScore();
                    dc.getGekozen().clear();
                    dc.getGeworpen().clear();
            }
        });
        
        btnStop.setId("btnStop");
        btnStop.setPrefSize(200, 50); 
        

        
        
//Alligning ********************************************************************
        
     
        btnSaveAndQuit.setAlignment(Pos.CENTER_RIGHT);
        lblAantalDblOver.setAlignment(Pos.BOTTOM_CENTER);
        lblOutputGame.setAlignment(Pos.CENTER_LEFT);
        info.getChildren().addAll(lblOutputGame, lblAantalDblOver, btnSaveAndQuit, btnNieuwSpel);
        throwOrStop.getChildren().addAll(btnGooi, btnStop);
                tileRow.getChildren().addAll(btnTegel21, btnTegel22, btnTegel23, btnTegel24, btnTegel25, btnTegel26, btnTegel27, btnTegel28, btnTegel29, btnTegel30, btnTegel31, btnTegel32, btnTegel33, btnTegel34, btnTegel35, btnTegel36);

        
      
        
        
        bckgrndLeft.getChildren().addAll(gpLeft); // buttons random nummers geven en adhv die nummers id linken
      /*  gpCenter.add(btnDice1, 0, 0);
        
        gpCenter.add(btnDice2, 1, 1);
        gpCenter.add(btnDice3, 2, 0);
        gpCenter.add(btnDice4, 3, 1);
        gpCenter.add(btnDice5, 4, 0);
        gpCenter.add(btnDice6, 0, 3);
        gpCenter.add(btnDice7, 2, 3);
        gpCenter.add(btnDice8, 4, 3);
*/
        
       // gpCenter.getColumnConstraints().add(new ColumnConstraints(200));
        //gpCenter.getRowConstraints().add(new RowConstraints(300));
         for(int i=0;i<btnDices.size();i++){
                      
                      
                      gpCenter.add(btnDices.get(i),i,0);
             
       
        
                       }
        //throwOrStop.getChildren().addAll(btnGooi, btnStop);
        
        vboxMiddle.getChildren().addAll(gpCenter, throwOrStop);
        
        //gpRight.add(lblSpeler1, 0, 0);
        //gpRight.add(btnUpperTileSpeler1, 0, 1); // bovensteTegel van een player maar voorlopig gebruiken we dit als tijdelijke replacement
        // met for loop aantalspelers in de spelersarraylist doorlopen om dan via die weg aan gpRight de naam en upperTile te adden
        
        
        
        
        bckgrndRight.getChildren().addAll(gpRight);
        
        //tileRow.getChildren().addAll(btnTegel21, btnTegel22, btnTegel23, btnTegel24, btnTegel25, btnTegel26, btnTegel27, btnTegel28, btnTegel29, btnTegel30, btnTegel31, btnTegel32, btnTegel33, btnTegel34, btnTegel35, btnTegel36);
        
        tileRow.setSpacing(10);
        tileRow.setPadding(new Insets(5));
        tileRow.setAlignment(Pos.CENTER);
        
        throwOrStop.setAlignment(Pos.BOTTOM_CENTER);
        gpCenter.setAlignment(Pos.CENTER);
        vboxMiddle.setAlignment(Pos.CENTER);
        vboxMiddle.setPadding(new Insets(5,5,5,5));
        gpCenter.setHgap(5);
        gpCenter.setVgap(5);
        
        gpCenter.setPadding(new Insets(50,5,0,5));
        
        throwOrStop.setPadding(new Insets(100,5,20,5));
        
        info.setSpacing(600);
        info.setPadding(new Insets(30,15,0,15));
        info.setAlignment(Pos.CENTER);
        
        
        
        gpLeft.setHgap(20);
        gpLeft.setVgap(5);
        
        gpLeft.setPadding(new Insets(150, 5, 5, 50));
        gpRight.setPadding(new Insets(50, 20, 5, 75));
        
        gpRight.setHgap(20);
        gpRight.setVgap(5);
        
       
        
          
                        
        setTop(info);
        setLeft(bckgrndLeft);
        setCenter(vboxMiddle);
        setRight(bckgrndRight);
        setBottom(tileRow);
        bckgrndRight.setPadding(new Insets(15, 20, 100, 5));
        bckgrndLeft.setPadding(new Insets(5, 5, 100, 5));
        
        
    }
    
    
    
    
   /* private void btnNieuwSpelOnAction(ActionEvent event)
    {
        WinnaarScherm ws = new WinnaarScherm(sts, this, wormenWinnaar, winnaar, dc);
        Scene scene = new Scene(ws);
        Stage stage = (Stage) this.getScene().getWindow();
        
        stage.setScene(scene);
      //stage.setMaximized(true);
        stage.show();
         Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2); 
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);  
        
       
    }*/

    
    }
    
     
    
    
    


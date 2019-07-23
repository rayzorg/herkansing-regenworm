/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author bjorn
 */
public class SpelersInfoSettings extends BorderPane{
    
    private final int aantalSpelers;
    private final DomeinController dc;
    private final SpelersSettings login; 
    private final Startscherm sts;
    
    
    
    public SpelersInfoSettings(Startscherm sts, int aantalSpelers, SpelersSettings login, DomeinController dc) // login???
    {
        this.sts = sts;
        this.aantalSpelers = aantalSpelers;
        this.login = login;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui() 
    {
        
//Panes/Boxes ******************************************************************        
        getStylesheets().add("/css/spelersinfosettings.css");
        GridPane gpane = new GridPane();
        VBox vbox = new VBox();
        HBox bottom = new HBox();
        BorderPane bp = new BorderPane();
        
        
        
        
//Labels ***********************************************************************        
        
       Label lblSpelers = new Label("Spelers");
        lblSpelers.setId("lblSpelers");

        Button btnNext = new Button();

        int g = 0;
        for (int aantal = 0; aantal < aantalSpelers; aantal++) {

            DatePicker datePicker = new DatePicker();
            DatePicker datePicker2 = new DatePicker();

            datePicker.getEditor().setDisable(true);
            datePicker.setDayCellFactory(picker -> new DateCell() {
                @Override
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) > 0);

                }
            });
            Label lblSpeler1Naam = new Label(String.format("naam speler %d", aantal + 1));//naam1

            lblSpeler1Naam.setId("speler");

            TextField txfNaam1 = new TextField();

            Label lblSpeler1Gbd = new Label(String.format("geboortedatum")); //gbd1
            Label lblSpeler1Gbd2 = new Label(String.format("geboortedatum")); //gbd1

            lblSpeler1Gbd.setId("Gbd");

            gpane.add(lblSpeler1Naam, g, aantal);// var, kollom, rij
            gpane.add(txfNaam1, g + 1, aantal);
            gpane.add(lblSpeler1Gbd, g + 2, aantal);
            gpane.add(datePicker, g + 3, aantal);

            datePicker.valueProperty().addListener((v, oldValue, newValue) -> {

                int berekenAantalDobbelsteen = 8;
                int result = 0;
                int totaalScoreSpeler = 0;
                ArrayList<Integer> eigenStapel = new ArrayList<>();

                int aantalWormen = 0;

                LocalDate dob = LocalDate.parse(datePicker.getValue().toString());

                LocalDate curDate = LocalDate.now();
                Period.between(dob, curDate).getYears();
                result = Period.between(dob, curDate).getYears();

                dc.spelerInArrayToevoegen(txfNaam1, aantalWormen, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, aantalWormen);

            });

            btnNext.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    boolean waar;

                    geefSpelersVoor();
                    btnNextOnAction( event);
                }
            });
            btnNext.setId("btnNext");
            btnNext.setPrefSize(100, 100);

        }

        Button btnBack = new Button();
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) getScene().getWindow();
                stage.setScene(login.getScene());
            }
        });
        btnBack.setId("btnBack");
        btnBack.setPrefSize(100, 100);

        vbox.getChildren().addAll(lblSpelers, gpane); 
        bottom.getChildren().addAll(btnBack, btnNext);
        
        
        
        
        
        
        lblSpelers.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        
        
        lblSpelers.setPadding(new Insets(105,0,0,0));
        
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(10,0,0,0));
        gpane.setHgap(10);
        gpane.setVgap(10);
        
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.setPadding(new Insets(15));
        bottom.setSpacing(15);
        
        bp.setCenter(vbox); 
        
        bp.setBottom(bottom);
        this.setCenter(bp);
        
    }
    
    
    public void geefSpelersVoor() {
        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
            System.out.printf(" De spelers zijn : %s ", dc.getSpelersArrayList().get(spelers).toString());
        }
    }
    
    private void btnNextOnAction(ActionEvent event)
    {
        SpelOverzicht so = new SpelOverzicht(sts, dc);
        Scene scene = new Scene(so);
        
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        
         Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2); 
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);  
        
    }
     
}

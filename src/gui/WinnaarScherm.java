/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.highscoreSpeler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import persistentie.HighscoresMapper;

/**
 *
 * @author bjorn
 */
public class WinnaarScherm extends BorderPane {

    private final DomeinController dc;
    private final Tafel tafel;

    private final Startscherm sts;
    private int wormenWinnaar;
    private int winnaar;

    public WinnaarScherm(Startscherm sts, Tafel tafel, DomeinController dc) // login???
    {

        this.sts = sts;
        this.tafel = tafel;
        this.dc = dc;
        buildGui();
    }

    private void buildGui() {
        getStylesheets().add("/css/winnaarscherm.css");
        int highestScore = 0;

        BorderPane bp = new BorderPane();
        HBox hbox = new HBox();
        HBox hbox2 = new HBox();

        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {

            if (dc.getSpelersArrayList().get(spelers).berekenAantalWormen() == highestScore) {
                if (Integer.parseInt(dc.getSpelersArrayList().get(spelers).getStapel2().peek().getId())
                        > (Integer.parseInt(dc.getSpelersArrayList().get(winnaar).getStapel2().peek().getId()))) {
                    highestScore = dc.getSpelersArrayList().get(spelers).berekenWormen();
                    winnaar = spelers;
                } else {
                    highestScore = dc.getSpelersArrayList().get(winnaar).berekenWormen();
                }
            } else if (dc.getSpelersArrayList().get(spelers).berekenWormen() > highestScore) {
                highestScore = dc.getSpelersArrayList().get(spelers).berekenWormen();
                winnaar = spelers;

            }
        }

        // label vr de winnaar
        Label lblWinnaar = new Label(String.format("De  winnaar is: %s met een score van %d wormen!!!", dc.getSpelersArrayList().get(winnaar).getTxfNaam1().getText(), highestScore));
        dc.getWinnaars().add(dc.getSpelersArrayList().get(winnaar));
        HashMap<String, highscoreSpeler> spelers = HighscoresMapper.geefScore();

        boolean bSpelerAdded = false;
        for (String i : spelers.keySet()) {

            if (spelers.get(i).getHighscore() < dc.getWinnaars().get(0).berekenWormen()) {
                if (spelers.get(i).getNaam().equals(dc.getWinnaars().get(0).getTxfNaam1().getText())) {
                    HighscoresMapper.updateScore(dc.getWinnaars().get(0).getTxfNaam1().getText(), dc.getWinnaars().get(0).berekenWormen(), spelers.get(i).getNaam());
                    bSpelerAdded = true;
                } else {
                    HighscoresMapper.insertScore(dc.getWinnaars().get(0).getTxfNaam1().getText(), dc.getWinnaars().get(0).berekenWormen());
                }

            }

        }
        if (spelers.size() < 10 && !bSpelerAdded) {
            {
                HighscoresMapper.insertScore(dc.getWinnaars().get(0).getTxfNaam1().getText(), dc.getWinnaars().get(0).berekenWormen());
            }

        }

       
        lblWinnaar.setId("lblWinnaar");

        Button btnOpnieuwSpelen = new Button();
        btnOpnieuwSpelen.setId("btnOpnieuwSpelen");
        Button btnNieuwSpel = new Button();
        btnNieuwSpel.setId("btnNieuwSpel");

        btnOpnieuwSpelen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnOpnieuwSpelenOnAction(ae);
            }
        });

        btnOpnieuwSpelen.setPrefSize(220, 50);

        btnNieuwSpel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnNieuwSpelOnAction(ae);
            }
        });

        btnNieuwSpel.setPrefSize(220, 50);

        lblWinnaar.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        lblWinnaar.setPadding(new Insets(150, 0, 0, 0));

        hbox.getChildren().addAll(lblWinnaar);

        hbox2.getChildren().addAll(btnOpnieuwSpelen, btnNieuwSpel);

        btnOpnieuwSpelen.setPadding(new Insets(0, 0, 50, 0));
        btnNieuwSpel.setPadding(new Insets(0, 0, 50, 0));

        hbox2.setAlignment(Pos.CENTER);

        hbox2.setSpacing(15);

        bp.setBottom(hbox2);
        bp.setTop(hbox);
        this.setCenter(bp);

    }

    private void btnOpnieuwSpelenOnAction(ActionEvent event) {
        Tafel tafel = new Tafel(sts, dc);
        Scene scene = new Scene(tafel);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);

        stage.show();
    }

    private void btnNieuwSpelOnAction(ActionEvent event) {
        Startscherm sts = new Startscherm(dc);
        Scene scene = new Scene(sts, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);

        stage.show();
    }

}

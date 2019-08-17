/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.util.Collections;
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
        System.out.printf("de spelers zijn");
        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
            System.out.printf("speler %s met een score van %d %n", dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText(), dc.getSpelersArrayList().get(spelers).getStapel2().isEmpty() ? 0 : dc.getSpelersArrayList().get(spelers).berekenWormen());
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
        Label lblWinnaar = new Label(String.format("De grote winnaar is: %s met een score van %d wormen!!!", dc.getSpelersArrayList().get(winnaar).getTxfNaam1().getText(), highestScore));
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

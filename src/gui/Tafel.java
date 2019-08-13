package gui;

import domein.DomeinController;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Tafel extends BorderPane {

    private final Startscherm sts;
    private final DomeinController dc;
    private final int aantalTegels = 16;
    private ArrayList<Button> tegels;
    private ArrayList<Button> btnDices;
    private ArrayList<Integer> idDobbels;
    private final int dobbelstenenAantal = 8;
    private DropShadow shadow = new DropShadow();
    private int gooi;
    private Button nieuw;
    private int item;
    private Button item2;
    private int theSteal = 0;
    private int victim = 0;

    private int g = 0;
    private boolean nietAllemaalLeeg = false;
    private boolean tegelInRij = false;
    private boolean lagereTegel = false;
    private boolean steal = false;
    private boolean perfectGedobbeld = false;

    public Tafel(Startscherm sts, DomeinController dc) // login???
    {
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }

    private void buildGui() {
        getStylesheets().add("/css/speloverzicht.css");
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

        Label lblOutputGame = new Label();
        lblOutputGame.setId("lblOutputGame");

        lblOutputGame.setPrefSize(300, 100);

        Label lblAantalDblOver = new Label();
        lblAantalDblOver.setId("lblAantalDblOver8");
        lblAantalDblOver.setPrefSize(200, 125);

        ArrayList<Button> btnUpperTilesPlayers = new ArrayList<>(); // op basis van het aantal spelers aan deze array de upper tile buttons toevoegen
        Button btnStop = new Button();
        Button btnGooi = new Button();
        Button btnNieuwSpel = new Button();
        Button btnSaveAndQuit = new Button();

        Label lblCurrentPlayer = new Label();
        Label lblScoreCurrentPlayer = new Label();

        dc.eersteSpeler();

        lblCurrentPlayer.setText(String.format("huidige speler : %n %s", dc.getSpelerAanBeurt().getTxfNaam1().getText())); // voor in Leftgp te zetten

        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
            Label lblSpeler1 = new Label(dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText());
            gpRight.add(lblSpeler1, g, spelers);

            Button btnUpperTileSpeler1 = new Button();

            btnUpperTileSpeler1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent ae) {
                    // btnUpperTileSpeler1OnAction(ae);
                }
            });

            btnUpperTileSpeler1.setId("btnUpperTileSpeler1");
            btnUpperTileSpeler1.setPrefSize(100, 160);
            btnUpperTilesPlayers.add(btnUpperTileSpeler1);
            gpRight.add(btnUpperTileSpeler1, g + 1, spelers);

        }

        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {

                for (int i = 0; i < btnDices.size(); i++) {
                    btnDices.get(i).setId("10");
                }

                
                //for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
                if (!dc.getSpelerAanBeurt().getStapel2().isEmpty()) {
                    Button btnUpperTileSpeler1 = dc.getSpelerAanBeurt().getStapel2().peek();

                    btnUpperTileSpeler1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent ae) {
                            // btnUpperTileSpeler1OnAction(ae);
                        }
                    });

                    btnUpperTileSpeler1.setId(dc.getSpelerAanBeurt().getStapel2().peek().getId());
                    btnUpperTileSpeler1.setPrefSize(100, 160);
                    btnUpperTilesPlayers.add(btnUpperTileSpeler1);
                    gpRight.add(btnUpperTileSpeler1, g + 1, 0);
                }
                //}
                dc.resetScore();
                dc.resetAantalDobbelsteen();
                dc.getGekozen().clear();
                dc.getGeworpen().clear();

                dc.volgendeSpeler();
                aanmaakDobbelstenen();
                System.out.printf("%n %d", btnDices.size());
                lblCurrentPlayer.setText(String.format("huidige speler : %n %s", dc.getSpelerAanBeurt().getTxfNaam1().getText()));

                lblScoreCurrentPlayer.setText(String.format("score : %d", dc.berekenScore()));
                for (int i = 0; i < btnDices.size(); i++) {
                    gpCenter.add(btnDices.get(i), i, 0);

                }

            }
        });

        btnStop.setId("btnStop");
        btnStop.setPrefSize(200, 50);
        btnStop.setDisable(true);

        //Button btnGooi = new Button();
        btnGooi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dc.rolDobbelsteen();

                for (int b = 0; b < btnDices.size(); b++) {

                    switch (dc.getGeworpen().get(b)) {

                        case 1:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                        case 2:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                        case 3:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                        case 4:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                        case 5:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                        case 6:
                            btnDices.get(b).setId("" + dc.getGeworpen().get(b));
                            btnDices.get(b).setDisable(false);

                            break;
                    }
                    System.out.printf("  %d", Integer.parseInt(btnDices.get(b).getId()));

                }
                ;

                /////////////////////////////////////
                if (dc.getGekozen().containsAll(dc.getGeworpen())) {
                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
                    fail.setHeaderText("POP UP");
                    fail.setContentText(" Jammer, alles werd al is gepakt!  Je zal een tegel verliezen als je er al hebt.");
                    fail.showAndWait();
                    /* for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
                            if (!dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).isEmpty()) {

                                item = dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).size();
                                nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).get(((item - 1)));
                                //bovenste tegel checken
                                item2 = dc.getTegelStapel().size();
                                int nieuw2 = dc.getTegelStapel().get(item2 - 1);

                                /*try {
                                if (!dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).toString().isEmpty()) {
                                    System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(spelers).getNaamSpeler(), (Integer) nieuw);

                                }
                            } catch (IndexOutOfBoundsException e) {

                            }
                                if (nieuw > nieuw2) {
                                    dc.getTegelStapel().add((Integer) nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).remove((Integer) nieuw);
                                } else {
                                    dc.getOmgedraaideTegels().add((Integer) nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(spelers)).remove((Integer) nieuw);
                                }
                                //einde checken
                            }

                            //System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                            dc.resetAantalDobbelsteen();
                            dc.resetScore();
                            dc.getGekozen().clear();
                            dc.getGeworpen().clear();

                            ////volgende beurt
                            //break;
                        }*/
                }
                //volgende if statement spel

            }

        });
        btnGooi.setId("btnGooi");
        btnGooi.setPrefSize(200, 50);

        ////////////////////////////////////////////////////////
        // Button btnNieuwSpel = new Button();
        btnNieuwSpel.setId("btnNieuwSpel");
        btnNieuwSpel.setPrefSize(220, 50);

        btnNieuwSpel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnNieuwSpelOnAction(ae);
            }
        });

        btnSaveAndQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                // btnSaveAndQuitOnAction(ae);
            }
        });

        btnSaveAndQuit.setId("btnSaveAndQuit");
        btnSaveAndQuit.setPrefSize(220, 50);
//////////////////////////////////////////////////////////////////

        aanmaakTegels();
        disableTegels();
        aanmaakDobbelstenen();
        disableDobbelstenen();

        for (int z = 0; z < btnDices.size(); z++) {

            btnDices.get(z).setOnAction(e -> {

                Node source = (Node) e.getSource();

                dc.setSymbool(Integer.parseInt(source.getId()));

                /////////////////////////////////
                if (dc.getGekozen().contains(dc.getSymbool())) {
                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
                    fail.setHeaderText("KAN NIET");
                    fail.setContentText("je hebt deze dobbelsteen al gepakt!");
                    fail.showAndWait();

                }

                if (!dc.getGekozen().contains(dc.getSymbool())) {

                    dc.getGekozen().add(dc.getSymbool());
                    System.out.printf("%n de gekozen dobbels zijn : %s", dc.getGekozen().toString());
                    System.out.printf("%n de score is :%d", dc.berekenScore());
                    System.out.printf(" %n #dobbels is: %d", dc.berekenAantalDobbelsteen());
                    System.out.printf("%n de size is : %d", btnDices.size());

                    lblScoreCurrentPlayer.setText(String.format("score : %d", dc.berekenScore()));

                    if (dc.berekenScore() >= 21) {
                        btnStop.setDisable(false);
                        for (int i = 0; i < tegels.size(); i++) {
                            tegels.get(i).setDisable(false);

                        }
                    }
                    for (int i = 0; i < btnDices.size(); i++) {

                        if (btnDices.get(i).getId().equals(source.getId())) {

                            gpCenter.getChildren().remove(btnDices.get(i));
                            btnDices.remove(btnDices.get(i));
                            if (btnDices.size() != dc.berekenAantalDobbelsteen() && btnDices.get(i).getId().equals(source.getId())) {
                                gpCenter.getChildren().remove(btnDices.get(i));
                                btnDices.remove(btnDices.get(i));
                            }

                        }

                    }

                }

            });

        }

        ////////////////////////////////////////////////////////
        for (int i = 0; i < tegels.size(); i++) {
            tegels.get(i).setOnAction(e -> {
                Node tegelId = (Node) e.getSource();
                System.out.printf("%n %d", Integer.parseInt(tegelId.getId()));

                if (dc.getGekozen().contains(6)) {
                    /*for (int b = 0; b < dc.getSpelersArrayList().size(); b++) {
                                if (!dc.eigenStapel(dc.getSpelersArrayList().get(b)).isEmpty()) {
                                    nietAllemaalLeeg = true;
                                }
                            }
                            if (nietAllemaalLeeg == true) {

                                for (int j = 0; j < dc.getSpelersArrayList().size(); j++) {
                                    if (!dc.eigenStapel(dc.getSpelersArrayList().get(j)).isEmpty()) {
                                        int itemVanI = dc.eigenStapel(dc.getSpelersArrayList().get(j)).size();//
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(j)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(j)).get((Integer) item - 1);
                                        if (dc.eigenStapel(dc.getSpelersArrayList().get(j)).isEmpty()) {//
                                            if (nieuw == dc.berekenScore()) {
                                                steal = true;
                                                theSteal = nieuw;
                                                victim = j;
                                            }
                                        } else if (nieuw == dc.berekenScore() && nieuw != dc.eigenStapel(dc.getSpelersArrayList().get(j)).get((Integer) itemVanI - 1)) {//
                                            steal = true;
                                            theSteal = nieuw;
                                            victim = j;
                                        }
                                    }

                                }
                            }

                            for (int teg1 : dc.getTegelStapel()) {
                                if (teg1 == dc.berekenScore()) {
                                    tegelInRij = true;
                                }
                            }

                            for (int teg2 : dc.getTegelStapel()) {
                                if (teg2 < dc.berekenScore()) {
                                    lagereTegel = true;
                                }
                            }

                            if (tegelInRij == false && steal == false && lagereTegel == false) {
                                Alert fail = new Alert(Alert.AlertType.INFORMATION);
                                fail.setHeaderText("SPIJTIG");
                                fail.setContentText("Maar jammer, er is geen enkele tegel beschikbaar die voldoet aan jouw score. en je zal een tegel verliezen als je er al hebt!");
                                fail.showAndWait();
                                if (!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()) {

                                    item = dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                    nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer) item - 1);
                                    //bovenste tegel checken
                                    item2 = dc.getTegelStapel().size();
                                    int nieuw2 = dc.getTegelStapel().get((Integer) item2 - 1);

                                    /* try{
                                        if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                            System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                           
                                        }
                                    }catch(IndexOutOfBoundsException e){
                            
                                    }
                                    if (nieuw > nieuw2) {
                                        dc.getTegelStapel().add((Integer) nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer) nieuw);
                                    } else {
                                        dc.getOmgedraaideTegels().add((Integer) nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer) nieuw);
                                    }
                                    //einde checken
                                }
                                //einde checken
                            } else if (tegelInRij == true) {

                                System.out.printf("%n%nTegelrij: %n%s%n", dc.getTegelStapel().toString());
                                for (int tegels = 0; tegels < dc.getSpelersArrayList().size(); tegels++) {
                                    if (!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()) {
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer) item - 1);

                                        System.out.printf("%nBovenste tegel %s : %d", dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else {
                                        System.out.printf("%nBovenste tegel %s : leeg", dc.getSpelersArrayList().get(tegels).getNaamSpeler());

                                    }
                                }

                                
                                dc.setKiesTegel(Integer.parseInt(tegelId.getId()));

                                if (dc.getKiesTegel() > dc.berekenScore() || !dc.getTegelStapel().contains(dc.getKiesTegel())) {
                                   Alert fail = new Alert(Alert.AlertType.INFORMATION);
                                   fail.setHeaderText("SPIJTIG");
                                   fail.setContentText("Je moet een tegel nemen die lager of gelijk is aan uw score.!");
                                   fail.showAndWait();
                                     dc.setKiesTegel(Integer.parseInt(tegelId.getId()));
                                }
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer) dc.getKiesTegel());
                                  //dc.getTegelStapel().remove((Integer) dc.getKiesTegel());
                                tegels.remove( dc.getKiesTegel());
                            } else if (steal == true) {
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());

                                for (int tegels = 0; tegels < dc.getSpelersArrayList().size(); tegels++) {
                                    if (!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()) {
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer) item - 1);

                                        System.out.printf("%nBovenste tegel %s : %d", dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else {
                                        System.out.printf("%nBovenste tegel %s : leeg", dc.getSpelersArrayList().get(tegels).getNaamSpeler());

                                    }
                                }

                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                 dc.setKiesTegel(Integer.parseInt(tegelId.getId()));
                                while (dc.getKiesTegel() > dc.berekenScore() || dc.getKiesTegel() < 21) {
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                    dc.setKiesTegel(Integer.parseInt(tegelId.getId()));
                                }

                                if (dc.getKiesTegel() == theSteal) {
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer) dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer) dc.getKiesTegel());
                                } else {
                                    while (!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore()) {
                                        System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                        dc.setKiesTegel(Integer.parseInt(tegelId.getId()));
                                    }
                                    if (dc.getKiesTegel() == theSteal) {
                                        System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                        dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer) dc.getKiesTegel());
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer) dc.getKiesTegel());
                                    } else {
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer) dc.getKiesTegel());
                                          //dc.getTegelStapel().remove((Integer) dc.getKiesTegel());
                                tegels.remove( dc.getKiesTegel());
                                    }
                                }
                            } else*/

                    for (int tegel = 0; tegel < tegels.size(); tegel++) {
                        if (tegel < dc.berekenScore()) {
                            lagereTegel = true;
                        }
                    }
                    if (lagereTegel == true) {

                        dc.setKiesTegel(Integer.parseInt(tegelId.getId()));
                        if (!tegels.contains(e.getSource()) || dc.getKiesTegel() >= dc.berekenScore()) {
                            Alert fail = new Alert(Alert.AlertType.INFORMATION);
                            fail.setHeaderText("SPIJTIG");
                            fail.setContentText("Je moet een tegel nemen die beschikbaar is en lager of gelijk is aan uw score.");
                            fail.showAndWait();

                        }

                        for (int k = 0; k < tegels.size(); k++) {
                            if (tegels.get(k).equals(e.getSource())) {

                                dc.getSpelerAanBeurt().getStapel2().add((Button) e.getSource());
                            }
                        }
                        System.out.printf("%n%d", dc.getSpelerAanBeurt().getStapel2().size());

                        System.out.printf(" %n de tegel bij %s is : %s", dc.getSpelerAanBeurt().getTxfNaam1().getText(), dc.getSpelerAanBeurt().getStapel2().toString());
                        tegels.remove(e.getSource());
                        tileRow.getChildren().remove(e.getSource());

                        System.out.printf("%n %d", tegels.size());
                        System.out.printf("%n %s", dc.getSpelerAanBeurt().getStapel2().peek());

                    }

                }

            });

            tegels.get(i).setPrefSize(100, 160);

        }
        /////////////////////////////////////////////// alligning
        gpLeft.add(lblScoreCurrentPlayer, g, 1);
        gpLeft.add(lblCurrentPlayer, g, 0);
        btnSaveAndQuit.setAlignment(Pos.CENTER_RIGHT);
        lblAantalDblOver.setAlignment(Pos.BOTTOM_CENTER);
        lblOutputGame.setAlignment(Pos.CENTER_LEFT);
        info.getChildren().addAll(lblOutputGame, lblAantalDblOver, btnSaveAndQuit, btnNieuwSpel);
        throwOrStop.getChildren().addAll(btnGooi, btnStop);
        bckgrndLeft.getChildren().addAll(gpLeft);

        for (int i = 0; i < btnDices.size(); i++) {
            gpCenter.add(btnDices.get(i), i, 0);

        }

        for (int i = 0; i < tegels.size(); i++) {
            tileRow.getChildren().add(tegels.get(i));

        }

        vboxMiddle.getChildren().addAll(gpCenter, throwOrStop);
        bckgrndRight.getChildren().addAll(gpRight);
        tileRow.setSpacing(10);
        tileRow.setPadding(new Insets(5));
        tileRow.setAlignment(Pos.CENTER);

        throwOrStop.setAlignment(Pos.BOTTOM_CENTER);
        gpCenter.setAlignment(Pos.CENTER);
        vboxMiddle.setAlignment(Pos.CENTER);
        vboxMiddle.setPadding(new Insets(5, 5, 5, 5));
        gpCenter.setHgap(5);
        gpCenter.setVgap(5);

        gpCenter.setPadding(new Insets(50, 5, 0, 5));

        throwOrStop.setPadding(new Insets(100, 5, 20, 5));

        info.setSpacing(600);
        info.setPadding(new Insets(30, 15, 0, 15));
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

    private void aanmaakTegels() {
        tegels = new ArrayList<>();

        for (int indexTegels = 0; indexTegels < 17; indexTegels++) {

            tegels.add(new Button());
            tegels.get(indexTegels).setId(Integer.toString(indexTegels + 21));

            Button tegel = tegels.get(indexTegels);
            //Adding the shadow when the mouse cursor is on
            tegels.get(indexTegels).addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                tegel.setEffect(shadow);
            });
            //Removing the shadow when the mouse cursor is off
            tegels.get(indexTegels).addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                tegel.setEffect(null);
            });
        }

    }

    private void disableTegels() {
        for (int indexTegels = 0; indexTegels < tegels.size(); indexTegels++) {
            tegels.get(indexTegels).setDisable(true);
        }
    }

    private void aanmaakDobbelstenen() {
        btnDices = new ArrayList<>();

        int indexDobbelstenen = 0;

        for (indexDobbelstenen = 0; indexDobbelstenen < dobbelstenenAantal; indexDobbelstenen++) {

            btnDices.add(new Button());

            btnDices.get(indexDobbelstenen).setPrefSize(100, 130);

            Button dobbelsteen = btnDices.get(indexDobbelstenen);
            btnDices.get(indexDobbelstenen).addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                dobbelsteen.setEffect(shadow);
            });

            //Removing the shadow when the mouse cursor is off
            btnDices.get(indexDobbelstenen).addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                dobbelsteen.setEffect(null);
            });
        }

    }

    private void disableDobbelstenen() {
        for (int indexTegels = 0; indexTegels < btnDices.size(); indexTegels++) {
            btnDices.get(indexTegels).setDisable(true);
        }
    }

    private void btnNieuwSpelOnAction(ActionEvent event) {
        WinnaarScherm ws = new WinnaarScherm(sts, this, dc);
        Scene scene = new Scene(ws);
        Stage stage = (Stage) this.getScene().getWindow();

        stage.setScene(scene);
        //stage.setMaximized(true);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);

    }

}

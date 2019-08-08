
package gui;

import domein.DomeinController;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Tafel extends BorderPane {

    
    private final Startscherm sts;
    private final DomeinController dc;
    private final int aantalTegels=16;
    private ArrayList<Button> tegels;
    private ArrayList <Button> btnDices;
    private final int dobbelstenenAantal=8;
    private DropShadow shadow = new DropShadow();
    private int worp;
    
    private int g=0;
    public Tafel(Startscherm sts, DomeinController dc) // login???
    {
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){
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
        
          ArrayList <Button> btnUpperTilesPlayers =new ArrayList<>(); // op basis van het aantal spelers aan deze array de upper tile buttons toevoegen
        
        for (int spelers = 0; spelers < dc.getSpelersArrayList().size(); spelers++) {
            
            String naam=dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText();
            Label lblCurrentPlayer = new Label(String.format("huidige speler : %n %s",dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText())); // voor in Leftgp te zetten
            gpLeft.add(lblCurrentPlayer, g, 0);
            
            Label lblSpeler1 = new Label(dc.getSpelersArrayList().get(spelers).getTxfNaam1().getText());  
            Button btnUpperTileSpeler1 = new Button();
            btnUpperTilesPlayers.add(btnUpperTileSpeler1);
          
            gpRight.add(lblSpeler1, g, spelers);
            gpRight.add(btnUpperTileSpeler1, g+1, spelers); // bovensteTegel van een player maar voorlopig gebruiken we dit als tijdelijke replacement
            
        }
         Label lblScoreCurrentPlayer = new Label(String.format("Score: %d", dc.berekenScore()));
            gpLeft.add(lblScoreCurrentPlayer, g, 1);
        
       
        Button IDdbl = new Button(); // passieve knop wordt gebruikt voor een controle
        /////////////////////////////////////////////////////
       //btnStop 
        Button btnStop = new Button();
      
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                   
                    dc.resetAantalDobbelsteen();
                    dc.resetScore();
                    dc.getGekozen().clear();
                    dc.getGeworpen().clear();
            }
        });
        
        btnStop.setId("btnStop");
        btnStop.setPrefSize(200, 50); 
        btnStop.setDisable(true);
        
        Button btnGooi = new Button();
       Random rand=new Random();
       
        btnGooi.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                dc.rolDobbelsteen();
                //System.out.printf("%d",Integer.parseInt(btnDices.get(b).getId()));
                
                for(int b=0; b< btnDices.size(); b++){
                   
                     worp=(int)(6*Math.random() + 1);
                     btnDices.get(b).setId(""+dc.getGeworpen().get(b));
                        //Node source= (Node) ;
                        
                       // System.out.printf("%n%s",source.getId());
                        //dc.setSymbool(Integer.parseInt(source.getId()));
                    switch(dc.getGeworpen().get(b)){
                        
                        case 1: //btnDices.get(b).setId(""+(worp));
                     // dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(1)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 2: //btnDices.get(b).setId(""+(worp));
                       //dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(2)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 3:// btnDices.get(b).setId(""+(worp));
                       //dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(3)){
                                    btnDices.get(b).setDisable(true);
                                    
                                }
                                break;
                        case 4: //btnDices.get(b).setId(""+(worp));
                       //dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(4)){
                                    btnDices.get(b).setDisable(true);
                                break;  
                                }
                               break; 
                        case 5: //btnDices.get(b).setId(""+(worp));
                       // dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(5)){
                                    btnDices.get(b).setDisable(true);
                                
                                }
                               break;
                        case 6: //btnDices.get(b).setId(""+(worp));
                        // dc.setSymbool(Integer.parseInt(source.getId()));
                                btnDices.get(b).setDisable(false);
                                if(dc.getGekozen().contains(6)){
                                    btnDices.get(b).setDisable(true);
                                
                                }
                               break;
                    }
                    
                }
                
               // System.out.printf("%n%d",Integer.parseInt(btnDices.get(4).getId()));
              
                dc.getGeworpen().clear();
            }
            
        });
        btnGooi.setId("btnGooi");
        btnGooi.setPrefSize(200, 50);
       
        ////////////////////////////////////////////////////////
        Button btnNieuwSpel = new Button();
        btnNieuwSpel.setId("btnNieuwSpel");
        btnNieuwSpel.setPrefSize(220, 50);
        
        btnNieuwSpel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnNieuwSpelOnAction(ae);
            }
        });
        
        Button btnSaveAndQuit = new Button();
        
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
       
       
       
       for( int z=0;z<btnDices.size();z++){
          
                    btnDices.get(z).setOnAction(e -> {
                        
                        Node source= (Node) e.getSource();
                       
                        dc.setSymbool(Integer.parseInt(source.getId()));
                        System.out.printf("%n symbool is : %d",dc.getSymbool());
                        
                        dc.getGekozen().add(Integer.parseInt(source.getId()));
                        
                        System.out.printf("%n de score is :%d",dc.berekenScore());
                       // btnDices.get(dc.getGekozen().get(Integer.parseInt(source.getId()))).setDisable(true);
                        
                    }) ;
           
        
                  
                }
       
        btnSaveAndQuit.setAlignment(Pos.CENTER_RIGHT);
        lblAantalDblOver.setAlignment(Pos.BOTTOM_CENTER);
        lblOutputGame.setAlignment(Pos.CENTER_LEFT);
        info.getChildren().addAll(lblOutputGame, lblAantalDblOver, btnSaveAndQuit, btnNieuwSpel);
        throwOrStop.getChildren().addAll(btnGooi, btnStop);
        bckgrndLeft.getChildren().addAll(gpLeft);
         
        for(int i=0;i<btnDices.size();i++){
             gpCenter.add(btnDices.get(i),i,0);
            
        }
 
         for(int i=0;i<tegels.size();i++){
             tileRow.getChildren().add(tegels.get(i));
            
        }
      
        /////////////////////////////////////////////// alligning
        
        vboxMiddle.getChildren().addAll(gpCenter, throwOrStop);
        bckgrndRight.getChildren().addAll(gpRight);
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
    

 private void aanmaakTegels(){
     tegels=new ArrayList<>();
     
            for(int indexTegels=0;indexTegels<aantalTegels;indexTegels++){
              
                tegels.add(new Button());
                tegels.get(indexTegels).setId("btnTegel"+ (indexTegels+21));
               
               Image db = new Image(getClass().getResourceAsStream("/img/Tile"+(indexTegels+21)+".png"));
               BackgroundSize bs = new BackgroundSize(50, 50, false, false, false, true);
               BackgroundImage b = new BackgroundImage(db, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bs);
               tegels.get(indexTegels).setBackground(new Background(b));
                
              //image werkt enkel als ik met css bestand doet en niet via backgroundimage
              
               
            tegels.get(indexTegels).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                 
            }
        });
        
       
       tegels.get(indexTegels).setPrefSize(100, 160);
       
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
          System.out.printf("%d",tegels.size());
          
        }
 private void disableTegels(){
     for(int indexTegels=0;indexTegels<tegels.size();indexTegels++){
         tegels.get(indexTegels).setDisable(true);
     }
 }
 
 private void aanmaakDobbelstenen(){
     btnDices=new ArrayList<>();
               
                
     //int waarde=indexDobbelstenen+1;
     int  indexDobbelstenen=0;
     int waarde=indexDobbelstenen+1;
     
     
     for( indexDobbelstenen=0;indexDobbelstenen<dobbelstenenAantal;indexDobbelstenen++){
         waarde=indexDobbelstenen+1;
        // worp=(int)(6*Math.random() + 1);
               btnDices.add(new Button());
               
              // btnDices.get(indexDobbelstenen).setId(""+(worp));
             // if(btnDices.get(indexDobbelstenen).getId().equals(""+(worp))){
                     //   dc.setSymbool(Integer.parseInt(btnDices.get(indexDobbelstenen).getId()));
                       // System.out.printf("%n%d",worp);
                      
                   // }
            
              
      
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
      
          /*  Image db = new Image(getClass().getResourceAsStream("/img/Dice"+(indexTegels+1)+".png"));
            BackgroundSize bs = new BackgroundSize(50, 50, false, false, false, true);
            BackgroundImage b = new BackgroundImage(db, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bs);
            btnDices.get(indexTegels).setBackground(new Background(b));
*/      
           
            
 }
 private void disableDobbelstenen(){
     for(int indexTegels=0;indexTegels<btnDices.size();indexTegels++){
        btnDices.get(indexTegels).setDisable(true);
     }
 }
 private void btnNieuwSpelOnAction(ActionEvent event)
    {
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
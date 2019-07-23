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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bjorn
 */
public class SpelersSettings extends BorderPane{

    
    private final DomeinController dc;
    private int aantalSpelers;
    private final Startscherm sts;
    
    public SpelersSettings(Startscherm sts, DomeinController dc){
        this.sts = sts;
        this.dc = dc;
        buildGui();
    }
    
    private void buildGui(){
 
// Panes/Boxes/CSS        
        getStylesheets().add("/css/spelerssettings.css");
        BorderPane keuzeSpelers = new BorderPane();
        HBox deKeuze = new HBox();
        VBox vbox = new VBox();
// Buttons
        Button btnNext = new Button();        
        Button btnCancel = new Button();
        
        
// Titel Label Spelers *************************************************************************
        
        Label lblSpelers = new Label("Spelers");
        lblSpelers.setId("lblSpelers");
        
// Label Aantal Spelers ************************************************************************
        
        Label lblAantalSpelers = new Label("Aantal");
        lblAantalSpelers.setId("lblAantalSpelers");
       
// ChoiceBox (naast lblAantalSpelers) ***********************************************************
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(2, 3, 4, 5, 6, 7));
        btnNext.disableProperty().bind(cb.valueProperty().isNull());

        
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                aantalSpelers = new_value.intValue()+2;//we spelen minstens met 2
            }
        });
        
        
// Button Next *****************************************************************************
        
        
        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                btnNextOnAction(ae);
            }
        });
        
        btnNext.setId("btnNext");
        btnNext.setPrefSize(100, 100);
        
// Button Cancel *****************************************************************************

        
        btnCancel.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent evt) 
            {
                Stage stage = (Stage) getScene().getWindow();
                stage.setScene(sts.getScene());
            }
        });
        
        btnCancel.setId("btnCancel");
        btnCancel.setPrefSize(100, 100);
        
        
        
// Alligning van de elementen   ****************************************************************  
        //deKeuze = HBox
        //vbox = VBox
        deKeuze.getChildren().addAll(lblAantalSpelers, cb, btnNext, btnCancel);
        deKeuze.setPadding(new Insets(5));
        deKeuze.setSpacing(15);
        
        vbox.setAlignment(Pos.CENTER);
        deKeuze.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(lblSpelers, deKeuze);
        keuzeSpelers.setCenter(vbox);
        this.setCenter(keuzeSpelers);
        
    }
    
    
    private void btnNextOnAction(ActionEvent event)
    {
       // aantal spelers (ingevuld op loginscherm), willen we tonen op volgend scherm
        SpelersInfoSettings sis = new SpelersInfoSettings(sts, aantalSpelers, this, dc);
        Scene scene = new Scene(sis, 1250, 700);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show(); 
        
        
    }
    
    
}

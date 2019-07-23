package main;

import gui.Startscherm;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domein.DomeinController;
import javafx.application.Application;


public class StartUpGui extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        Startscherm root = new Startscherm(new DomeinController());
        Scene scene = new Scene(root, 1250, 700);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("/css/startscherm.css");
        primaryStage.show();
        
        
        
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}

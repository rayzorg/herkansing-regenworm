package domein;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DomeinController {
/////////// Attributen etc. /////////////////////////////////////////////////////////////////////    

    private Dobbelsteen dobbelsteen;

    private String naamSpeler;
    private String date;
    private int result;
    private int berekenAantalDobbelsteen = 8;
    private int totaalScoreSpeler = 0;
    private boolean lagereTegel = false;
    private boolean steal = false;
    private int berekenAantalWormen = 0;

    private int teller = 0;
    private Speler spelerAanBeurt;
    private TextField txfNaam1 = new TextField();
    private LocalDate dob;
    private Speler spelersList[] = new Speler[7];
    public ArrayList<Speler> spelersArrayList = new ArrayList<>();

    public ArrayList<Integer> tegelStapel = new ArrayList<>();
    public ArrayList<Integer> eigenStapel = new ArrayList<>();
    public Stack<Button> stapel2 = new Stack<>();
    public Stack<Speler> winnaars = new Stack<>();
    

    private ArrayList<Integer> omgedraaideTegels = new ArrayList<>();
    private Stack<Button> tegelsOm = new Stack<>();

////////// Klasses instantieren ////////////////////////////////////////////////////////////////////    
    Speler speler = new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, stapel2, berekenAantalWormen);///als je private Speler speler; dan geeft die een nullpointerexception

////////// Methodes ////////////////////////////////////////////////////////////////////////////////    
    public DomeinController() {
        setSpelersList(spelersList);
        setSpelersArrayList(spelersArrayList);

    }

    public Stack<Speler> getWinnaars() {

        Collections.sort(winnaars, new highscore());
        return winnaars;
    }

    public class highscore implements Comparator<Speler> {

        @Override
        public int compare(Speler o1, Speler o2) {
            return Integer.compare(o1.berekenWormen(), o2.berekenWormen());
        }

    }

    public Stack<Button> getTegelsOm() {
        return tegelsOm;
    }

    public Stack<Button> getStapel2(Speler speler) {
        return speler.getStapel2();
    }

    public ArrayList<Integer> getOmgedraaideTegels() {
        return omgedraaideTegels;
    }

    public void setOmgedraaideTegels(ArrayList<Integer> omgedraaideTegels) {
        this.omgedraaideTegels = omgedraaideTegels;
    }

    /*public int getAantalWormen(){
        return speler.getAantalWormen();
    }*/
    public ArrayList<Integer> getTegelStapel() {
        return speler.getTegelStapel();
    }

    public void tegels() {
        speler.tegels();
    }

    public ArrayList<Integer> eigenStapel(Speler speler) {

        return speler.getEigenStapel();
    }

    public class RijComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }

    }

    public class AgeComparator implements Comparator<Speler> {

        @Override
        public int compare(Speler a, Speler b) {
            return Integer.compare(a.getResult(), b.getResult());
        }
    }

    public void sorteren() {
        Collections.sort(speler.getTegelStapel(), new RijComparator());
    }

    public int getResult() {
        return speler.getResult();
    }

    public void resetAantalDobbelsteen() {
        speler.resetAantalDobbelsteen();
    }

    public void resetScore() {
        speler.resetScores();
    }
///////////////

    public Speler[] getSpelersList() {
        return spelersList;
    }

    public void setSpelersList(Speler[] spelersList) {
        this.spelersList = spelersList;
    }

    public TextField getTxfNaam1() {
        return speler.getTxfNaam1();
    }

    public LocalDate getDob() {
        return speler.getDob();
    }

    public void setSpelersArrayList(ArrayList<Speler> spelersArrayList) {
        this.spelersArrayList = spelersArrayList;
    }

    public ArrayList<Speler> getSpelersArrayList() {
        return spelersArrayList;
    }

    /* public void spelerArrayAanmaken(int aantalSpelers) {

        spelersList = new Speler[aantalSpelers];
    }*/
    ////nodig om spelers af te printen anders geeft die symbolen ipv namen
    //en heeft geen invloed op output (moet kijken naar speler klasse
    //wijzigingen tov ui ;textfield,localdate
    public void spelerInArrayToevoegen(TextField txfNaam1, int aantal, LocalDate dob, int result, int berekenAantalDobbelsteen, int totaalScoreSpeler, ArrayList<Integer> eigenStapel, Stack<Button> stapel2, int berekenAantalWormen) {

        spelersArrayList.add(new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, stapel2, berekenAantalWormen));
        //spelersList[aantal] = new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, berekenAantalWormen);
        ///////////gaat hier array in volgore steken 
        Collections.sort(spelersArrayList, new AgeComparator());

    }

    public void eersteSpeler() {
        for (int i = 0; i < spelersArrayList.size(); i++) {

            spelerAanBeurt = spelersArrayList.get(0);
            ++teller;
        }
        System.out.println("before de speler teller: " + teller + "spelernaam: " + spelerAanBeurt.getTxfNaam1().getText());
    }

    public void volgendeSpeler() {

        for (Speler speler : spelersArrayList) {
            // System.out.printf(speler.getTxfNaam1().getText());  
        }
        //System.out.println("before de speler teller: "+teller+"spelernaam: "+ spelerAanBeurt.getTxfNaam1().getText());

        if (teller == 0) {
            spelerAanBeurt = spelersArrayList.get(++teller);
        } else {
            spelerAanBeurt = spelersArrayList.get(++teller % spelersArrayList.size());
        }
        //System.out.printf(" %n %d %s %n",teller,spelerAanBeurt.getTxfNaam1().getText());
        System.out.println("after de speler teller: " + teller + "spelernaam: " + spelerAanBeurt.getTxfNaam1().getText());

    }

    public Speler getSpelerAanBeurt() {
        return spelerAanBeurt;
    }

    ////////////////////////////////////////////////////////////////
    public ArrayList<Integer> getGeworpen() {

        return speler.getGeworpen();
    }

    public ArrayList<Integer> getGekozen() {
        return speler.gekozen;
    }

    public void rolDobbelsteen() {
        speler.rolDobbelsteen();
    }

    public int[] getZijde() {
        return speler.zijde;
    }

    public int getTotaalScoreSpeler() {
        return speler.getTotaalScoreSpeler();
    }

    public int berekenScore() {
        return speler.berekenScore();
    }

    public int berekenAantalDobbelsteen() {
        return speler.berekenAantalDobbelsteen();
    }

    public void setSymbool(int symbool) {
        speler.symbool = symbool;
    }

    public int getSymbool() {
        return speler.getSymbool();
    }

    public int getKiesTegel() {
        return speler.getKiesTegel();
    }

    public void setKiesTegel(int kiesTegel) {
        speler.kiesTegel = kiesTegel;
    }

    public String getDate() {
        return speler.getDate();
    }

    public String getNaamSpeler() {
        return speler.getNaamSpeler();
    }

    public int berekenAantalWormen() {
        return speler.berekenAantalWormen();
    }

    

   
}

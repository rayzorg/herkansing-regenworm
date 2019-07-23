package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.scene.control.TextField;

public class DomeinController {
/////////// Attributen etc. /////////////////////////////////////////////////////////////////////    

    private Dobbelsteen dobbelsteen;

    private String naamSpeler;
    private String date;
    private int result;
    private int berekenAantalDobbelsteen = 8;
    int totaalScoreSpeler = 0;
    public boolean lagereTegel = false;
    public boolean steal = false;
    public int berekenAantalWormen = 0;

    TextField txfNaam1 = new TextField();
    private LocalDate dob;
    public Speler spelersList[] = new Speler[7];
    public ArrayList<Speler> spelersArrayList = new ArrayList<>();

    public ArrayList<Integer> tegelStapel = new ArrayList<>();
    public ArrayList<Integer> eigenStapel = new ArrayList<>();

    public ArrayList<Integer> omgedraaideTegels = new ArrayList<>();
////////// Klasses instantieren ////////////////////////////////////////////////////////////////////    
    Speler speler = new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, berekenAantalWormen);///als je private Speler speler; dan geeft die een nullpointerexception

////////// Methodes ////////////////////////////////////////////////////////////////////////////////    
    public DomeinController() {
        setSpelersList(spelersList);
        setSpelersArrayList(spelersArrayList);

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
    public void spelerInArrayToevoegen( TextField txfNaam1, int aantal, LocalDate dob, int result, int berekenAantalDobbelsteen, int totaalScoreSpeler, ArrayList<Integer> eigenStapel, int berekenAantalWormen) {

        spelersArrayList.add(new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, berekenAantalWormen));
        //spelersList[aantal] = new Speler(txfNaam1, dob, result, berekenAantalDobbelsteen, totaalScoreSpeler, eigenStapel, berekenAantalWormen);
        ///////////gaat hier array in volgore steken 
        Collections.sort(spelersArrayList, new AgeComparator());

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

package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Speler {
/////////////////// Attributen etc. //////////////////////////////////////////////////////////////

    private ArrayList<Integer> geworpen = new ArrayList();
    public ArrayList<Integer> gekozen = new ArrayList();
    public int[] zijde = new int[7];
    private int berekenAantalWormen;
    private String naamSpeler;
    private LocalDate dob;
    private String date;
    private int result;
    private int totaalScoreSpeler = 0;
    private int berekenAantalDobbelsteen = 8;
    public int symbool;
    public int kiesTegel;
    public ArrayList<Integer> eigenStapel = new ArrayList<>();
    public Stack<Button> stapel2 = new Stack<>();
///////////////// Klasses instantieren ///////////////////////////////////////////////////////////    
    Scanner input = new Scanner(System.in);
    Dobbelsteen dobbelstenen = new Dobbelsteen();
    Tegel tegels = new Tegel();
    //private  int aantalSpelers;
    TextField txfNaam1 = new TextField();

//////////////// Methodes /////////////////////////////////////////////////////////////////////////    
    //wijzigingen tov ui ;textfield,localdate
    Speler(TextField txfNaam1, LocalDate dob, int result, int berekenAantalDobbelsteen, int totaalScoreSpeler, ArrayList<Integer> eigenStapel, Stack<Button> stapel2, int berekenAantalWormen) {
        setTxfNaam1(txfNaam1);
        setNaamSpeler(naamSpeler);
        setDob(dob);
        this.result = result;
        this.berekenAantalDobbelsteen = berekenAantalDobbelsteen;
        this.totaalScoreSpeler = totaalScoreSpeler;
        this.eigenStapel = eigenStapel;
        this.stapel2 = stapel2;
        this.berekenAantalWormen = berekenAantalWormen;
    }

    public Stack<Button> getStapel2() {
        return stapel2;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void tegels() {
        tegels.maakTegels();
    }

    public ArrayList<Integer> getTegelStapel() {
        return tegels.getTegelStapel();
    }

    public ArrayList<Integer> getEigenStapel() {
        return eigenStapel;
    }

    public void resetAantalDobbelsteen() {
        this.berekenAantalDobbelsteen = 8;
    }

    public void resetScores() {
        this.totaalScoreSpeler = 0;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getNaamSpeler() {
        return naamSpeler;
    }

    public void setNaamSpeler(String naamSpeler) {
        this.naamSpeler = naamSpeler;
    }

    public TextField getTxfNaam1() {
        return txfNaam1;
    }

    public void setTxfNaam1(TextField txfNaam1) {
        this.txfNaam1 = txfNaam1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String nieuw = "";

        nieuw += String.format(" %n --%s met als geboortedatum %s en leeftijd %d %n ", txfNaam1.getText(), dob, result);

        return nieuw;
    }

    public ArrayList<Integer> getGekozen() {
        return gekozen;
    }

    public ArrayList<Integer> getGeworpen() {
        return geworpen;
    }

    public int getSymbool() {
        return symbool;
    }

    public void setSymbool(int symbool) {
        this.symbool = symbool;
    }

    public int berekenAantalDobbelsteen() {
        int minAantal = Collections.frequency(geworpen, symbool);
        geworpen.clear();
        berekenAantalDobbelsteen = berekenAantalDobbelsteen - minAantal;

        return berekenAantalDobbelsteen;
    }

    public void rolDobbelsteen() {
        for (int b = 0; b < berekenAantalDobbelsteen; b++) {
            dobbelstenen.rol();
            geworpen.add(dobbelstenen.worp);
            zijde[dobbelstenen.worp]++;

        }
    }

    public void setZijde(int[] zijde) {
        this.zijde = zijde;
    }

    public int[] getZijde() {
        return zijde;
    }

    public int berekenScore() {
        int minAantal = Collections.frequency(geworpen, symbool);
        if (symbool < 6) {
            totaalScoreSpeler += symbool * minAantal;
        }

        if (symbool == 6) {
            totaalScoreSpeler += (symbool * minAantal) - (minAantal * 1);

        }

        zijde = new int[7];

        return totaalScoreSpeler;

    }

    public int getTotaalScoreSpeler() {
        return totaalScoreSpeler;
    }

    
    public int berekenAantalWormen() {
        berekenAantalWormen = 0;
        for (int awvs : eigenStapel) {
            switch (awvs) {
                case 21:
                case 22:
                case 23:
                case 24:
                    berekenAantalWormen += 1;
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    berekenAantalWormen += 2;
                    break;
                case 29:
                case 30:
                case 31:
                case 32:
                    berekenAantalWormen += 3;
                    break;
                case 33:
                case 34:
                case 35:
                case 36:
                    berekenAantalWormen += 4;
                    break;
            }
        }
        return berekenAantalWormen;
    }

    public int berekenWormen() {
        berekenAantalWormen = 0;
        for (int wormen = 0; wormen < stapel2.size(); wormen++) {
            switch (stapel2.get(wormen).getId()) {
                case "21":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 21) {
                        berekenAantalWormen += 1;
                    }
                    break;
                case "22":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 22) {
                        berekenAantalWormen += 1;
                    }
                    break;
                case "23":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 23) {
                        berekenAantalWormen += 1;
                    }
                    break;
                case "24":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 24) {
                        berekenAantalWormen += 1;
                    }
                    break;
                case "25":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 25) {
                        berekenAantalWormen += 2;
                    }
                    break;
                case "26":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 26) {
                        berekenAantalWormen += 2;
                    }
                    break;
                case "27":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 27) {
                        berekenAantalWormen += 2;
                    }
                    break;
                case "28":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 28) {
                        berekenAantalWormen += 2;
                    }
                    break;
                case "29":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 29) {
                        berekenAantalWormen += 3;
                    }
                    break;
                case "30":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 30) {
                        berekenAantalWormen += 3;
                    }
                    break;
                case "31":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 31) {
                        berekenAantalWormen += 3;
                    }
                    break;
                case "32":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 32) {
                        berekenAantalWormen += 3;
                    }
                    break;
                case "33":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 33) {
                        berekenAantalWormen += 4;
                    }
                    break;
                case "34":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 34) {
                        berekenAantalWormen += 4;
                    }
                    break;
                case "35":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 35) {
                        berekenAantalWormen += 4;
                    }
                    break;
                case "36":
                    if (Integer.parseInt(stapel2.get(wormen).getId()) == 36) {
                        berekenAantalWormen += 4;
                    }
                    break;

            }
        }
        return berekenAantalWormen;
    }

    public int getKiesTegel() {
        return kiesTegel;
    }

    public void setKiesTegel(int kiesTegel) {
        this.kiesTegel = kiesTegel;
    }

}

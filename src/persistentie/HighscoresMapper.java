package persistentie;

import domein.highscoreSpeler;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HighscoresMapper {

    public static HashMap<String, highscoreSpeler> geefScore() {
        try {
            //connection with DB
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "demo", "demo");

            //create statement to get name and score
            Statement myState = myConn.createStatement();

            ResultSet myRs = myState.executeQuery("select `naam`,`highScore` from `highscore` ORDER BY `highScore` DESC LIMIT 10");

            HashMap<String, highscoreSpeler> spelers = new HashMap<>();

            while (myRs.next()) {
                spelers.put(myRs.getString("naam"), new highscoreSpeler(myRs.getString("naam"), myRs.getInt("highScore")));

            }
            return spelers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int insertScore(String naam, int score) {
        try {
            //connection with DB
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "demo", "demo");

            Statement myState = myConn.createStatement();

            int aantal = myState.executeUpdate("INSERT INTO `demo`.`highscore` (`naam`, `highScore`) VALUES ('" + naam + "'," + String.valueOf(score) + " )");
            return aantal;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int updateScore(String naam, int score, String orgNaam) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "demo", "demo");

            Statement myState = myConn.createStatement();

            int aantal = myState.executeUpdate("UPDATE `demo`.`highscore` SET `naam` = '" + naam + "', `highScore` = " + String.valueOf(score) + " WHERE (`naam` = '" + orgNaam + "')");
            return aantal;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}

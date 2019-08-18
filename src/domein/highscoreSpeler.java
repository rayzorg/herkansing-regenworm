
package domein;


public class highscoreSpeler {
    private String naam;
    private int highscore;

    public highscoreSpeler(String naam, int highscore) {
        this.naam = naam;
        this.highscore = highscore;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    
    
    
}

package domein;

public class Dobbelsteen {
    public int worp;
    
    public void rol(){
        worp = (int)(6*Math.random() + 1);
    }
}
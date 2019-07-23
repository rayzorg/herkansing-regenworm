package domein;

import java.util.ArrayList;

public class Tegel {
    
///////////////// Attributen etc. /////////////////////////////////////////////////////////////////////////////    
    
    public int aantalWormen;
    public ArrayList <Integer> tegelStapel=new ArrayList<>();
///////////////// Methodes /////////////////////////////////////////////////////////////////////////////
    public void maakTegels(){
        for(int i=21;i<24;i++){
            tegelStapel.add(i);
        }
    }

    public ArrayList<Integer> getTegelStapel() {
        return tegelStapel;
    }
   
}

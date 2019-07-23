package ui;

import domein.DomeinController;
import domein.Speler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;

public class Spel{

    private final  DomeinController dc;
    
    public Spel(DomeinController dc) {
        this.dc=dc;
    }
    @SuppressWarnings("empty-statement")
    
    
    
         
    public  void speelSpel() {
        Scanner input = new Scanner(System.in);
      //  DomeinController dc=new DomeinController();
        
        int gooi;
        int nieuw;
        int item;
        int item2;
        int theSteal = 0;
        int victim = 0;
        
    
///////////////////////////////////////////////////// SPELERS AANMAKEN EN IN ARRAY STEKEN ////////////////////////////////////////////////////       
         
///////////////////////////////////////////////////// DO WHILE 1 //////////////////////////////////
      
        int aantalSpelers=spelersKiezen();
      //weggedaan want niet meer nodig
        //dc.spelerArrayAanmaken(aantalSpelers);
        maakSpelerAanInArrayList(aantalSpelers);
        System.out.printf("%nDe spelers zijn : ");
        geefSpelersVoor();

         
        dc.tegels();
        System.out.printf(" %n De stapel om het spel mee te beginnen is: ");
        System.out.println(dc.getTegelStapel());

        
        
        
        do{
         
            
            for(int i=0;i<dc.getSpelersArrayList().size();i++){
                if(dc.getTegelStapel() == null || dc.getTegelStapel().isEmpty()){
                    break;
                }
                boolean nietAllemaalLeeg = false;
                boolean tegelInRij = false;
                boolean lagereTegel = false;
                boolean steal = false;
                boolean perfectGedobbeld = false;
                ListIterator<Integer> listIterator = dc.eigenStapel(dc.getSpelersArrayList().get(i)).listIterator();
                
                System.out.printf("%n%nSpeler aan beurt: ");
                System.out.println(dc.getSpelersArrayList().get(i).getNaamSpeler());
                
               
                 
                
            do {
                System.out.printf("%n%nWorp:%n");
         
         
                dc.rolDobbelsteen();
                System.out.println(dc.getGeworpen());
        
             
                for (int k = 1; k < 7; k++) {
                    System.out.printf(" %n" + k + ": " + dc.getZijde()[k]);
                }
         
             
                if(dc.getGekozen().containsAll(dc.getGeworpen())){
                    System.out.printf("%n%nJammer, alles werd al is gepakt.");
                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                        System.out.printf("%nJe verliest een tegel.");
                                
                        item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                        nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                        //bovenste tegel checken
                        item2=dc.getTegelStapel().size();
                        int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                        try{
                            if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                               
                            }
                        }catch(IndexOutOfBoundsException e){
                            
                        }
                        
                        if(nieuw>nieuw2){
                            dc.getTegelStapel().add((Integer)nieuw);
                            dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                        }else{
                            dc.getOmgedraaideTegels().add((Integer)nieuw);
                            dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                        }
            //einde checken
                    }
                        
                        System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                        System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                        
                        for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                            } else {
                                System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                            }
                        }
                        
                        dc.resetAantalDobbelsteen();
                        dc.resetScore();
                        dc.getGekozen().clear();
                        dc.getGeworpen().clear();
                       
                       ////volgende beurt
        
                       
                        break;
                }
         
                System.out.printf("%n%nKies symbool gegooide dobbelsteen: ");
                dc.setSymbool(input.nextInt());
         
                dc.getGeworpen().clear();
        
                boolean controleGekozen3 = false;
                while(controleGekozen3 == false){
                    if(dc.getSymbool() < 1 || dc.getSymbool() > 6){
                        System.out.printf("Dit symbool bestaat niet, kies een ander symbool: ");
                        dc.setSymbool(input.nextInt());
                    }
                    else{
                        controleGekozen3 = true;
                    }
                }
        
          
                boolean controleGekozen2=false;
                while(controleGekozen2==false){
                    if(dc.getZijde()[dc.getSymbool()]==0){
                        System.out.printf("Dobbelsteen werd niet gegooid,pak ander symbool: ");
                        dc.setSymbool(input.nextInt());
                    }
                    else {
                        controleGekozen2=true;
                    }
                }
        /////////////deze dobbelsteen kan je niet pakken
                boolean controleGekozen = false;
                while(controleGekozen == false){
                    if(dc.getGekozen().contains(dc.getSymbool()) | dc.getZijde()[dc.getSymbool()]==0){
                        System.out.println("Dobbelsteen werd al is gepakt, pak ander dobbelsteen : ");
                        dc.setSymbool(input.nextInt());
                    }
                    else {
                        dc.getGekozen().add(dc.getSymbool());
                        controleGekozen= true;
                    } 
                }
                System.out.println(dc.getGekozen().toString());
                System.out.printf("%nAantal Dobbelstenen over: " + dc.berekenAantalDobbelsteen());
                System.out.printf("%nScore Speler: " + dc.berekenScore());
            } while (dc.berekenScore() < 21 );
            
/////////////////////////////////////// EINDE DO WHILE 1 //////////////////////////////////////////////////////////
            if(dc.berekenScore()<21 && !dc.getGekozen().containsAll(dc.getGeworpen())){
                    
                    System.out.println("%nJammer, je hebt niet genoeg punten.");
                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                        System.out.printf("%nJe verliest een tegel.");
                                
                        item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                        nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                        //bovenste tegel checken
                        item2=dc.getTegelStapel().size();
                        int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                        try{
                            if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                               
                            }
                        }catch(IndexOutOfBoundsException e){
                            
                        }
                        
                        if(nieuw>nieuw2){
                            dc.getTegelStapel().add((Integer)nieuw);
                            dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                        }else{
                            dc.getOmgedraaideTegels().add((Integer)nieuw);
                            dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                        }
            //einde checken
                    }
                        
                    System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                    System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                        
                    for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                        if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                            item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                            nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                            System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                        } else{
                            System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                        }
                    }
                        
                    dc.resetAantalDobbelsteen();
                    dc.resetScore();
                    dc.getGekozen().clear();
                    dc.getGeworpen().clear();
                       
                       ////volgende beurt
                    break;
                
            }
/////////////////////////////////////// BEGIN DO WHILE 2 /////////////////////////////////////////////////////////////////
//vanaf score 21 en meer dan 0 dobbelstenen vragen om verder te gooien
            if(dc.berekenScore()>=21){
                do{
                    System.out.printf("%nGooi? (1=gooi, 0=stop): ");
                    gooi = input.nextInt();
                
                    if (gooi != 1) {
                // for vr boolean of er een stapel is die niet leeg is
                        if(dc.getGekozen().contains(6)){
                            System.out.printf("%nJe beëindigt je beurt met een score van: %d.%n",dc.berekenScore());
                            
                            for(int b=0;b<dc.getSpelersArrayList().size();b++){
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(b)).isEmpty()){
                                    nietAllemaalLeeg = true;
                                }
                            }
                            
                            if(nietAllemaalLeeg == true){
                            
                                    for(int j=0;j<dc.getSpelersArrayList().size();j++){
                                        if(!dc.eigenStapel(dc.getSpelersArrayList().get(j)).isEmpty()){  
                                            int itemVanI = dc.eigenStapel(dc.getSpelersArrayList().get(i)).size(); 
                                            item=dc.eigenStapel(dc.getSpelersArrayList().get(j)).size();
                                            nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(j)).get((Integer)item-1);
                                            if(dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                                if(nieuw == dc.berekenScore()){
                                                    steal = true;
                                                    theSteal = nieuw;
                                                    victim = j;
                                                }
                                            }
                                            else if(nieuw == dc.berekenScore() && nieuw != dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)itemVanI-1)){
                                                steal = true;
                                                theSteal = nieuw;
                                                victim = j;
                                            }
                                        }
                                        
                                    }
                            }
                            
                            
                           
                            for(int teg1 : dc.getTegelStapel()){
                                if(teg1 == dc.berekenScore()){
                                    tegelInRij = true;
                                }
                            }
                            
                            
                            for(int teg2 : dc.getTegelStapel()){
                                if(teg2 < dc.berekenScore()){
                                    lagereTegel = true;
                                }
                            }
                        
                                
                            

                            if(tegelInRij == false && steal == false  && lagereTegel == false){
                                System.out.printf("%nMaar jammer, er is geen enkele tegel beschikbaar die voldoet aan jouw score...%n");
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                    System.out.printf("%nJe verliest een tegel.");
                                
                                    item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                    nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                    //bovenste tegel checken
                                    item2=dc.getTegelStapel().size();
                                    int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                    try{
                                        if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                            System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                           
                                        }
                                    }catch(IndexOutOfBoundsException e){
                            
                                    }
                        
                                    if(nieuw>nieuw2){
                                        dc.getTegelStapel().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }else{
                                        dc.getOmgedraaideTegels().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }
            //einde checken
                                }
                    //einde checken
                            }
                
                            else if(tegelInRij == true ){
                      
                                System.out.printf("%n%nTegelrij: %n%s%n", dc.getTegelStapel().toString());
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else {
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                            
                                System.out.printf("%n%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                
                                while(dc.getKiesTegel()>dc.berekenScore() || !dc.getTegelStapel().contains(dc.getKiesTegel())){
                                    System.out.printf("Je moet een tegel nemen die lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                         
                   
                            else if(steal == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                                
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(dc.getKiesTegel()>dc.berekenScore() || dc.getKiesTegel()< 21){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                  
                                if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }
                            
                                else{
                                    while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore() ){
                                        System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                        dc.setKiesTegel(input.nextInt());
                                    }
                                    if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }else{
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                    dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                                    }
                                }
                            }
                      
                            else if(lagereTegel == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                    }
                                }
                            
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore()){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is en lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                        }
                    
                        else {
                            System.out.printf("%n%nJammer, je beurt was niet succesvol aangezien je geen worm hebt kunnen bemachtigen... ");
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                System.out.printf("%nJe verliest een tegel.");
                                
                                item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                //bovenste tegel checken
                                item2=dc.getTegelStapel().size();
                                int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                try{
                                    if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                        System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                            
                                }
                        
                                if(nieuw>nieuw2){
                                    dc.getTegelStapel().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }else{
                                    dc.getOmgedraaideTegels().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }
            //einde checken

                                
                            }
                        }
                    
                        System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                        System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                    
                        for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                            } else{
                                System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                            }
                        }
                    
                        dc.resetAantalDobbelsteen();
                        dc.resetScore();
                        dc.getGekozen().clear();
                        dc.getGeworpen().clear();
                          
                     
                        break;
                   
                    }
                
             
            
                    if(gooi==1){
                        dc.rolDobbelsteen();
                        System.out.println(dc.getGeworpen());
         
                        for (int k = 1; k < 7; k++) {
                            System.out.printf(" %n" + k + ": " + dc.getZijde()[k]);
                        }
         
                        if(dc.getGekozen().containsAll(dc.getGeworpen())){
                            System.out.printf("%n%nJammer, alles werd al is gepakt.");
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                System.out.printf("%nJe verliest een tegel.");
                                
                                item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                //bovenste tegel checken
                                item2=dc.getTegelStapel().size();
                                int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                try{
                                    if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                        System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                       
                                    }
                                }catch(IndexOutOfBoundsException e){
                            
                                }
                        
                                if(nieuw>nieuw2){
                                    dc.getTegelStapel().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }else{
                                    dc.getOmgedraaideTegels().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }
            //einde checken

                                
                            }
                        
                            System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                            System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                        
                            for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                    item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                    nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                    System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                } else {
                                    System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                }
                            }
                        
                            dc.resetAantalDobbelsteen();
                            dc.resetScore();
                            dc.getGekozen().clear();
                            dc.getGeworpen().clear();
                       
                            ////volgende beurt
                            break;
                        }
         
                        System.out.printf("%n%nKies symbool gegooide dobbelsteen: ");
                        dc.setSymbool(input.nextInt());
         
                        dc.getGeworpen().clear();
          
                        boolean controleGekozen2=false;
                        while(controleGekozen2==false){
                            if(dc.getZijde()[dc.getSymbool()]==0){
                                System.out.printf("%nDobbelsteen werd niet gegooid,pak ander symbool: ");
                                dc.setSymbool(input.nextInt());
                            }
                            else{
                                controleGekozen2=true;
                            }
                        }
        
                        boolean controleGekozen = false;
                        while(controleGekozen == false){
                            if(dc.getGekozen().contains(dc.getSymbool()) | dc.getZijde()[dc.getSymbool()]==0){
                                System.out.println("%nDobbelsteen werd al is gepakt, pak ander dobbelsteen : ");
                                dc.setSymbool(input.nextInt());
                            }
                            else {
                                dc.getGekozen().add(dc.getSymbool());
                                controleGekozen= true;
                            } 
                        }
                        System.out.printf("Reeds gekozen: %n%s", dc.getGekozen().toString());
                        System.out.printf("%nAantal Dobbelstenen over : " + dc.berekenAantalDobbelsteen());
                        System.out.printf("%nScore Speler : " + dc.berekenScore());
            
                       
                       
                       
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        if(dc.berekenScore() >= 21 && dc.berekenAantalDobbelsteen() == 0){
                            perfectGedobbeld = true;
                        }


                    if(dc.berekenScore() >= 21 && perfectGedobbeld == true){    
                        if(dc.getGekozen().contains(6)){
                            System.out.printf("%nJe beëindigt je beurt met een score van: %d.%n",dc.berekenScore());
                            
                            for(int b=0;b<dc.getSpelersArrayList().size();b++){
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(b)).isEmpty()){
                                    nietAllemaalLeeg = true;
                                }
                            }
                            
                            if(nietAllemaalLeeg == true){
                            
                                    for(int j=0;j<dc.getSpelersArrayList().size();j++){
                                        if(!dc.eigenStapel(dc.getSpelersArrayList().get(j)).isEmpty()){  
                                            int itemVanI = dc.eigenStapel(dc.getSpelersArrayList().get(i)).size(); 
                                            item=dc.eigenStapel(dc.getSpelersArrayList().get(j)).size();
                                            nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(j)).get((Integer)item-1);
                                            if(dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                                if(nieuw == dc.berekenScore()){
                                                    steal = true;
                                                    theSteal = nieuw;
                                                    victim = j;
                                                }
                                            }
                                            else if(nieuw == dc.berekenScore() && nieuw != dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)itemVanI-1)){
                                                steal = true;
                                                theSteal = nieuw;
                                                victim = j;
                                            }
                                        }
                                        
                                    }
                            }
                            
                            
                            for(int teg1 : dc.getTegelStapel()){
                                if(teg1 == dc.berekenScore()){
                                    tegelInRij = true;
                                }
                            }
                            
                            
                            for(int teg2 : dc.getTegelStapel()){
                                if(teg2 < dc.berekenScore()){
                                    lagereTegel = true;
                                }
                            }
                        
                                
                            

                            if(tegelInRij == false && steal == false  && lagereTegel == false){
                                System.out.printf("%nMaar jammer, er is geen enkele tegel beschikbaar die voldoet aan jouw score...%n");
                                if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                    System.out.printf("%nJe verliest een tegel.");
                                
                                    item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                    nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                    //bovenste tegel checken
                                    item2=dc.getTegelStapel().size();
                                    int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                    try{
                                        if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                            System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                           
                                        }
                                    }catch(IndexOutOfBoundsException e){
                            
                                    }
                        
                                    if(nieuw>nieuw2){
                                        dc.getTegelStapel().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }else{
                                        dc.getOmgedraaideTegels().add((Integer)nieuw);
                                        dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                    }
            //einde checken
                                }
                    //einde checken
                            }
                
                            else if(tegelInRij == true ){
                      
                                System.out.printf("%n%nTegelrij: %n%s%n", dc.getTegelStapel().toString());
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else {
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                            
                                System.out.printf("%n%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                
                                while(dc.getKiesTegel()>dc.berekenScore() || !dc.getTegelStapel().contains(dc.getKiesTegel())){
                                    System.out.printf("Je moet een tegel nemen die lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                         
                   
                            else if(steal == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                                    }
                                }
                                
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(dc.getKiesTegel()>dc.berekenScore() || dc.getKiesTegel()< 21){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                  
                                if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }
                            
                                else{
                                    while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore() ){
                                        System.out.printf("%nJe moet een tegel nemen die beschikbaar is...");
                                        dc.setKiesTegel(input.nextInt());
                                    }
                                    if(dc.getKiesTegel() == theSteal){
                                    System.out.printf("%nJe hebt de tegel van de tegenstander gepakt");
                                    dc.eigenStapel(dc.getSpelersArrayList().get(victim)).remove((Integer)dc.getKiesTegel());
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                }else{
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                    dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                                    }
                                }
                            }
                      
                            else if(lagereTegel == true){
                                System.out.printf("%n%nTegelrij: " + dc.getTegelStapel());
                                
                                for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                                    if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                        item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                        nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                        System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                                    } else{
                                        System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                    }
                                }
                            
                                System.out.printf("%nJe kan nu een tegel kiezen: ");
                                dc.setKiesTegel(input.nextInt());
                                while(!dc.getTegelStapel().contains(dc.getKiesTegel()) || dc.getKiesTegel() >= dc.berekenScore()){
                                    System.out.printf("%nJe moet een tegel nemen die beschikbaar is en lager of gelijk is aan uw score.");
                                    dc.setKiesTegel(input.nextInt());
                                }
                                
                                
                                dc.eigenStapel(dc.getSpelersArrayList().get(i)).add((Integer)dc.getKiesTegel());
                                dc.getTegelStapel().remove((Integer)dc.getKiesTegel());
                            }
                        }
                    
                        else {
                            System.out.printf("%n%nJammer, je beurt was niet succesvol aangezien je geen worm hebt kunnen bemachtigen... ");
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(i)).isEmpty()){
                                System.out.printf("%nJe verliest een tegel.");
                                
                                item=dc.eigenStapel(dc.getSpelersArrayList().get(i)).size();
                                nieuw=dc.eigenStapel(dc.getSpelersArrayList().get(i)).get((Integer)item-1);
                                //bovenste tegel checken
                                item2=dc.getTegelStapel().size();
                                int nieuw2=dc.getTegelStapel().get((Integer)item2-1);
                                
                                try{
                                    if(! dc.eigenStapel(dc.getSpelersArrayList().get(i)).toString().isEmpty()){
                                        System.out.printf("%nBovenste tegel %s: %d %n", dc.getSpelersArrayList().get(i).getNaamSpeler(), (Integer)nieuw); 
                                
                                        
                                    }
                                }catch(IndexOutOfBoundsException e){
                            
                                }
                        
                                if(nieuw>nieuw2){
                                    dc.getTegelStapel().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }else{
                                    dc.getOmgedraaideTegels().add((Integer)nieuw);
                                    dc.eigenStapel(dc.getSpelersArrayList().get(i)).remove((Integer)nieuw);
                                }
            //einde checken

                                
                            }
                        }
                    
                        System.out.printf("%n%nTegelrij: %n%s", dc.getTegelStapel().toString());
                        System.out.printf("%nOmgedraaide tegels: %n%s%n", dc.getOmgedraaideTegels().toString());
                    
                        for(int tegels=0;tegels<dc.getSpelersArrayList().size();tegels++){
                            if(!dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).isEmpty()){
                                item = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).size();
                                nieuw = dc.eigenStapel(dc.getSpelersArrayList().get(tegels)).get((Integer)item-1);
                    
                                System.out.printf("%nBovenste tegel %s : %d",dc.getSpelersArrayList().get(tegels).getNaamSpeler(), nieuw);
                            } else{
                                System.out.printf("%nBovenste tegel %s : leeg",dc.getSpelersArrayList().get(tegels).getNaamSpeler());
                                
                            }
                        }
                    
                        dc.resetAantalDobbelsteen();
                        dc.resetScore();
                        dc.getGekozen().clear();
                        dc.getGeworpen().clear();
                          
                     
                        break;
                   
                    
                        
                        }   
                    }
                }while(dc.berekenAantalDobbelsteen()>0);
            }
                
            }
        }while(dc.getTegelStapel() != null && !dc.getTegelStapel().isEmpty());
        
        for(int i= 0; i < dc.getSpelersArrayList().size(); i++){
            System.out.printf("%nDe hoogste tegelwaarde van de stapel van %s is: %d%n",  dc.getSpelersArrayList().get(i).getNaamSpeler(), dc.spelersArrayList.get(i).eigenStapel.isEmpty() ? 0 : Collections.max(dc.getSpelersArrayList().get(i).eigenStapel));
        }
        int highestScore=0;
        int winnaar=0;

        for(int i= 0; i < dc.getSpelersArrayList().size(); i++){

            System.out.printf("%nSpeler %s heeft een score behaald van %d wormen.", dc.getSpelersArrayList().get(i).getNaamSpeler(), dc.spelersArrayList.get(i).eigenStapel.isEmpty() ? 0 : dc.getSpelersArrayList().get(i).berekenAantalWormen());
            if(dc.getSpelersArrayList().get(i).berekenAantalWormen() == highestScore){
                if(Collections.max(dc.getSpelersArrayList().get(i).eigenStapel) > 
                    Collections.max(dc.getSpelersArrayList().get(winnaar).eigenStapel)){
                        highestScore = dc.getSpelersArrayList().get(i).berekenAantalWormen();
                        winnaar = i;
                }
                else{
                        highestScore = dc.getSpelersArrayList().get(winnaar).berekenAantalWormen();
                }
            }

            else if(dc.getSpelersArrayList().get(i).berekenAantalWormen() > highestScore){
                highestScore = dc.getSpelersArrayList().get(i).berekenAantalWormen();
                winnaar = i;

            }
        }

        System.out.printf("%n%nDe grote winnaar is %s met een score van %d wormen en zyn hoogste tegel met waarde %d!", dc.getSpelersArrayList().get(winnaar).getNaamSpeler(), highestScore, Collections.max(dc.getSpelersArrayList().get(winnaar).eigenStapel));
    }
    
/////////////////////////////////////// EINDE DO WHILE 2 /////////////////////////////////////////////////////////////////               
    public int spelersKiezen(){
        Scanner input = new Scanner(System.in);
        
        int aantalSpelers=0;
        
        System.out.printf("Regenworm-spel %n%n%n");
        
        
        do{
            System.out.printf("Hoeveel spelers tussen 2 en 7 ? ");
            aantalSpelers=input.nextInt();
            
        }while(aantalSpelers <2 | aantalSpelers>7);
        System.out.printf("%nHet aantal gekozen spelers is %s.%n", aantalSpelers);
        return aantalSpelers;

}
    
    public void maakSpelerAanInArrayList(int aantalSpelers)
    {
        boolean waar;
        Scanner input = new Scanner(System.in);
        
        for(int aantal=0; aantal<aantalSpelers;aantal++)
        {      
            do {
                boolean datumIsGoed=false;
                Date huidigeDatum=new Date();
                String naamSpeler="";
                String date="";
                int berekenAantalDobbelsteen = 8;
                int result=0;
                int totaalScoreSpeler=0;
                
                ArrayList <Integer> eigenStapel=new ArrayList<>();
                waar = false;
                int aantalWormen = 0;
            
             System.out.printf("%n%nGeef de naam van speler %s : ",aantal+1);
             naamSpeler = input.next();
            while(!datumIsGoed){
                 
                date="";
                System.out.printf("%nGeef de geboortedatum in van speler %d. (dd/MM/yyyy)%n",aantal+1);
                date = input.next();
                SimpleDateFormat datum=new SimpleDateFormat();
                datum.applyPattern("dd/MM/yyyy");
                datum.setLenient(false);
                
                try{
                    Date geboorte=datum.parse(date);
                    if(geboorte.before(huidigeDatum)){
                        datumIsGoed=true;
                       }else{
                        System.out.printf("Pak andere datum want ligt in de toekomst.");
                    }
                    }catch(ParseException e){
                       System.out.printf("%s Is geen geldige datum.",date); 
                       input.next();
                       datumIsGoed=false;
                    }
                
                try{
                    String[]splitArray=date.split("/");
                    int day=Integer.parseInt(splitArray[0]);
                    int month=Integer.parseInt(splitArray[1]);
                    int year=Integer.parseInt(splitArray[2]);
                    
                    Date now = new Date();
                    int nowMonth=now.getMonth()+1;
                    int nowYear=now.getYear()+1900;
                     result=nowYear-year;
        
                         if(month>nowMonth){
                       result--;
                    }
                    else if(month==nowMonth){
                        int nowDay=now.getDay();
            
                         if(day>nowDay){
                       result--;
          }
         }
       }catch(NumberFormatException ex){
        }
               // dc.spelerInArrayToevoegen(naamSpeler,aantal,date,result);
             //dc.nieuweSpeler(naamSpeler,leeftijdSpeler);
             
           
        }
            //naamspeler is gewijzigd ,aantal is verwijderd,date is gewijzigd
            
          // dc.spelerInArrayToevoegen(naamSpeler,aantal,date,result,berekenAantalDobbelsteen,totaalScoreSpeler,eigenStapel, aantalWormen);
      } while (waar == true);
     }
    }
    //blijkbaar door die tostring methode gaat die automatisch dan de namen en leeftijd die in de spelersarraylist staan deftig weergeven en niet in symbolen
    //to string methode moet niet worden weergegeven in ui.spel(gaat automatisch)
     public void geefSpelersVoor()
    {
         for(int spelers=0; spelers<dc.getSpelersArrayList().size();spelers++)
        {
            System.out.printf(" %s ",dc.getSpelersArrayList().get(spelers).toString()); 
        }
       
    }
     
    
     
    
     
     
}

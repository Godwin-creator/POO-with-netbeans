/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import gestion.fichier2.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author EDOHB
 */
public class Navigateur {
    private static Navigateur instance;
    private Repertoire repertoireCourrant;
    
    static {
        instance = new Navigateur();
    }

    public static Navigateur getInstance() {
        return instance;
    }
    
    public void setRepertoireCourant(Repertoire repertoireCourant){
        this.repertoireCourrant = repertoireCourant;
    }
    
    
    public Repertoire getRepertoireCourrant(){
        return this.repertoireCourrant;
    }
    
    public void changeRepertoire(String nom) throws FileNotFoundException{
        if(nom == null){
            this.repertoireCourrant = Repertoire.getRoot();
            return;
        } 
        
        if(nom.equals(".")){
        }
        
    }
    
}

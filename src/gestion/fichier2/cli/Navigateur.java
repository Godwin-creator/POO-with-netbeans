/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import gestion.fichier2.metier.Repertoire;

/**
 *
 * @author EDOHB
 */
public class Navigateur {
    
    private Repertoire repertoireCourant;

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Repertoire getRepertoireCourant(){
        
        return this.repertoireCourant;
        
    }
    
}

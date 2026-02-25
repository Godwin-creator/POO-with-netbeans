/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.metier;

import java.io.Serial;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDOHB
 */
public class Repertoire extends Fichier{
    
    @Serial
    static final long serialVersionUID = -3387516993124229948L;
    private List<Fichier> fichiers = new ArrayList<>();
            
            
    Object getFichiers() {
        
        return null;
        
    }

    @Override
    public Fichier copier(Repertoire destination) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getTaille() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean estRepertoire() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

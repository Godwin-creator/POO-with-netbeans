/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.metier;

/**
 *
 * @author EDOHB
 */
public class FichierSimple extends Fichier{
    private String contenu = "";
    
    public FichierSimple(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }
    
    @Override
    public int getTaille() {
        return (contenu != null)
                ? contenu.length() : 0;
    }

    @Override
    public Fichier copier(Repertoire destination) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean estRepertoire() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

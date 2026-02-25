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

    public Repertoire(String nom, Repertoire repertoireParent) {
        super (nom, repertoireParent);
    }
            
            
    public List<Fichier> getFichiers(){
        return this.fichiers;
    }

    @Override
    public Fichier copier(Repertoire destination) {
        
    }

    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier f : fichiers) {
            taille = taille + f.getTaille();
        }
        return taille;
    }

    @Override
    public boolean estRepertoire() {
        return true;
    }

    public void AfficherContenu() {
        for (Fichier f : fichiers) {
            System.out.println(f.getNom()+ "\n");
        }
    }

    public Repertoire getRepertoire(String nomComplet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean existeFichierSimple(String nom) {
        if (nom == null){
            return false;
        }
        for (Fichier f : fichiers) {
            if (f.getNom() != null && f.getNom().equals(nom) && !f.estRepertoire()) {
                return true;
            }
        }
        return false;
    }

    public void ajouterFichierSimple(String nom) {
        new FichierSimple(nom, this);
    }

    public void ajouterRepertoire(String nom) {
        new Repertoire(nom, this);
    }

    public boolean existeRepertoire(String nom) {
        if (nom == null) {
            return false;
        }
        for (Fichier f : fichiers) {
            if (f.getNom() != null & f.getNom().equals(nom) && f.estRepertoire()) {
                return true;
            }
        }
        return false;
    }
    
}

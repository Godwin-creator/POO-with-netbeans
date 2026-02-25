/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.metier;

import java.io.FileNotFoundException;
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
        Repertoire nouveauDossier = new Repertoire(this.getNom(), destination);
        
        for (Fichier f : this.fichiers) {
            f.copier(nouveauDossier);
        }
        return nouveauDossier;
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

    public Repertoire getRepertoire(String nom) throws FileNotFoundException{
        for (Fichier f : fichiers) {
            if (f.getNom() != null && f.getNom().equals(nom) && f.estRepertoire()){
                return (Repertoire)f ;
            }
        }
        throw new FileNotFoundException("Le repertoire n'existe pas");
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

    public Fichier getFichier(String nom) throws FileNotFoundException{
        if (nom == null) throw new FileNotFoundException("Le nom est inavlide");
        
        for (Fichier f : fichiers) {
            if (f.getNom() != null && f.getNom().equals(nom)) {
                return f;
            }
        }
        throw new FileNotFoundException("Le fichier " + nom + " est introuvable dans ce rep");
    }

    public boolean supprimerElement(String nom) {
        if (nom == null) {
            return false;
        }
        return fichiers.removeIf(f -> f.getNom() != null && f.getNom().equals(nom));
    }
    
    //Avec la cmde cp on peut un fichier d'un dossier et le coller dans le mm dossier
    public void ajouterFichier(Fichier f){
        fichiers.add(f);
    }
    
    
}

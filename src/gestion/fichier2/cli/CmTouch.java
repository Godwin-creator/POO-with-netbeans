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
public class CmTouch extends Commande{

    private String nom;

    @Override
    public void executer() {
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Precisez le nom du fichier à creer");
            return;
        }
        
        Repertoire courant = Navigateur.getInstance().getRepertoireCourrant();
        if (!courant.existeFichierSimple(nom)) {
            courant.ajouterFichierSimple(nom);
            System.out.println("Fichier simple "+nom+"cree avec succes");
        } else{
            System.out.println(nom+" existe deja.");
        }
    }

    @Override
    public void setParametres(String[] parametre) {
        this.nom = parametre[0];
    }
    
}

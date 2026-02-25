/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import gestion.fichier2.metier.Fichier;
import gestion.fichier2.metier.Repertoire;

/**
 *
 * @author EDOHB
 */
public class CmCp extends Commande{
    private String nomComplet;
    private String nomCompletDestination;

    @Override
    public void executer() {
        if (nomComplet == null || nomCompletDestination == null) {
            System.out.println("Suivez la synthase : CP [nomComplet] [nomCompletDestination]");
            return;
        }
        
        try {
            Repertoire courant = Navigateur.getInstance().getRepertoireCourrant();
            Fichier cible = courant.getFichier(nomComplet);
            Repertoire destination = courant.getRepertoire(nomCompletDestination);
            
            cible.copier(destination);
            System.out.println(nomComplet + " a ete copie dans " + nomCompletDestination + " avec succes.");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setParametres(String[] parametre) {
        if (parametre.length >= 2) {
            this.nomComplet = parametre[0];
            this.nomCompletDestination = parametre[1];
        }
    }
    
}

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
public class CmRm extends Commande{

    private String cible;

    @Override
    public void executer() {
        if (cible == null) {
            System.out.println("Suivez la synthase : RM 'nom_du_fichier_a_supprimer'");
            return;
        }
    Repertoire courant = Navigateur.getInstance().getRepertoireCourrant();

        if (courant.supprimerElement(cible)) {
            System.out.println(cible + " supprime avec succes.");
        } else{
            System.out.println(cible + " n'existe pas.");
        } 
    }
    
    

    
    @Override
    public void setParametres(String[] parametre) {
        if (parametre.length > 0) {
            this.cible =parametre[0];
        }
    }
    
}

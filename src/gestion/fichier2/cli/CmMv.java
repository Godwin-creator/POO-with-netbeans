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
public class CmMv extends Commande{
    private String nomComplet;
    private String nomCompletDestination;

    @Override
    public void executer() {
        try {
            Repertoire courrant = Navigateur.getInstance().getRepertoireCourrant();
            Fichier cible = courrant.getFichier(nomComplet);
            Repertoire destination = courrant.getRepertoire(nomCompletDestination);
            
            cible.copier(destination);
            courrant.supprimerElement(nomComplet);
            System.out.println(nomComplet + " a ete deplace vers " + nomCompletDestination);
        
        } catch (Exception e){
            System.out.println("Le deplacement a echoue");
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

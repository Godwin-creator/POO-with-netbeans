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
public class CmMkdir extends Commande{
    
    private String nom;

    @Override
    public void executer() {
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Precisez le nom du dossier a creer");
            return;
        }
        
        Repertoire courrant = Navigateur.getInstance().getRepertoireCourrant();
        if(!courrant.existeRepertoire(nom)){
            courrant.ajouterRepertoire(nom);
            System.out.println("Repertoire "+nom+" cree avec succes");
        } else {
            System.out.println("Le repertoire "+nom+" existe deja");
        }
    }

    @Override
    public void setParametres(String[] parametre) {
        this.nom = parametre[0];
    }
    
}

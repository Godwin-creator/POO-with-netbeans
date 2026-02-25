/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import gestion.fichier2.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author EDOHB
 */
public class CmLs extends Commande{
    private String nomComplet;

    @Override
    public void executer() {
        Repertoire cible = Navigateur.getInstance().getRepertoireCourrant();
        if (nomComplet != null) {
            try {
                cible = cible.getRepertoire(nomComplet);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        } else{
            try {
                
            } catch (Exception e) {
            }
        }
        cible.AfficherContenu();
    }

    @Override
    public void setParametres(String[] parametre) {
        if (parametre.length > 0) {
            this.nomComplet = parametre[0];
        }
    }
    
}

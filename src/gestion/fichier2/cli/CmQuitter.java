/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import gestion.fichier2.metier.Fichier;
import java.util.Scanner;

/**
 *
 * @author EDOHB
 */
public class CmQuitter extends Commande{

    @Override
    public void executer() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Voulez-vous vraiment quitter (o/n) ? ");
        String reponse = clavier.next().toUpperCase();
        
        if (reponse.equals("O")) {
            try {
                Fichier.sauvegarder();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("A bientot !");
            System.exit(0);
        }
    }

    @Override
    public void setParametres(String[] parametre) {

    }
    
}

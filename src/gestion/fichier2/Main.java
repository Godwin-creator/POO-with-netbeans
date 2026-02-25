/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichier2;

import gestion.fichier2.cli.Commande;
import gestion.fichier2.cli.Navigateur;
import gestion.fichier2.cli.ParseurCommande;
import gestion.fichier2.metier.Fichier;
import java.util.Scanner;

/**
 *
 * @author EDOHB
 */
public class Main {
    public static Scanner clavier = new Scanner(System.in);
    public static ParseurCommande parseur = new ParseurCommande();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\t\t\t---INVITE DE COMMANDE : Gestion Fichier---");
        
        try {
            Fichier.restaurer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
        
        while (true) {            
            String chemin = "C:\\Users\\EDOHB\\" + Navigateur.getInstance().getRepertoireCourant().getNomComplet() + ">";
            
            System.out.println(chemin);
            String strCmde = clavier.nextLine();
            Commande commande = parseur.parser(strCmde);
            commande.executer();
        }
        
        // TODO code application logic here
    }
    
}

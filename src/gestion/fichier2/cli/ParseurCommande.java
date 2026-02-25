/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import java.util.Arrays;
/**
 *
 * @author EDOHB
 */
public class ParseurCommande {
    public Commande parser(String strCmd) {
        String[] tbCmd = strCmd.trim().split(" ");
        
        String premierMot = tbCmd[0].toUpperCase();
        
        Commande commande;
        switch (premierMot) {
            case "HELP":
                commande = new CmAide();
                break;
            
            case "EXIT":
                commande = new CmQuitter();
                break;
            
            case "CD":
                commande = new CmCD();
                break;
                
            case "CP":
                commande = new CmCp();
                break;
                
            case "RM":
                commande = new CmRm();
                break;
                
            case "LS":
                commande = new CmLs();
                break;
                
            case "MKDIR":
                commande = new CmMkdir();
                break;
                
            case "MV":
                commande = new CmMv();
                break;
                
            case "TOUCH":
                commande = new CmTouch();
                break;
            default:
                commande = new CmInconnue();
        };
        
        if (tbCmd.length > 1) {
            String[] parametres = Arrays.copyOfRange(tbCmd, 1, tbCmd.length);
            commande.setParametres(parametres);
        }
        
        return commande;
    }
    
}

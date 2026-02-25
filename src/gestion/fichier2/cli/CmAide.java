/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

/**
 *
 * @author EDOHB
 */
public class CmAide extends Commande{
    
    @Override
    public void executer(){
        System.out.println("HELP : Afficher les commandes dispo");
        System.out.println("EXIT : Quitter le programme");
        System.out.println("CD : Changer de repertoire");
        System.out.println("CP : Copier un fichier");
        System.out.println("LS : Afficher les fichiers");
        System.out.println("MV : Déplacer un fichier");
        System.out.println("RM : Supprimer un fichier");
        System.out.println("TOUCH : Créer un fichier simple");
        System.out.println("MKDIR : Créer un repertoire");
        
    }
    
    @Override
    public void setParametres(String[] parametre){
        
    }
}

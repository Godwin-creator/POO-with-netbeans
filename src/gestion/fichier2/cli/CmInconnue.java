/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

/**
 *
 * @author EDOHB
 */
public class CmInconnue extends Commande{

    @Override
    public void executer() {
        System.out.println("Commande Inconnue");
    }

    @Override
    public void setParametres(String[] parametre) {
        
    }
    
}

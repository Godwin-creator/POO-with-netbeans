/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.cli;

import java.io.FileNotFoundException;

/**
 *
 * @author EDOHB
 */
public class CmCD extends Commande{
    public String nomComplet;
    
    @Override
    public void executer(){
        try {
            Navigateur.getInstance().changeRepertoire(nomComplet);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void setParametres(String[] parametres){
        this.nomComplet = parametres[0];
    }

}

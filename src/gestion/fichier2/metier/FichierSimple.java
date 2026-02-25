/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.metier;

/**
 *
 * @author EDOHB
 */
public class FichierSimple extends Fichier{
    
    public FichierSimple(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }
    private String contenu = "";

    
    @Override
    public int getTaille() {
        return (contenu != null)
                ? contenu.length() : 0;
    }

    @Override
    public Fichier copier(Repertoire destination) {
        FichierSimple copie = new FichierSimple(this.getNom(), destination);
        copie.setContenu(this.getContenu());
        return copie;
    }

    public  String getContenu(){
        return contenu;
    }
    
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    
    @Override
    public boolean estRepertoire() {
        return false;
    }
    
}

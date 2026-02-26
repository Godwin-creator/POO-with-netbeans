/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier2.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author EDOHB
 */
public abstract class Fichier implements Serializable{
    private LocalDate dateCreation;
    String nom;
    private Repertoire repertoireParent;
    
    private static Repertoire root = new Repertoire("\\root", null);
    
    public static Repertoire getRoot(){
        return root;
    }
    
    public static final String path = "C:\\Users\\EDOHB\\OneDrive\\Documents\\EPL\\Cours S3\\Programmation orientée objet\\ME\\gestion-fichier2\\fichier.ser";

    public abstract Fichier copier(Repertoire destination);
    
    public Fichier(){
        this.dateCreation = LocalDate.now();
    }
    
    public Fichier(String nom){
        this();
        this.nom = nom;
    }
    
    public Fichier(String nom, Repertoire repertoireParent){
        this(nom);
        this.repertoireParent = repertoireParent;
        if(this.repertoireParent != null){
            this.repertoireParent.getFichiers().add(this);
        }
    }
            
    public  static void sauvegarder() throws Exception{
        FileOutputStream fichier = new FileOutputStream(Fichier.path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
        objectOutputStream.writeObject(root);
        objectOutputStream.flush();
    }
    
    public static void restaurer() {
        try {
            FileInputStream fihier = new FileInputStream(Fichier.path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fihier);
            root = (Repertoire) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            
        } catch (IOException e){
            
        } catch (ClassNotFoundException e){
            
        }
    }
    
    public abstract int getTaille();
    public abstract boolean estRepertoire();
    
    public String getNom(){
        return this.nom;
    }
    
    public String getNomComplet(){
        if(repertoireParent == null){
            return this.nom;
        }
        return repertoireParent.getNomComplet() + "\\" + this.nom;
    }
    
    public Repertoire getRepertoireParent(){
        return repertoireParent;
    }
}

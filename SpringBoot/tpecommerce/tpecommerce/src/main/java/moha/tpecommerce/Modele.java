/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moha.tpecommerce;

/**
 *
 * @author e2500138
 */
public class Modele {
    public String nom;
    public int prix;
    public int quantite;
    public int id;
    
    public Modele(String n, int p, int q, int i){
        nom = n;
        prix = p;
        quantite = q;
        id = i;
    }
    
    public String toStringQ(){
        return quantite + "x " + nom + " à " + prix + " euros";
    }
    
    @Override
    public String toString(){
        return nom + " à " + prix + " euros";
    }
}

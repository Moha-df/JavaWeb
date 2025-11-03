/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moha.tpecommerce;



/**
 *
 * @author e2500138
 */
public class Donnes {
    public Modele[] modeles;
    public int nbModeles;
    
    public Donnes(){
        modeles = new Modele[100];
        modeles[0] = new Modele("Tesla Model Q", 20000, 3, 0);
        nbModeles = 1;
    }
    
    public void clear(){
        modeles = new Modele[100];
        nbModeles = 0;
    }
    
    public void addDonnes(Modele m, int qMax){

        for(int i = 0; i<nbModeles; i++){
            if(modeles[i].nom.equals(m.nom)){
                modeles[i].quantite += m.quantite;
                if(modeles[i].quantite >= qMax){
                    modeles[i].quantite = qMax;
                }
                return;
            }
        }

        if(m.quantite > qMax){
            m.quantite = qMax;
        }
        modeles[nbModeles] = m;
        nbModeles++;
    }
    
    public String afficher() {
        String s = "";
        for (int i = 0; i < nbModeles; i++) {
            s+=modeles[i].toStringQ();
            s+="<br>";
        }
        return s;
    }
    
    public String getTotalPrice(){
        int totalPrice = 0;
        for(int i = 0; i<nbModeles; i++){
            totalPrice += modeles[i].prix * modeles[i].quantite;
        }
        return "Total: " + totalPrice;
    }
    
    
    
    
    
    
}

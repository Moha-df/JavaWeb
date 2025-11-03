/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moha.tpecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author e2500138
 */
@Controller
@SessionAttributes("donnes")
public class MonControlleur {
    
    Modele[] tabElt=new Modele[3];
    
    @ModelAttribute("donnes")
    public Donnes creerMonAttributDansLaSession() {
        return new Donnes();
    }
    

    @GetMapping("/affiche")
    public String modifierGet(@ModelAttribute("donnes") Donnes donnes, Model model){

        
        tabElt[0] = new Modele("Tesla Model S", 20000, 3, 1);
        tabElt[1] = new Modele("Renault Clio", 6500, 5, 2);
        tabElt[2] = new Modele("Peugeot 208", 2500, 10, 3);
        
        model.addAttribute("tabElt", tabElt);
        
        model.addAttribute("info", donnes);

        return "affiche";
    }
    
    @PostMapping("/ajouterProduit")
    public String ajouterProduitPost(@ModelAttribute("donnes") Donnes donnes, Model model, int idProduit, int quantite){
        
        int id = idProduit-1;
        Modele m = new Modele(tabElt[id].nom, tabElt[id].prix, quantite, tabElt[id].id);
        m.quantite = quantite;
        
        donnes.addDonnes(m, tabElt[id].quantite);
        
        model.addAttribute("info", donnes);

        return "redirect:/affiche";
    }
    
    @GetMapping("/affichevalide")
    public String afficheValide(@ModelAttribute("donnes") Donnes donnes, Model model){

        
        
        
        model.addAttribute("tabElt", tabElt);
        
        model.addAttribute("info", donnes);

        return "valide";
    }
    
    @PostMapping("/valider")
    public String ajouterProduitPost(@ModelAttribute("donnes") Donnes donnes, Model model){
        
        
        model.addAttribute("tabElt", tabElt);
        
        model.addAttribute("info", donnes);

        return "redirect:/affichevalide";
    }
    
    @PostMapping("/validerAdresse")
    public String validerAdresses(@ModelAttribute("donnes") Donnes donnes, Model model, String adresse){
        
        if(adresse.isEmpty()){
            model.addAttribute("tabElt", tabElt);
        
            model.addAttribute("info", donnes);

            return "redirect:/affichevalide";
        }else{
            model.addAttribute("tabElt", tabElt);
        
            donnes.clear();
            model.addAttribute("info", donnes);

            return "redirect:/affiche";
        }
        
       
    }
}

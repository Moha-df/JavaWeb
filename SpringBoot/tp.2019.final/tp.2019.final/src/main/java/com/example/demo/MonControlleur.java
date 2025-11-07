/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

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
@SessionAttributes("donnees")
public class MonControlleur {
    
    @ModelAttribute("donnees")
    public Donnees creerMonAttributDansLaSession(){
        return new Donnees();
    }
    
    @GetMapping("/dvd")
    public String getDvd(@ModelAttribute("donnees") Donnees donnees, Model model){
        
        
        
        return "affiche";
        
    }
    
    @GetMapping("/afficher")
    public String afficherDvd(@ModelAttribute("donnees") Donnees donnees, Model model){
        
        model.addAttribute("listeDvd", donnees.getDvdList());
        
        return "affichedvd";
        
    }
    
    @PostMapping("/addDvd")
    public String addDvd(@ModelAttribute("donnees") Donnees donnees, Model model, String titleParam, String priceParam, String quantityParam){
        
        if(!titleParam.isEmpty() && !priceParam.isEmpty() && !quantityParam.isEmpty()){
            int price = Integer.parseInt(priceParam);
            int quantity = Integer.parseInt(quantityParam);
            donnees.addDvd(titleParam, price, quantity);
        }
        
         model.addAttribute("donnees", donnees);
        
        return "redirect:/dvd";
    }
    
    @PostMapping("/suivant")
    public String suivantDvd(@ModelAttribute("donnees") Donnees donnees, Model model){
        
        donnees.suivant();
        model.addAttribute("donnees", donnees);
        
        
        return "redirect:/dvd";
    }
    
    @PostMapping("/precedent")
    public String precedentDvd(@ModelAttribute("donnees") Donnees donnees, Model model){
        
        donnees.precedent();
        model.addAttribute("donnees", donnees);
        
        
        return "redirect:/dvd";
    }
    
    @PostMapping("/supprimer")
    public String supprimerDvd(@ModelAttribute("donnees") Donnees donnees, Model model){
        
        donnees.deleteDvd();
        model.addAttribute("donnees", donnees);
        
        
        return "redirect:/dvd";
    }
}

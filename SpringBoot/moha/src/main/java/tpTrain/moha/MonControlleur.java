/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpTrain.moha;

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
@SessionAttributes("dessin")
public class MonControlleur {
    
    
    @ModelAttribute("dessin")
    public Dessin creerMonAttributDansLaSession(){
        return new Dessin();
    }
    
    @GetMapping("/dessin")
    public String getDessin(@ModelAttribute("dessin") Dessin dessin, Model model){
        
        model.addAttribute("info", dessin);

        return "affiche";
    }
    
    @PostMapping("/remplir")
    public String postRemplir(@ModelAttribute("dessin") Dessin dessin, Model model, String character){
        
        char c = ' ';
        
        if(!character.isEmpty()){
            c = character.charAt(0);
        }
        
        dessin.remplir(c);
        
        model.addAttribute("info", dessin);
        
        
        return "redirect:/dessin";
    }
    
    @PostMapping("/rectangle")
    public String postRectangle(@ModelAttribute("dessin") Dessin dessin, Model model, int x1, int x2, int y1, int y2, String character){
        
        char c = ' ';
        
        if(!character.isEmpty()){
            c = character.charAt(0);
        }
        
        dessin.dessiner(x1, y1, x2, y2, c);
        
        model.addAttribute("info", dessin);
        
        
        return "redirect:/dessin";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.session.moha;

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
@SessionAttributes("grille")
public class MonController {

    // Méthode pour créer l'objet donnees dans
    // la session lorsque cette session est créée
    @ModelAttribute("grille")
    public Grille creerMonAttributDansLaSession() {
        return new Grille();
    }

    @PostMapping("/modifierGrille")
    public String modifierPost(@ModelAttribute("grille") Grille grille, String x, String y, String action){
                // Ajoute la valeur du paramètre de la requête dans l’objet de la session
       if(action != null && x != null && y != null){
            int xParam = Integer.parseInt(x);
            int yParam = Integer.parseInt(y);
            
            Cell cell = grille.getCell(xParam, yParam);

                
            if (action.equals("creuser")) {
                if (cell.getState() == Cell.CellState.HIDDEN) {
                     cell.setState(Cell.CellState.REVEALED);
                     // (Optionnel) tu peux aussi ajouter ici une logique de "révélation automatique"
                     // des cases vides autour si bombsAround == 0
                 }
            } else if (action.equals("drapeau")) {
                 if (cell.getState() == Cell.CellState.HIDDEN) {
                     cell.setState(Cell.CellState.FLAGGED);
                 } else if (cell.getState() == Cell.CellState.FLAGGED) {
                     cell.setState(Cell.CellState.HIDDEN);
                 }
            }
        }
        return "redirect:/afficherGrille";
    }
       
    @PostMapping("/clearGrille")
    public String clearGrille(@ModelAttribute("grille") Grille grille){
                // Ajoute la valeur du paramètre de la requête dans l’objet de la session
       
        grille.clear();
        // Redirection HTTP GET vers /modifierNom
        return "redirect:/afficherGrille";
    }
    
    @GetMapping("/afficherGrille")
    public String modifierGet(@ModelAttribute("grille") Grille grille, Model model){
        // Met l'attribut pour l'affichage de la page thymeleaf
        model.addAttribute("info", grille);
        // Affiche la page thymeleaf qui contient le formulaire et le nom mis à jour
        return "mineur";
    }

}
/*
@Controller
@SessionAttributes("donnes")
public class MonController {

    // Méthode pour créer l'objet donnees dans
    // la session lorsque cette session est créée
    @ModelAttribute("donnes")
    public Donnes creerMonAttributDansLaSession() {
        return new Donnes();
    }

    @PostMapping("/modifierNom")
    public String modifierPost(@ModelAttribute("donnes") Donnes donnes, String nom){
                // Ajoute la valeur du paramètre de la requête dans l’objet de la session
        donnes.setNom(nom);
        // Redirection HTTP GET vers /modifierNom
        return "redirect:/modifierNom";
    }
    
    @GetMapping("/modifierNom")
    public String modifierGet(@ModelAttribute("donnes") Donnes donnes, Model model){
        // Met l'attribut pour l'affichage de la page thymeleaf
        model.addAttribute("info", donnes);
        // Affiche la page thymeleaf qui contient le formulaire et le nom mis à jour
        return "affiche";
    }

}
*/


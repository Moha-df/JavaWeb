/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moha.tpweb.tp1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 *
 * @author e2500138
 */
/*
@Controller
public class MonControlleur {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
*/

/*
@Controller
public class MonControlleur {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(required = false) String nm, @RequestParam(required = false) String pr) {
        return "<h1>Bonjour "+pr+" "+nm+"</h1>";
    }
}
*/

/*
@Controller
public class MonControlleur {
    
    @GetMapping("/hello")
    public String hello2(Model model) 
    {
        return "hello_avec_thymeleaf";
    }
    
    @PostMapping("/hello")
    public String hello(Model model, int num1,  int num2, String operand) 
    {
        int res = 0;
        
        if(operand!=null){
            if(operand.equals("+")){
             res = num1 + num2;
            }
            if(operand.equals("-")){
                 res = num1 - num2;
            }
            if(operand.equals("*")){
                 res = num1 * num2;
            }
            if(operand.equals("/")){
                 res = num1 / num2;
            }
        }

        model.addAttribute("resultat", res);
        return "hello";
    }
}



*/

@Controller
@SessionAttributes("donnees")
public class MonControlleur {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(required = false) String nm, @RequestParam(required = false) String pr) {
        return "<h1>Bonjour "+pr+" "+nm+"</h1>";
    }
    
    // Méthode pour créer l'objet donnees dans
    // la session lorsque cette session est créée
    @ModelAttribute("donnes")
    public Donnes creerMonAttributDansLaSession() {
        return new Donnes();
    }
    
    @PostMapping("/modifierNom")
    public String modifierPost(@ModelAttribute("donnes") Donnes donnes,
            String votrenom){
		// Ajoute la valeur du paramètre de la requête dans l’objet de la session
        donnes.setNom(votrenom);
        // Redirection HTTP GET vers /modifierNom
        return "redirect:/modifierNom";
    }
    
    @GetMapping("/modifierNom")
    public String modifierGet(@ModelAttribute("donnees") Donnes donnes, 
           Model model){
        // Met l'attribut pour l'affichage de la page thymeleaf
        model.addAttribute("info", donnes);
        // Affiche la page thymeleaf qui contient le formulaire et le nom mis à jour
        return "affiche";
    }


}
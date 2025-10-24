/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.moha.tpboucle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author e2500138
 */
@Controller
public class MonControleur {
    @GetMapping("/test")
    public String test(Model model) {
        UnElement[] tabElt=new UnElement[10];
        for (int i=0;i<10;i++){
            tabElt[i]=new UnElement();
            tabElt[i].setVal1("Span numero " + Integer.toString(i));
        }
           
        
        model.addAttribute("tabElt", tabElt);
        return "test";
    }
}


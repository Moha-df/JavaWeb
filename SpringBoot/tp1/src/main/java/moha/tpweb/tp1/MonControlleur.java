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
import org.springframework.web.bind.annotation.PostMapping;


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

@Controller
public class MonControlleur {
    
    @GetMapping("/hello")
    public String hello2(Model model, String num1, String num2, String operand) 
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




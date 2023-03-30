package edu.tdtu.lab08_01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/showerror")
    public String showerror(){

        return "showerror";
    }

    @GetMapping("/about")
    public  String about(){
        return  "about";
    }

    @GetMapping("/contact")
    public  String contact(){
        return "contact";
    }

    @PostMapping("/resultForm")
    public String form(ModelMap model, @RequestParam(name = "email") String email, @RequestParam(name = "pwd") String pwd){
        model.addAttribute("email", email);
        model.addAttribute("pwd", pwd);
        return "resultForm";
    }
}

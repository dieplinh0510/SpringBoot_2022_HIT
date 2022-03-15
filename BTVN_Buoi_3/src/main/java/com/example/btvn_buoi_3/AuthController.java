package com.example.btvn_buoi_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    @GetMapping("/index")
    public String getLogIn(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/result")
    public String  getRes(@ModelAttribute User user, Model model){


        if (Store.users.contains(user)){
            model.addAttribute("users", Store.users);
            return "home";
        }
        return "index";
    }
}

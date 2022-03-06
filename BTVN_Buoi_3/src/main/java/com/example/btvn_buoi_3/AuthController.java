package com.example.btvn_buoi_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private Store store;

    @GetMapping("/index")
    public String getLogIn(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/result")
    public String  getRes(@ModelAttribute User user, Model model){
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());

        boolean ok= false, check=false;
        for (int i=0; i<store.users.size(); i++){
            if (user.getUserName().compareTo(store.users.get(i).getUserName())==0){
                ok = true;
                break;
            }
        }
        for (int i=0; i<store.users.size(); i++){
            if (user.getPassword().compareTo(store.users.get(i).getPassword())==0){
                check = true;
                break;
            }
        }

        if (ok && check){
            model.addAttribute("users", store.users);
            return "home";
        }else return "index";
    }
}

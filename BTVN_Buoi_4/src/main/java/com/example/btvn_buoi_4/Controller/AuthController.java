package com.example.btvn_buoi_4.Controller;

import com.example.btvn_buoi_4.Model.User;
import com.example.btvn_buoi_4.Reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    //trang login
    @GetMapping("/login")
    public String getLogIn(Model model){
        model.addAttribute("user", new User());
        return "index";
    }


    @GetMapping("/creatNewUser")
    public String creatUser(Model model){
        model.addAttribute("user", new User());
        return "creatNewuser";
    }


    @GetMapping("/edit")
    public String editUser(@RequestParam (value = "id") Long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "edit";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam (value = "id") Long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "delete";
    }




}

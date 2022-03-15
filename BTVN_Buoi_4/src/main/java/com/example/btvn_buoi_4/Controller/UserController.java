package com.example.btvn_buoi_4.Controller;

import com.example.btvn_buoi_4.Model.User;
import com.example.btvn_buoi_4.Reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    //lay alluser
    @GetMapping("/home")
    public String getAllUser(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "home";
    }

    //check user
    @PostMapping("/result")
    public String getRes(@ModelAttribute User user, Model model){
        List <User> users = userRepository.findAll();
        if (users.contains(user)){
            model.addAttribute("users", users);
            return "home";
        }
        model.addAttribute("Đăng nhập không thành công.");
        return "index";
    }

    @PostMapping("/edit")
    public String saveUser (@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/api/user/home";
    }
    @PostMapping("/delete")
    public String saveUser1(@ModelAttribute User user){
        userRepository.deleteById(user.getId());
        return "redirect:/api/user/home";
    }


    //tao 1 tai khoan moi
    @PostMapping("/checkNewUser")
    public String creatUser( @ModelAttribute User user){
        if (userRepository.findByUsername(user.getUsername())==null){
            userRepository.save(user);
            return "redirect:/api/user/home";
        }
        return "creatNewuser";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable ("id") Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.status(200).body(user);
    }
}

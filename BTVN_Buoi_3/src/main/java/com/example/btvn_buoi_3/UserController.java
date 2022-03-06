package com.example.btvn_buoi_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private Store store;

    @GetMapping()
    public List<User> getUser(){
        return store.users;
    }
}

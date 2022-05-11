package com.example.training_buoi_6.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;

public class AppController {
    @GetMapping
    public String getData(){
        ClassPathResource cpr = new ClassPathResource("static/tinh_tp.json");
    }
}

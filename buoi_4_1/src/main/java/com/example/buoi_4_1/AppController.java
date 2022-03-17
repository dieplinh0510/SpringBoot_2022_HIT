package com.example.buoi_4_1;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/{id}")
    public String getId(@PathVariable ("id") String id){
        return id;
    }

    @GetMapping("/{id}/{username}")
    public  String getIdAndUsername(
            @PathVariable ("id") String id,
            @PathVariable ("username") String username
    ){
        return id + " - "+ username;
    }

    @GetMapping("/app")
    public String getApp(@RequestParam(value = "name") String name,
                         @RequestParam(value = "name2", required = false) String name2){
        return name + " - " + name2;
    }
}

package com.example.buoi_4_1;

import com.example.buoi_4_1.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getAllUser(@RequestBody UserDTO userDTO){
        if (userDTO.getUserName().equals("")){
            throw  new NotFoundException("Username rong");
        }
        return ResponseEntity.status(200).body(userDTO);
    }

}

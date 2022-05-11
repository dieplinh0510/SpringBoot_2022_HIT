package com.hit.btvn_security.adapter.web.v1.controller;

import com.hit.btvn_security.adapter.web.application.service.UserService;
import com.hit.btvn_security.adapter.web.base.RestApiV1;
import com.hit.btvn_security.adapter.web.base.VsResponseUtil;
import com.hit.btvn_security.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/get")
    public ResponseEntity<?> getAllUser() {
        return VsResponseUtil.ok(userService.getAllUser());
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> createNewUser(@RequestBody UserDto userDto) {
        return VsResponseUtil.ok(userService.createNewUser(userDto));
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<?> deleteUserById(@RequestParam("id") Long id) {
        return VsResponseUtil.ok(userService.deleteUserById(id));
    }

}

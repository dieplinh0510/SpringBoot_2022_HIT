package com.hit.btvn_security.adapter.web.v1.controller;

import com.hit.btvn_security.adapter.web.application.service.AuthService;
import com.hit.btvn_security.adapter.web.base.RestApiV1;
import com.hit.btvn_security.adapter.web.base.VsResponseUtil;
import com.hit.btvn_security.adapter.web.v1.transfer.parameter.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        return VsResponseUtil.ok(authService.login(request));
    }

}

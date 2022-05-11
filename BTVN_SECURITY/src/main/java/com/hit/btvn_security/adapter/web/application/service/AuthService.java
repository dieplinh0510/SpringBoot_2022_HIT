package com.hit.btvn_security.adapter.web.application.service;

import com.hit.btvn_security.adapter.web.application.dai.UserRepository;
import com.hit.btvn_security.adapter.web.application.util.JwtUtil;
import com.hit.btvn_security.adapter.web.v1.transfer.parameter.AuthenticationRequest;
import com.hit.btvn_security.adapter.web.v1.transfer.response.AuthenticationResponse;
import com.hit.btvn_security.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse login(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByUsername(request.getUsername());

        return new AuthenticationResponse(jwt, user.getId(), user.getUsername());
    }
}

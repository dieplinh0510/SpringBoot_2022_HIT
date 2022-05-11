package com.example.buoi_11.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticationResponse {
    private String jwt;
    private Integer idUser;
    private String username;
    private List<String> roles;
}

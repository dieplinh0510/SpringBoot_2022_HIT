package com.example.buoi_9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private String username;
    private String password;
    private String fullName;
    private MultipartFile avatar;
}

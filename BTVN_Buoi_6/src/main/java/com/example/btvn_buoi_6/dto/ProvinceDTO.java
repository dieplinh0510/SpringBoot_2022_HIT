package com.example.btvn_buoi_6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProvinceDTO {
    private String name;
    private String slug;
    private String type;
    private String name_with_type;
    private Long code;
}

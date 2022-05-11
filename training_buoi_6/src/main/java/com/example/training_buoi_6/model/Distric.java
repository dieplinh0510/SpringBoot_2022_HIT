package com.example.training_buoi_6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Distric {
    private String name;
    private String type;
    private String slug;
    private String name_with_type;
    private String path;
    private String path_with_type;
    private String code;
    private String parent_code;
}

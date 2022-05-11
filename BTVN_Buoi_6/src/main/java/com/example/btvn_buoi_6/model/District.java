package com.example.btvn_buoi_6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Districts")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;
    private String type;
    private String name_with_type;
    private String path;
    private String path_with_type;
    private Long code;
    private Long parent_code;
}

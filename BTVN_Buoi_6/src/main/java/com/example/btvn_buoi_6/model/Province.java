package com.example.btvn_buoi_6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Provinces")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;
    private String type;
    private String name_with_type;
    private Long code;
}

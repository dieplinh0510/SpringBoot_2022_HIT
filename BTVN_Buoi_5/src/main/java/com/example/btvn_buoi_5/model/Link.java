package com.example.btvn_buoi_5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shortlinks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalLink;

    @Column(unique = true)
    private String shortedLink;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return originalLink.equals(link.shortedLink);
    }
}

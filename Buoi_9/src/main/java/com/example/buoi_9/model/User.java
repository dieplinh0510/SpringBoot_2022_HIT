package com.example.buoi_9.model;

import com.example.buoi_9.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String password;

    @Nationalized
    private String fullName;

    @Column(name = "avatar")
    private String avatar;
}

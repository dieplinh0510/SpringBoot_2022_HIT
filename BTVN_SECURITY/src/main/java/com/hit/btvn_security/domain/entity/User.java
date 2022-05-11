package com.hit.btvn_security.domain.entity;

import com.hit.btvn_security.adapter.web.base.RestApiV1;
import com.hit.btvn_security.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractAuditingEntity {

    @Column(unique = true)
    private String username;

    private String password;

}

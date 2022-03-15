package com.example.btvn_buoi_4.Reponsitory;

import com.example.btvn_buoi_4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
}

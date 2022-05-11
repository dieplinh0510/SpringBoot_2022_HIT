package com.example.ktra_1.repositories;

import com.example.ktra_1.models.Darling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DarlingRepository extends JpaRepository<Darling, Long> {

    List<Darling> findAllByStatus(Integer status);
    List<Darling> findAllByStatusIsBetween(Integer statusone, Integer statustwo);
}

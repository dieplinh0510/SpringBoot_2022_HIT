package com.example.ktra_1.services;

import com.example.ktra_1.dto.DarlingDTO;
import com.example.ktra_1.models.Darling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DarlingService {
    List<Darling> findAllDarlingByStatusOneTwo();
    List<Darling> findAllDarlingOrFindByStatusTwo(Integer status);
    Object findDarlingById(Long id);
    Darling creatDarling(DarlingDTO darlingDTO);
    Darling updateDarling(DarlingDTO darlingDTO, Long id);
    Darling deleteDarling(Long id);
    List<Darling> findDarlingByAddress(String name);

}

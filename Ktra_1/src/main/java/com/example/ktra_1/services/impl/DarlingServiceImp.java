package com.example.ktra_1.services.impl;

import com.example.ktra_1.dto.DarlingDTO;
import com.example.ktra_1.exception.NotFoundException;
import com.example.ktra_1.models.Address;
import com.example.ktra_1.models.Darling;
import com.example.ktra_1.repositories.AddressRepository;
import com.example.ktra_1.repositories.DarlingRepository;
import com.example.ktra_1.services.DarlingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DarlingServiceImp implements DarlingService {
    @Autowired
    private DarlingRepository darlingRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Darling> findAllDarlingByStatusOneTwo() {
        return darlingRepository.findAllByStatusIsBetween(1,2);
    }

    @Override
    public List<Darling> findAllDarlingOrFindByStatusTwo(Integer status) {
        return darlingRepository.findAllByStatus(2);
    }

    @Override
    public Darling findDarlingById(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        return darling.get();
    }

    @Override
    public Darling creatDarling(DarlingDTO darlingDTO) {


        try {
            Darling darling = new Darling();
            darling.setName(darlingDTO.getName());
            darling.setPhone(darlingDTO.getPhone());
            darling.setEmail(darlingDTO.getEmail());
            darling.setFavorite(darlingDTO.getFavorite());
            darling.setStatus(darlingDTO.getStatus());

            return darlingRepository.save(darling);
        } catch (Exception e){
            throw new NotFoundException("data base error");
        }
    }

    @Override
    public Darling updateDarling(DarlingDTO darlingDTO, Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        try {
            darling.get().setName(darlingDTO.getName());
            darling.get().setPhone(darlingDTO.getPhone());
            darling.get().setEmail(darlingDTO.getEmail());
            darling.get().setFavorite(darlingDTO.getFavorite());
            darling.get().setStatus(darlingDTO.getStatus());
            return darlingRepository.save(darling.get());
        } catch (Exception e){
            throw new NotFoundException("data base error");
        }
    }

    @Override
    public Darling  deleteDarling(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        try {
            darling.get().setStatus(3);
            return darlingRepository.save(darling.get());
        } catch (Exception e){
            throw new NotFoundException("data base error");
        }
    }

    @Override
    public List<Darling> findDarlingByAddress(String name) {
        List<Darling> darlings = darlingRepository.findAll();

        List<Address> addresses = addressRepository.findAll();

        for (Address address : addresses){
            if (address.getName().compareTo(name)==0){
                darlings.add(address.getDarling());
            }
        }
        return darlings;

    }
}

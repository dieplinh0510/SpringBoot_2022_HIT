package com.example.ktra_1.services.impl;

import com.example.ktra_1.dto.AddressDTO;
import com.example.ktra_1.models.Address;
import com.example.ktra_1.models.Darling;
import com.example.ktra_1.repositories.AddressRepository;
import com.example.ktra_1.repositories.DarlingRepository;
import com.example.ktra_1.services.AddressService;
import com.example.ktra_1.services.SendMailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DarlingRepository darlingRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Autowired
    private SendMailService sendMailService;

    @Override
    public Address createAddress(Long darlingId, AddressDTO addressDTO) {
        Address address = new Address();
        address.setName(addressDTO.getName());
        address.setCode(addressDTO.getCode());
        sendMailService.sendMailWithText("hoello", "Lam linh xinh dep", "dieplinh1005.dh@gmail.com");
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(AddressDTO addressDTO, Long darlingId, Long id) {
        Optional<Address> address = addressRepository.findById(darlingId);
        address.get().setName(addressDTO.getName());
        address.get().setCode(addressDTO.getCode());
        return addressRepository.save(address.get());
    }

    @Override
    public List<Address> deleteAddress(Long darlingId, Long id) {
        Optional<Address> address = addressRepository.findById(darlingId);
        addressRepository.delete(address.get());
        return addressRepository.findAll();
    }

    @Override
    public List<Address> findAddressByDarlingId(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        return darling.get().getAddresses();
    }
}

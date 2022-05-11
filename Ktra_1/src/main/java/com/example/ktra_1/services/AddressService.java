package com.example.ktra_1.services;

import com.example.ktra_1.dto.AddressDTO;
import com.example.ktra_1.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    List<Address> findAllAddress();
    Optional<Address> findAddressById(Long id);
    Address createAddress(Long darlingId, AddressDTO addressDTO);
    Address updateAddress(AddressDTO addressDTO, Long darlingId, Long id);
    List<Address> deleteAddress(Long darlingId, Long id);
    List<Address> findAddressByDarlingId(Long id);

}

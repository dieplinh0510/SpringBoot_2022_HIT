package com.example.ktra_1.controllers;

import com.example.ktra_1.dto.AddressDTO;
import com.example.ktra_1.models.Address;
import com.example.ktra_1.repositories.AddressRepository;
import com.example.ktra_1.services.AddressService;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/api/v2")
public class AddressController {
//    @Autowired
//    AddressRepository addressRepository;

    //Thêm địa chỉ cho người yêu
//    @PostMapping("/{darlingId}")
//    public ResponseEntity<?> postAddress(@PathVariable(name = "darlingId") Long darlingId, @RequestBody AddressDTO addressDTO){
//        Address address = addressRepository.findAddressById(darlingId);
//        address.setName(addressDTO.getName());
//        address.setCode(addressDTO.getCode());
//        address.setCreated(addressDTO.getCreated());
//        address.setUpdated(addressDTO.getUpdated());
//        addressRepository.save(address);
//        return  ResponseEntity.status(200).body(addressRepository.findAll());
//
//    }
//
//    //Sửa thông tin địa chỉ cho người yêu
//    @PatchMapping("/{darlingId}/{id}")
//    public ResponseEntity<?> patchAddress(@PathVariable(name = "darlingId") Long darlingId, @PathVariable(name = "id") Long id, @RequestBody AddressDTO addressDTO){
//        Address address = addressRepository.findAddressByIdAndDarlingId(darlingId, id);
//        address.setName(addressDTO.getName());
//        address.setCode(addressDTO.getCode());
//        address.setCreated(addressDTO.getCreated());
//        address.setUpdated(addressDTO.getUpdated());
//        addressRepository.save(address);
//        return  ResponseEntity.status(200).body(addressRepository.findAll());
//
//    }
//
//    //Xóa địa chỉ của người yêu(Nếu darlingId không tồn tại thì không được xóa)
//
//    @DeleteMapping("/{darlingId}/{id}")
//    public ResponseEntity<?> deleteAdress(@PathVariable(name = "darlingId") Long darlingId, @PathVariable(name = "id") Long id){
//        Address address = addressRepository.findAddressByIdAndDarlingId(darlingId, id);
//        addressRepository.delete(address);
//        return  ResponseEntity.status(200).body(addressRepository.findAll());
//    }


    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<?> findAllAddress(){
        return ResponseEntity.status(200).body(addressService.findAllAddress());
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<?> findAddressById(@PathVariable Long id){
        return ResponseEntity.status(200).body(addressService.findAddressById(id));
    }

    @PostMapping("/addresses/{darlingId}")
    public ResponseEntity<?> createAddress(@PathVariable Long darlingId,@Valid @RequestBody AddressDTO addressDTO){
        return ResponseEntity.status(200).body(addressService.createAddress(darlingId, addressDTO));
    }

    @PatchMapping("/addresses/{darlingId}/{id}")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO,
                                           @PathVariable Long darlingId, @PathVariable Long id){
        return ResponseEntity.status(200).body(addressService.updateAddress(addressDTO, darlingId, id) );
    }

    @DeleteMapping("/addresses/{darlingId}/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long darlingId, @PathVariable Long id){
        return  ResponseEntity.status(200).body(addressService.deleteAddress(darlingId, id));
    }

    @GetMapping("/darlings/{id}/addresses")
    public ResponseEntity<?> findAddressByDarlingId(@PathVariable Long id){
        return ResponseEntity.status(200).body(addressService.findAddressByDarlingId(id));
    }
}


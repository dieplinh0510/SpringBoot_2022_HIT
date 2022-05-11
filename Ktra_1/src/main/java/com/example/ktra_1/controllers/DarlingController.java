package com.example.ktra_1.controllers;

import com.example.ktra_1.dto.DarlingDTO;
import com.example.ktra_1.models.Darling;
import com.example.ktra_1.services.DarlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController("/api/v1/darlings")
@RestController("/api/v1")
public class DarlingController{
//    @Autowired
//    private DarlingRepository darlingRepository;


    //lay all ny
//    @GetMapping
//    public ResponseEntity<?> getAllDarling(){
//        return ResponseEntity.status(200).body(darlingRepository.findAll());
//    }




    //lay all ny hien tai
//    @GetMapping("/current")
//    public ResponseEntity<?> getAllDarling1(){
//        List<Darling> darlings = darlingRepository.findDarlingsByStatus(1);
//        return ResponseEntity.status(200).body(darlings);
//    }
//
//
//    //lay all ny dang doi de do
//    @GetMapping("/id")
//    public ResponseEntity<?> getAllDarling2(@RequestParam(name = "status") Integer status){
//        List<Darling> darlings = darlingRepository.findDarlingsByStatus(status);
//        return ResponseEntity.status(200).body(darlings);
//    }
//
//
//    //lay ny theo id
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getDarlingById(@PathVariable Long id){
//        Darling darling = darlingRepository.findDarlingsById(id);
//        return ResponseEntity.status(200).body(darling);
//    }
//
//
//    //tao ny moi
//    @PostMapping
//    public ResponseEntity<?> postDarling(@RequestBody DarlingDTO darlingDTO){
//        Darling darling = new Darling();
//        darling.setName(darlingDTO.getName());
//        darling.setPhone(darlingDTO.getPhone());
//        darling.setEmail(darlingDTO.getEmail());
//        darling.setFavorite(darlingDTO.getFavorite());
//        darling.setCreated(darlingDTO.getCreated());
//        darling.setUpdated(darlingDTO.getUpdated());
//        darling.setStatus(darlingDTO.getStatus());
//
//        darlingRepository.save(darling);
//
//        return ResponseEntity.status(200).body(darlingRepository.findAll());
//    }
//
//    //sua thong tin ny theo id
//    @PatchMapping("/{id}")
//    public ResponseEntity<?> patchDarlingById(@PathVariable Long id, @RequestBody DarlingDTO darlingDTO){
//        Darling darling = darlingRepository.findDarlingsById(id);
//        darling.setName(darlingDTO.getName());
//        darling.setPhone(darlingDTO.getPhone());
//        darling.setEmail(darlingDTO.getEmail());
//        darling.setFavorite(darlingDTO.getFavorite());
//        darling.setStatus(darlingDTO.getStatus());
//
//        darlingRepository.save(darling);
//        return ResponseEntity.status(200).body(darlingRepository.findAll());
//    }
//
//    //thay doi trang thai tu ny thanh nyc
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteDarlingById(@PathVariable Long id, @RequestBody DarlingDTO darlingDTO){
//        Darling darling = darlingRepository.findDarlingsById(id);
//        darling.setStatus(darlingDTO.getStatus());
//        darlingRepository.save(darling);
//        return ResponseEntity.status(200).body(darlingRepository.findAll());
//    }
//
//
//    //lay danh sach dia chi nha ny
//    @GetMapping("/{id}/addresses")
//    public ResponseEntity<?> getDarlingAddressById(@PathVariable Long id){
//        Darling darling = darlingRepository.findDarlingsById(id);
//        return ResponseEntity.status(200).body(darling);
//    }
//
//
//    //lay danh sach ny theo tinh
//    @GetMapping("/{id}/addressess")
//    public ResponseEntity<?> getDarlingByAddress(@RequestParam(name = "q") String q){
//        List<Darling> darlings = darlingRepository.findDarlingsByAddresses(q);
//        return ResponseEntity.status(200).body(darlings);
//    }


    @Autowired
    private DarlingService darlingService;

    @GetMapping("/darlings/current")
    public ResponseEntity<?> findAllDarlingByStatusOneTwo(){
        return ResponseEntity.ok().body(darlingService.findAllDarlingByStatusOneTwo());
    }

    @GetMapping("/darlings")
    public ResponseEntity<?> findAllDarlingOrFindByStatusTwo(
            @RequestParam(value = "status", required = false) Integer status
    ){
        return ResponseEntity.ok().body(darlingService.findAllDarlingOrFindByStatusTwo(status));
    }

    @GetMapping("/darlings/{id}")
    public  ResponseEntity<?> findDarlingById(@PathVariable Long id){
        return ResponseEntity.ok().body(darlingService.findDarlingById(id));
    }

    @PostMapping("/darlings")
    public ResponseEntity<?> creatDarling(@RequestBody DarlingDTO darlingDTO){
        return ResponseEntity.ok().body(darlingService.creatDarling(darlingDTO));
    }

    @PatchMapping("/darlings/{id}")
    public ResponseEntity<?> updateDarling(@RequestBody DarlingDTO darlingDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(darlingService.updateDarling(darlingDTO, id));
    }

    @DeleteMapping("/darlings/{id}")
    public ResponseEntity<?> deleteDarling(@PathVariable Long id){
        darlingService.deleteDarling(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/darlings/addresses")
    public ResponseEntity<?> findDarlingByAddress(@RequestParam(value = "name") String  name){
        return ResponseEntity.ok().body(darlingService.findDarlingByAddress(name));
    }


}

package com.paypilotprojectspring.bill.controller;


import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.service.BillGroceriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groceriesBills")
public class BillGroceriesController {

    private final BillGroceriesService billGroceriesService;

    @GetMapping
    public ResponseEntity<List<BillGroceriesDTO>> getAllGroceriesBills(){
        return new ResponseEntity<>(billGroceriesService.findAll("GROCERIES"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BillGroceriesDTO>> getGroceriesBillById(@PathVariable Long id){
        return new ResponseEntity<>(billGroceriesService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/addBill")
    public ResponseEntity<Void> addBill(@RequestBody BillGroceriesDTO billGroceriesDTO){
        billGroceriesService.addBill(billGroceriesDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateBill/{id}")
    public ResponseEntity<Boolean> updateBill(@PathVariable Long id, @RequestBody BillGroceriesDTO billGroceriesDTO){
        return new ResponseEntity<>(billGroceriesService.updateBill(billGroceriesDTO, id),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBill/{id}")
    public ResponseEntity<Boolean> deleteBill(@PathVariable Long id){
        return new ResponseEntity<>(billGroceriesService.deleteBill(id), HttpStatus.OK);
    }


}


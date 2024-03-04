package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.dto.BillRetirementDTO;
import com.paypilotprojectspring.bill.service.BillGroceriesService;
import com.paypilotprojectspring.bill.service.BillRetirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retirementBills")
public class BillRetirementController {
    private final BillRetirementService billRetirementService;

    @GetMapping
    public List<BillRetirementDTO> getAllRetirementBills(){
        return billRetirementService.findAll("RETIREMENT_CHARGES");
    }

    @GetMapping("/{id}")
    public Optional<BillRetirementDTO> getRetirementBillById(@PathVariable Long id){
        return billRetirementService.findById(id);
    }
    @PostMapping("/addBill")
    public ResponseEntity<Void> addBill(@RequestBody BillRetirementDTO billRetirementDTO){
        billRetirementService.addBill(billRetirementDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateBill/{id}")
    public ResponseEntity<Boolean> updateBill(@PathVariable Long id, @RequestBody BillRetirementDTO billRetirementDTO){
        return new ResponseEntity<>(billRetirementService.updateBill(billRetirementDTO, id),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBill/{id}")
    public ResponseEntity<Boolean> deleteBill(@PathVariable Long id){
        return new ResponseEntity<>(billRetirementService.deleteBill(id), HttpStatus.OK);
    }
}

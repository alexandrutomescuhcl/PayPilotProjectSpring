package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillInternetDTO;
import com.paypilotprojectspring.bill.service.BillInternetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internetBills")
public class BillInternetController {

    private final BillInternetService billInternetService;

    @GetMapping
    public ResponseEntity<List<BillInternetDTO>> getAllInternetBills() {
        return new ResponseEntity<>(billInternetService.findAll("INTERNET"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BillInternetDTO>> getInternetBillById(@PathVariable Long id) {
        return new ResponseEntity<>(billInternetService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/addBill")
    public ResponseEntity<Void> addBill(@RequestBody BillInternetDTO billInternetDTO) {
        billInternetService.addBill(billInternetDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateBill/{id}")
    public ResponseEntity<Boolean> updateBill(@PathVariable Long id, @RequestBody BillInternetDTO billInternetDTO) {
        return new ResponseEntity<>(billInternetService.updateBill(billInternetDTO, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBill/{id}")
    public ResponseEntity<Boolean> deleteBill(@PathVariable Long id) {
        return new ResponseEntity<>(billInternetService.deleteBill(id), HttpStatus.OK);
    }
}

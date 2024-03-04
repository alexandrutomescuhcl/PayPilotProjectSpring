package com.paypilotprojectspring.bank_details.controller;

import com.paypilotprojectspring.bank_details.dto.BankDetailsDTO;
import com.paypilotprojectspring.bank_details.model.BankDetails;
import com.paypilotprojectspring.bank_details.serivce.BankDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bankDetails")
public class BankDetailsController {

    private final BankDetailsService bankDetailsService;

    @GetMapping("/all")
    public ResponseEntity<List<BankDetails>> getAllBankDetails(){
        List<BankDetails> bankDetailsList = bankDetailsService.getAll();
        return new ResponseEntity<>(bankDetailsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<BankDetailsDTO> getBankDetailsById(@PathVariable int id){
        return bankDetailsService.findByBankDetailId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Optional<BankDetailsDTO> getBankDetailsByName(@RequestParam(value = "name") String name){
        return bankDetailsService.findBankDetailsByName(name);
    }
}

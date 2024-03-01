package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.dto.BillRetirementDTO;
import com.paypilotprojectspring.bill.service.BillGroceriesService;
import com.paypilotprojectspring.bill.service.BillRetirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

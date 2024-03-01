package com.paypilotprojectspring.bill.controller;


import com.paypilotprojectspring.bill.dto.BillGroceriesDTO;
import com.paypilotprojectspring.bill.service.BillGroceriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillGroceriesController {

    private final BillGroceriesService billGroceriesService;

    @GetMapping
    public List<BillGroceriesDTO> getAllGroceriesBills(){
        return billGroceriesService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BillGroceriesDTO> getGroceriesBillById(@PathVariable Long id){
        return billGroceriesService.findById(id);
    }


}


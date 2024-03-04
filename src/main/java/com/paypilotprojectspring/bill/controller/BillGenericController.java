package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillRequestDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.model.BillStatus;
import com.paypilotprojectspring.bill.service.BillGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillGenericController {

    private final BillGenericService billGenericService;

    @GetMapping
    public Map<BillCategory, Integer> displayNumberOfBillsForEachType(@RequestBody BillRequestDTO billRequestDTO){
        return billGenericService.displayNumberOfBillsForEachType(BillCategory.valueOf(billRequestDTO.getBillCategory()),
                billRequestDTO.getDateFrom(),
                billRequestDTO.getDateTo(),
                BillStatus.valueOf(billRequestDTO.getBillStatus()));
    }
}

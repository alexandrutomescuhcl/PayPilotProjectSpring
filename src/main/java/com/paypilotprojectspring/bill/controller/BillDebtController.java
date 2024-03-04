package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillDebtDTO;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.service.BillDebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/debt")
public class BillDebtController {

    private final BillDebtService billDebtService;

    @GetMapping("/all")
    public List<BillDebtDTO> getAllRentBills() {
        return billDebtService.findAll(String.valueOf(BillCategory.DEBT_PAYMENTS));
    }

    @GetMapping("/{id}")
    public Optional<BillDebtDTO> getRentById(@PathVariable(name = "id") Long id) {
        return billDebtService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRentBill(@RequestBody BillDebtDTO billDebtDTO) {
        billDebtService.addBill(billDebtDTO);
        return new ResponseEntity<>("Bill was added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRentBill(@PathVariable(name = "id") Long id,
                                                 @RequestBody BillDebtDTO billDebtDTO) {
        boolean result = billDebtService.updateBill(billDebtDTO, id);
        if (result) {
            return new ResponseEntity<>("Debt bill with id " + id + " was updated", HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Update operation was not possible");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRentBill(@PathVariable(name = "id") long id) {

        if (billDebtService.deleteBill(id))
            return ResponseEntity.status(HttpStatus.OK)
                    .body("The bill was successfully deleted.");
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Delete operation was not possible");
    }
}

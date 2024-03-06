package com.paypilotprojectspring.bill.controller;


import com.paypilotprojectspring.bill.dto.BillCellphoneDTO;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.service.BillCellphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phone")
public class BillCellPhoneController {

    private final BillCellphoneService billCellphoneService;

    @GetMapping("/all")
    public List<BillCellphoneDTO> getAllCellPhoneBills() {
        return billCellphoneService.findAll(String.valueOf(BillCategory.CELL_PHONE_CHARGES));
    }

    @GetMapping("/{id}")
    public Optional<BillCellphoneDTO> getCellPhoneById(@PathVariable(name = "id") Long id) {
        return billCellphoneService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCellPhoneBill(@RequestBody BillCellphoneDTO billCellphoneDTO) {
        billCellphoneService.addBill(billCellphoneDTO);
        return new ResponseEntity<>("Bill was added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCellPhoneBill(@PathVariable(name = "id") Long id,
                                                 @RequestBody BillCellphoneDTO billCellphoneDTO) {
        boolean result = billCellphoneService.updateBill(billCellphoneDTO, id);
        if (result) {
            return new ResponseEntity<>("Cell phone bill with id " + id + " was updated", HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Update operation was not possible");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCellPhoneBill(@PathVariable(name = "id") long id) {

        if (billCellphoneService.deleteBill(id))
            return ResponseEntity.status(HttpStatus.OK)
                    .body("The bill was successfully deleted.");
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Delete operation was not possible");
    }
}

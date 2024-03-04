package com.paypilotprojectspring.bill.controller;

import com.paypilotprojectspring.bill.dto.BillRentDTO;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.service.BillRentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rent")
public class BillRentController {

    private final BillRentService billRentService;

    @GetMapping("/all")
    public List<BillRentDTO> getAllRentBills() {
        return billRentService.findAll(String.valueOf(BillCategory.HOUSE_RENT));
    }

    @GetMapping("/{id}")
    public Optional<BillRentDTO> getRentById(@PathVariable(name = "id") Long id) {
        return billRentService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRentBill(@RequestBody BillRentDTO billRentDTO) {
        billRentService.addBill(billRentDTO);
        return new ResponseEntity<>("Bill was added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRentBill(@PathVariable(name = "id") Long id,
                                                 @RequestBody BillRentDTO billRentDTO) {
        boolean result = billRentService.updateBill(billRentDTO, id);
        if (result) {
            return new ResponseEntity<>("Rent bill with id " + id + " was updated", HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Update operation was not possible");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRentBill(@PathVariable(name = "id") long id) {

        if (billRentService.deleteBill(id))
            return ResponseEntity.status(HttpStatus.OK)
                    .body("The bill was successfully deleted.");
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Delete operation was not possible");
    }
}

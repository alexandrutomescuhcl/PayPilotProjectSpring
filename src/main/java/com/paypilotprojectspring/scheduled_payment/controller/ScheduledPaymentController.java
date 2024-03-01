package com.paypilotprojectspring.scheduled_payment.controller;

import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentUpdateDateDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import com.paypilotprojectspring.scheduled_payment.service.ScheduledPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduled-payment")
public class ScheduledPaymentController {

    private final ScheduledPaymentService scheduledPaymentService;

    public ScheduledPaymentController(ScheduledPaymentService scheduledPaymentService) {
        this.scheduledPaymentService = scheduledPaymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduledPayment> createScheduledPayment(@RequestBody ScheduledPaymentDto dto) {
        ScheduledPayment scheduledPayment = scheduledPaymentService.createScheduledPayment(dto);
        return new ResponseEntity<>(scheduledPayment, HttpStatus.CREATED);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<ScheduledPayment> cancelScheduledPayment(@RequestParam int id) {
        ScheduledPayment scheduledPayment = scheduledPaymentService.cancelScheduledPayment(id);
        return new ResponseEntity<>(scheduledPayment, HttpStatus.OK);
    }

    @PutMapping("/modify-date/{id}")
    public ResponseEntity<ScheduledPayment> modifyScheduleDate(@RequestParam int id,
                                                               @RequestBody ScheduledPaymentUpdateDateDto dto) {
        ScheduledPayment scheduledPayment = scheduledPaymentService.modifyScheduleDate(id, dto);
        return new ResponseEntity<>(scheduledPayment, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScheduledPayment>> getAllScheduledPayment() {
        List<ScheduledPayment> scheduledPaymentList = scheduledPaymentService.getAll();
        return new ResponseEntity<>(scheduledPaymentList, HttpStatus.OK);
    }
}

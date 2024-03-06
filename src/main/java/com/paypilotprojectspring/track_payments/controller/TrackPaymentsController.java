package com.paypilotprojectspring.track_payments.controller;

import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.track_payments.service.TrackPaymentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/track-payments")
public class TrackPaymentsController {

    private final TrackPaymentsService trackPaymentsService;

    public TrackPaymentsController(TrackPaymentsService trackPaymentsService) {
        this.trackPaymentsService = trackPaymentsService;
    }

    @GetMapping("/matching")
    public List<Bill> getAllMatchingBills(@RequestParam String billCategory,
                                          @RequestParam String billName)
    {
        return trackPaymentsService.getAllMatchingBills(BillCategory.valueOf(billCategory), billName);
    }
}

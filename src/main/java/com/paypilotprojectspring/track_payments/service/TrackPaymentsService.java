package com.paypilotprojectspring.track_payments.service;

import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackPaymentsService {
    private final BillRepository billRepository;

    public List<Bill> getAllMatchingBills(BillCategory billCategory,String billName) {
        List<Bill> matchingBills = new ArrayList<>();
        for (Bill bill : billRepository.findAll()) {

            boolean matchesCategory = bill.getBillCategory().equals(billCategory)
                    || billCategory.equals(BillCategory.ALL);
            boolean matchesBillName = bill.getBillName().equals(billName);

            if (matchesCategory && matchesBillName) {
                matchingBills.add(bill);
            }
        }

        return matchingBills;
    }
}

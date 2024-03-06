package com.paypilotprojectspring.bill.service;


import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.model.BillStatus;
import com.paypilotprojectspring.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BillGenericService {

    private final BillRepository billRepository;

    public Map<BillCategory, Integer> displayNumberOfBillsForEachType(BillCategory billCategory, LocalDate dateFrom, LocalDate dateTo, BillStatus billStatus) {
        Map<BillCategory, Integer> billOverview  = new HashMap<>();
        for (BillCategory category : BillCategory.values()) {
            if (billCategory == BillCategory.ALL)
                billOverview.put(category, 0);
        }

        if (billCategory == BillCategory.ALL) {
            for (Bill bill : billRepository.findAll()) {
                if ((bill.getBillDateFrom().isEqual(dateFrom) || bill.getBillDateFrom().isAfter(dateFrom)) &&
                        (bill.getBillDateTo().equals(dateTo) || bill.getBillDateFrom().isBefore(dateTo)) &&
                        bill.getBillStatus().equals(billStatus)) {
                    billOverview.put(bill.getBillCategory(), billOverview.getOrDefault(bill.getBillCategory(), 0) + 1);
                }
            }
        } else {
            for (Bill bill : billRepository.findAll()) {
                System.out.println(bill.getBillDateFrom());
                if (bill.getBillCategory().equals(billCategory) &&
                        (bill.getBillDateFrom().isEqual(dateFrom) || bill.getBillDateFrom().isAfter(dateFrom)) &&
                        (bill.getBillDateTo().equals(dateTo) || bill.getBillDateFrom().isBefore(dateTo)) &&
                        bill.getBillStatus().equals(billStatus)) {
                    billOverview.put(billCategory, billOverview.getOrDefault(billCategory, 0) + 1);
                }
//                else
//                    billOverview.put(billCategory, 0);
            }
        }
        return billOverview;
    }

    public List<Bill> getAllMatchingBills(BillCategory billCategory,
                                          LocalDate dateFrom,
                                          LocalDate dateTo) {
        List<Bill> matchingBills = new ArrayList<>();
        for (Bill bill : billRepository.findAll()) {

            boolean matchesCategory = bill.getBillCategory().equals(billCategory)
                                        || billCategory.equals(BillCategory.ALL);
            boolean matchesFromDate = bill.getBillDateFrom().isEqual(dateFrom)
                                        || bill.getBillDateFrom().isAfter(dateFrom);
            boolean matchesAfterDate= bill.getBillDateTo().equals(dateTo)
                                        || bill.getBillDateFrom().isBefore(dateTo);

            if (matchesCategory && matchesFromDate && matchesAfterDate) {
                matchingBills.add(bill);
            }
        }

        return matchingBills;
    }
}


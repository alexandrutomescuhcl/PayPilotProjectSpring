package com.paypilotprojectspring.bill.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDebtDTO {
    private long billId;
    private String billName;
    private String billCategory;
    private double amount;
    private int slNo;
    private int month;
    private int monthlyEMI;
    private int totalLoan;
    private String billLoanType;
    private String from;
    private String to;
    private String dueDate;
}

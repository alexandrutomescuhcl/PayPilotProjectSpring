package com.paypilotprojectspring.bill.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(schema = "SPRING", name = "PROJECT_BILL")
public class Bill {

    @Id
    private Long billId;
    @Column(name = "bill_name")
    private String billName;
    @Column(name = "bill_category")
    @Enumerated(EnumType.STRING)
    private BillCategory billCategory;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "amount")
    private double amount;
    @Column(name = "due_amount")
    private double due_amount;
    /**
     * The 'notes' field can be empty, it's not mandatory to be populated
     */
    @Column(name = "notes")
    private String notes;
    @Column(name = "is_recurrent")
    private boolean isRecurrent;
    @Column(name = "slNo")
    private int slNo;
    @Column(name = "month")
    private int month;
    @Column(name = "monthly_EMI")
    private int monthlyEMI;
    @Column(name = "total_loan")
    private int totalLoan;
    @Column(name = "bill_status")
    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;
    @Column(name = "bill_date_from")
    private LocalDate billDateFrom;
    @Column(name = "bill_date_to")
    private LocalDate billDateTo;
    @Column(name = "bill_loan_type")
    @Enumerated(EnumType.STRING)
    private BillLoanType billLoanType;
}
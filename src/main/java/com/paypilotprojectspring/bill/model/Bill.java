package com.paypilotprojectspring.bill.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypilotprojectspring.notification.model.Notification;
import com.paypilotprojectspring.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private Double due_amount;
    /**
     * The 'notes' field can be empty, it's not mandatory to be populated
     */
    @Column(name = "notes")
    private String notes;
    @Column(name = "is_recurrent")
    private boolean isRecurrent;
    @Column(name = "sl_no")
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
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("billId")
    private User user;
    @OneToMany
    List<Notification> notificationList;
}

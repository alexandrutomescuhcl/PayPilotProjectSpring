package com.paypilotprojectspring.scheduled_payment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypilotprojectspring.bank_details.model.BankDetails;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.scheduled_payment.utils.PaymentFrequency;
import com.paypilotprojectspring.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "SPRING", name = "SCHEDULED_PAYMENT")
public class ScheduledPayment {
    @Id
    private int id;

    @Column(name = "name_of_the_bill")
    private String nameOfTheBill;

    @Column(name = "purpose_of_payment")
    private String purposeOfPayment;

    @Column(name = "payee_name")
    private String payeeName;

    @Column(name = "payee_address")
    private String payeeAddress;

    @Column(name = "bill_date")
    private String billDate;

    @Column(name = "payment_frequency")
    @Enumerated(EnumType.STRING)
    private PaymentFrequency paymentFrequency;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payer_account")
    private String payerAccount;

    @Column(name = "enabled")
    private Boolean enabled;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Bill bill;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BankDetails bankDetails;
}

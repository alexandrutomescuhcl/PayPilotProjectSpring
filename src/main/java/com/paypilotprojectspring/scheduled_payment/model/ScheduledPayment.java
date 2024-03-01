package com.paypilotprojectspring.scheduled_payment.model;


import com.paypilotprojectspring.scheduled_payment.utils.PaymentFrequency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "SPRING", name = "SCHEDULED_PAYMENT")
@Getter
@Setter
public class ScheduledPayment {
    @Id
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "bill_id")
    private int billId;
    @Column(name = "bank_details_id")
    private int bankDetailsId;
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
    private PaymentFrequency paymentFrequency;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payer_account")
    private String payerAccount;
    @Column(name = "enabled")
    private Boolean enabled;


    public ScheduledPayment() {
    }

    public ScheduledPayment(int id,
                            int userId,
                            int billId,
                            int bankDetailsId,
                            Boolean enabled,
                            String billDate,
                            String payeeName,
                            String payeeAddress,
                            String payerAccount,
                            String nameOfTheBill,
                            String paymentMethod,
                            String purposeOfPayment,
                            PaymentFrequency paymentFrequency) {
        this.id = id;
        this.userId = userId;
        this.billId = billId;
        this.bankDetailsId = bankDetailsId;
        this.nameOfTheBill = nameOfTheBill;
        this.purposeOfPayment = purposeOfPayment;
        this.payeeName = payeeName;
        this.enabled = enabled;
        this.payeeAddress = payeeAddress;
        this.billDate = billDate;
        this.paymentFrequency = paymentFrequency;
        this.paymentMethod = paymentMethod;
        this.payerAccount = payerAccount;
    }
}

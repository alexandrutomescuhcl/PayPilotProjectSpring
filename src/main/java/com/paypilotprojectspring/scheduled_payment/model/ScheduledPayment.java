package com.paypilotprojectspring.scheduled_payment.model;


import com.paypilotprojectspring.scheduled_payment.utils.PaymentFrequency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "SPRING", name = "SCHEDULED_PAYMENT")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getNameOfTheBill() {
        return nameOfTheBill;
    }

    public void setNameOfTheBill(String nameOfTheBill) {
        this.nameOfTheBill = nameOfTheBill;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(PaymentFrequency paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public int getBankDetailsId() {
        return bankDetailsId;
    }

    public void setBankDetailsId(int bankDetailsId) {
        this.bankDetailsId = bankDetailsId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}

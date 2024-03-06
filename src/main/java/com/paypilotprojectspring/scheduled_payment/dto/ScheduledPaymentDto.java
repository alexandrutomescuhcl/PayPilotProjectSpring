package com.paypilotprojectspring.scheduled_payment.dto;

import com.paypilotprojectspring.bank_details.model.BankDetails;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.scheduled_payment.utils.PaymentFrequency;
import com.paypilotprojectspring.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduledPaymentDto {
    private int id;
    private int bankDetailsId;
    private Long userId;
    private Long billId;
    private String nameOfTheBill;
    private String purposeOfPayment;
    private String payeeName;
    private String payeeAddress;
    private String billDate;
    private PaymentFrequency paymentFrequency;
    private String paymentMethod;
    private String payerAccount;
    private Boolean enabled;
    private String nextPaymentDate;
    private Double amountToPay;
}

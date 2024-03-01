package com.paypilotprojectspring.scheduled_payment.dto;

import com.paypilotprojectspring.scheduled_payment.utils.PaymentFrequency;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduledPaymentDto {
    private int userId;
    private int billId;
    private int bankDetailsId;
    private String nameOfTheBill;
    private String purposeOfPayment;
    private String payeeName;
    private String payeeAddress;
    private String billDate;
    private PaymentFrequency paymentFrequency;
    private String paymentMethod;
    private String payerAccount;
    private Boolean enabled;
}

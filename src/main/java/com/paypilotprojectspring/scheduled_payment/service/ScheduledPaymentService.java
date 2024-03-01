package com.paypilotprojectspring.scheduled_payment.service;

import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentDto;
import com.paypilotprojectspring.scheduled_payment.dto.ScheduledPaymentUpdateDateDto;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduledPaymentService {
    ScheduledPayment createScheduledPayment(ScheduledPaymentDto dto);

    ScheduledPayment cancelScheduledPayment(int id);

    ScheduledPayment modifyScheduleDate(int id, ScheduledPaymentUpdateDateDto dto);

    List<ScheduledPayment> getAll();
}

package com.paypilotprojectspring.notification.dto;

import com.paypilotprojectspring.bill.dto.BillBaseDTO;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.notification.model.ReminderFrequency;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDTO {
    private Integer id;

    private BillBaseDTO bill;

    private String message;

}

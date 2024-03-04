package com.paypilotprojectspring.notification.dto;

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

    private Bill bill;

    private ReminderFrequency reminderFrequency;

    private LocalDateTime reminderStartDate;

    private String message;

    private Boolean notificationByEmail;

    private Boolean notificationInApp;
}

package com.paypilotprojectspring.notification.dto;

import com.paypilotprojectspring.notification.model.ReminderFrequency;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReminderSettingsDTO {
    private Integer id;

    private Boolean active;

    private ReminderFrequency reminderFrequency;

    private LocalDateTime reminderStartDate;

    private String message;

    private Boolean notificationByEmail;

    private Boolean notificationInApp;
}

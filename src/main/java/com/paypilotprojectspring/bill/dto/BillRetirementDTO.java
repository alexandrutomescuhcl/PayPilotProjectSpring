package com.paypilotprojectspring.bill.dto;

import com.paypilotprojectspring.notification.dto.ReminderSettingsDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRetirementDTO {

    private Long billId;
    private String billName;
    private String billCategory;
    private LocalDate dueDate;
    private String notes;
    private boolean isRecurrent;
    private int slNo;
    private int month;
    private double amount;
    private ReminderSettingsDTO reminderSettingsDTO;


}

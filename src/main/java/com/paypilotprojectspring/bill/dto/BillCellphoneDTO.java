package com.paypilotprojectspring.bill.dto;

import com.paypilotprojectspring.notification.dto.ReminderSettingsDTO;
import com.paypilotprojectspring.notification.model.ReminderSettings;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillCellphoneDTO {
    private long billId;
    private String billName;
    private String billCategory;
    private double amount;
    private int slNo;
    private int month;
    private String from;
    private String to;
    private String dueDate;
    private ReminderSettingsDTO reminderSettings;
}

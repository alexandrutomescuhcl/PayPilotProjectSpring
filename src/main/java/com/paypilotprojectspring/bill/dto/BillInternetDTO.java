package com.paypilotprojectspring.bill.dto;

import com.paypilotprojectspring.notification.dto.ReminderSettingsDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillInternetDTO {
    private long billId;
    private String billName;
    private String billCategory;
    private double amount;
    private int slNo;
    private int month;
    private String from;
    private String to;
    private String dueDate;
    private ReminderSettingsDTO reminderSettingsDTO;
}

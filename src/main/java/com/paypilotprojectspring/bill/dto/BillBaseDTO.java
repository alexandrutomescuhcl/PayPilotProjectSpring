package com.paypilotprojectspring.bill.dto;

import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.notification.dto.ReminderSettingsDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillBaseDTO {

    private Long billId;

    private String billName;

    private BillCategory billCategory;

    private double amount;

    private LocalDate billDateFrom;

    private LocalDate billDateTo;

    private ReminderSettingsDTO reminderSettings;

}

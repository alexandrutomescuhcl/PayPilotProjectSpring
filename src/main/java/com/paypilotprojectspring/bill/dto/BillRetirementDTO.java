package com.paypilotprojectspring.bill.dto;

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


}

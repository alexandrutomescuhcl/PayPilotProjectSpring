package com.paypilotprojectspring.bill.dto;

import com.paypilotprojectspring.bill.model.BillCategory;
import com.paypilotprojectspring.bill.model.BillStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequestDTO {
    private String billCategory;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String billStatus;
}
package com.paypilotprojectspring.bill.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillGroceriesDTO {

    private Long billId;
    private String billName;
    private String billCategory;
    private int slNo;
    private int month;
    private double amount;
}

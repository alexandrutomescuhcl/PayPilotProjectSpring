package com.paypilotprojectspring.bill.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRentDTO {

    private long billId;
    private String billName;
    private String billCategory;
    private int slNo;
    private int month;
    private String from;
    private String to;
    private double amount;
    private String dueDate;

}

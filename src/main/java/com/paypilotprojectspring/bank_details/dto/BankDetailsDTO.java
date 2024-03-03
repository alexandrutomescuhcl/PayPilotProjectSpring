package com.paypilotprojectspring.bank_details.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDetailsDTO {

    private int bankDetailsId;
    private String code;
    private String name;
    private int active;
    private String bic;
    private String accountNumber;
    private String bankISFC;
}

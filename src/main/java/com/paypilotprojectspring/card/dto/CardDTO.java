package com.paypilotprojectspring.card.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {

    private Long id;
    private String cardNumber;
    private String cardholderName;
    private String expiryDate;
    private Long bankId;
    private Double balance;
    private Double creditLimit;
    private String cardType;
}

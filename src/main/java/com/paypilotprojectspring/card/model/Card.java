package com.paypilotprojectspring.card.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "SPRING", name = "CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    private String cardType;
}

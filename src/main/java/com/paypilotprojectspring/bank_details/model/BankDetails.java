package com.paypilotprojectspring.bank_details.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "SPRING", name = "BANK_DETAILS")
public class BankDetails {
    @Id
    private int bankDetailsId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private int active;

    @Column(name = "bic")
    private String bic;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "bank_isfc")
    private String bankISFC;

    public BankDetails() {
    }

    public BankDetails(int bankDetailsId, String code, String name, int active, String bic, String accountNumber, String bankISFC) {
        this.bankDetailsId = bankDetailsId;
        this.code = code;
        this.name = name;
        this.active = active;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.bankISFC = bankISFC;
    }
}

package com.paypilotprojectspring.bill.model;

public enum BillStatus {
    UPCOMING("UPCOMING"),
    PENDING("PENDING"),
    PAID("PAID");
    private final String name;
    BillStatus(String name) {
        this.name = name;
    }
}

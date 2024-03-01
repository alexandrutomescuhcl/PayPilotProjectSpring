package com.paypilotprojectspring.user.model;

public enum BillStatus {
    UPCOMING("UPCOMING"),
    PENDING("PENDING"),
    PAID("PAID");
    private final String name;
    BillStatus(String name) {
        this.name = name;
    }
}

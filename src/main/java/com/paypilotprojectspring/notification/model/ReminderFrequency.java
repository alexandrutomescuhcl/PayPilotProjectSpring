package com.paypilotprojectspring.notification.model;

public enum ReminderFrequency  {
    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    BIMONTHLY("BIMONTHLY"),
    MONTHLY("MONTHLY");
    private final String name;

    ReminderFrequency(String name) {
        this.name = name;
    }
}

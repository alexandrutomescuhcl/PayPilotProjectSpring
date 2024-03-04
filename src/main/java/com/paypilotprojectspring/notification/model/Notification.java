package com.paypilotprojectspring.notification.model;

import com.paypilotprojectspring.bill.model.Bill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(schema = "SPRING", name = "NOTIFICATION")
public class Notification {
    @Id
    private Integer id;

    @ManyToOne
    private Bill bill;

    @Column(name = "reminder_frequency")
    private ReminderFrequency reminderFrequency;

    @Column(name = "reminder_start_date")
    private LocalDateTime reminderStartDate;

    @Column(name = "message")
    private String message;

    @Column(name = "notification_by_email")
    private Boolean notificationByEmail;

    @Column(name = "notification_in_app")
    private Boolean notificationInApp;


}

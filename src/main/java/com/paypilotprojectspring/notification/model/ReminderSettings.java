package com.paypilotprojectspring.notification.model;

import com.paypilotprojectspring.notification.model.ReminderFrequency;
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
@Table(schema = "SPRING", name = "REMINDER_SETTINGS")
public class ReminderSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "active")
    private Boolean active=false;

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



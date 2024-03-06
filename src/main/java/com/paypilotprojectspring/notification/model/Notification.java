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

    @Column(name = "message")
    private String message;

}

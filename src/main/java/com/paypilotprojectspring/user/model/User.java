package com.paypilotprojectspring.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.scheduled_payment.model.ScheduledPayment;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(schema = "SPRING", name = "PROJECT_USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "roles")
    private String roles;
    @Column(name = "pan_id")
    private Integer panId;
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @Column(name = "bank_lfsc_code")
    private String bankLfscCode;
    @Column(name = "bank_name")
    private String bankName;
    /*@JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bill> bills = new HashSet<>();*/
   /* @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ScheduledPayment> scheduledPayments = new HashSet<>();*/
}

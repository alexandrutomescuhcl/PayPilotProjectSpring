package com.paypilotprojectspring.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypilotprojectspring.bill.model.Bill;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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

    @Column(name = "pan_id")
    private Integer panId;
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @Column(name = "bank_lfsc_code")
    private String bankLfscCode;
    @Column(name = "bank_name")
    private String bankName;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bill> bills = new HashSet<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "SPRING",
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "active")
    private boolean active;

    @Column(name = "first_login")
    private boolean isFirstLogin;

    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;

    @Column(name = "is_account_locked")
    private boolean isAccountLocked;

}

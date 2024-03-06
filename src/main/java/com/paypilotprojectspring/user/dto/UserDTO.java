package com.paypilotprojectspring.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.paypilotprojectspring.bill.model.Bill;
import com.paypilotprojectspring.user.model.Role;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private List<Role> roles;
    private Integer panId;
    private String bankAccountNumber;
    private String bankLfscCode;
    private String bankName;
    private boolean active;
    private boolean isFirstLogin;
    private int failedLoginAttempts;
    private boolean isAccountLocked;
    private Set<Bill> billSet;


}

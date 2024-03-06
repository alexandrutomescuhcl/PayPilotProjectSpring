package com.paypilotprojectspring.user.dto.data;

import com.paypilotprojectspring.user.dto.UserDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseData {

    private String authenticationToken;
    private UserDTO user;
}
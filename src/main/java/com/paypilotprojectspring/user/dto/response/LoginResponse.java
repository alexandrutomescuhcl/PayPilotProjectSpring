package com.paypilotprojectspring.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paypilotprojectspring.user.dto.data.LoginResponseData;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    @JsonProperty("data")
    private LoginResponseData loginResponseData;
}

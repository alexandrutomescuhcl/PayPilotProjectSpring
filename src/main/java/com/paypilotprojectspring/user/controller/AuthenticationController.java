package com.paypilotprojectspring.user.controller;

import com.paypilotprojectspring.user.dto.request.LoginRequest;
import com.paypilotprojectspring.user.dto.response.LoginResponse;
import com.paypilotprojectspring.user.service.AuthenticationApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
@Slf4j
public class AuthenticationController {
  private final AuthenticationApplicationService authenticationApplicationService;

  @PostMapping
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
    return ResponseEntity.ok(authenticationApplicationService.authenticateUser(loginRequest));
  }
}

package com.paypilotprojectspring.user.service;

import com.paypilotprojectspring.user.config.security.TokenProvider;
import com.paypilotprojectspring.user.dto.UserDTO;
import com.paypilotprojectspring.user.dto.data.LoginResponseData;
import com.paypilotprojectspring.user.dto.request.LoginRequest;
import com.paypilotprojectspring.user.dto.response.LoginResponse;
import com.paypilotprojectspring.user.mapper.UserMapper;

import com.paypilotprojectspring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationApplicationService {
  private final TokenProvider tokenProvider;
  private final UserService userService;
  private final UserRepository userRepository;
  private final AuthenticationBusinessService authenticationBusinessService;
  private final UserMapper userMapper;

  public LoginResponse authenticateUser(LoginRequest loginRequest) {
    UserDTO user = userService.getByEmail(loginRequest.getEmail());
    try {
      Authentication authentication =
          authenticationBusinessService.manageContextAuthentication(loginRequest);
      String token = tokenProvider.createTokenFromAuthentication(authentication);
      return LoginResponse.builder()
          .loginResponseData(
              LoginResponseData.builder().authenticationToken(token).user(user).build())
          .build();
    } catch (AuthenticationException authenticationException) {
      System.out.println(authenticationException.getMessage());
      throw authenticationException;
    }
  }
}
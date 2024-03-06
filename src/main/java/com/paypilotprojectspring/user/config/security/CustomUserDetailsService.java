package com.paypilotprojectspring.user.config.security;

import com.paypilotprojectspring.user.mapper.UserMapper;
import com.paypilotprojectspring.user.mapper.UserToUserPrincipalMapper;
import com.paypilotprojectspring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService userService;
  private final UserMapper userMapper;
  private final UserToUserPrincipalMapper userToUserPrincipalMapper;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userToUserPrincipalMapper.mapUserToUserDetails(
        userMapper.dtoToEntity(userService.getByEmail(email)));
  }
}

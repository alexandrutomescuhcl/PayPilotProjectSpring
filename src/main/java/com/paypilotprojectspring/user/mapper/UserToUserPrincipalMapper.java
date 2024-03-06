package com.paypilotprojectspring.user.mapper;

import com.paypilotprojectspring.user.config.security.UserPrincipal;
import com.paypilotprojectspring.user.dto.UserDTO;
import com.paypilotprojectspring.user.model.Role;
import com.paypilotprojectspring.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Component
public class UserToUserPrincipalMapper {
  //    @Mapping(source = "id", target = "id")
  //    @Mapping(source = "email", target = "email")
  //    @Mapping(source = "password", target = "password")
  //    @Mapping(source = "roles", target = "authorities", qualifiedByName = "roleToAuthorities")
  //    @Mapping(source = "firstLogin", target = "isFirstLogin")
  //    @Mapping(source = "active", target = "active")
  //    UserPrincipal map(User user);
  //
  //    @Named("roleToAuthorities")
  //    default Collection<? extends GrantedAuthority> roleToAuthorities(List<Role> roleSet) {
  //        List<GrantedAuthority> result = new ArrayList<>();
  //        for (Role role : roleSet) {
  //            result.add(new SimpleGrantedAuthority(role.getName()));
  //        }
  //        return result;
  //    }

  public UserPrincipal mapUserToUserDetails(User user) {
    if (user == null) {
      return null;
    }
    UserPrincipal userPrincipal = new UserPrincipal();

    userPrincipal.setId(user.getId());
    userPrincipal.setEmail(user.getEmail());
    userPrincipal.setPassword(user.getPassword());
    userPrincipal.setFirstLogin(user.isFirstLogin());
    userPrincipal.setActive(user.isActive());
    userPrincipal.setFailedLoginAttempts(user.getFailedLoginAttempts());
    userPrincipal.setFirstName(user.getFirstName());
    userPrincipal.setLastName(user.getLastName());
    userPrincipal.setAuthorities(roleToAuthorities(user.getRoles()));

    return userPrincipal;
    }
    Collection<? extends GrantedAuthority> roleToAuthorities(List<Role> roleSet){
        List<GrantedAuthority> result = new ArrayList<>();
        for (Role role : roleSet) {
            result.add(new SimpleGrantedAuthority(role.getName()));
        }
        return result;
    }
}

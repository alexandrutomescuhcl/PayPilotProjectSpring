package com.paypilotprojectspring.user.mapper;

import com.paypilotprojectspring.user.config.security.UserPrincipal;
import com.paypilotprojectspring.user.model.Role;
import com.paypilotprojectspring.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "jsr330")
public interface UserToUserPrincipalMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "roles", target = "authorities", qualifiedByName = "roleToAuthorities")
    @Mapping(source = "firstLogin", target = "isFirstLogin")
    @Mapping(source = "active", target = "active")
    UserPrincipal map(User user);

    @Named("roleToAuthorities")
    default Collection<? extends GrantedAuthority> roleToAuthorities(List<Role> roleSet) {
        List<GrantedAuthority> result = new ArrayList<>();
        for (Role role : roleSet) {
            result.add(new SimpleGrantedAuthority(role.getName()));
        }
        return result;
    }
}

package com.paypilotprojectspring.user.mapper;

import com.paypilotprojectspring.user.dto.UserDTO;
import com.paypilotprojectspring.user.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserMapper {
    public UserDTO entityToDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRoles(user.getRoles());
        userDTO.setPanId(user.getPanId());
        userDTO.setBankAccountNumber(user.getBankAccountNumber());
        userDTO.setBankLfscCode(user.getBankLfscCode());
        userDTO.setBankName(user.getBankName());

        return userDTO;
    }

    public List<UserDTO> entitiesToDTOs(List<User> users) {
        if (users.isEmpty()) {
            return Collections.emptyList();
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(entityToDTO(user));
        }
        return userDTOS;
    }

    public User dtoToEntity(UserDTO user) {
        if (user == null) {
            return null;
        }
        User userEntity = new User();

        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAddress(user.getAddress());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setRoles(user.getRoles());
        userEntity.setPanId(user.getPanId());
        userEntity.setBankAccountNumber(user.getBankAccountNumber());
        userEntity.setBankLfscCode(user.getBankLfscCode());
        userEntity.setBankName(user.getBankName());

        return userEntity;
    }

    public List<User> dtosToEntities(List<UserDTO> userDTOS) {
        if (userDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        List<User> userEntities = new ArrayList<>();
        for (UserDTO user : userDTOS) {
            userEntities.add(dtoToEntity(user));
        }
        return userEntities;
    }
}

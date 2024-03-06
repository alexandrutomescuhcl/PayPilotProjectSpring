package com.paypilotprojectspring.user.service;

import com.paypilotprojectspring.user.dto.UserDTO;
import com.paypilotprojectspring.user.mapper.UserMapper;
import com.paypilotprojectspring.user.model.User;
import com.paypilotprojectspring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<UserDTO> getAll() {
    List<User> userList = userRepository.findAll();
    return userMapper.entitiesToDTOs(userList);
  }

  public Optional<UserDTO> getById(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.map(userMapper::entityToDTO);
  }

  public UserDTO getByEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);
    return userMapper.entityToDTO(user.get());
  }
}

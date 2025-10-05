package com.raavana.admin.service;

import com.raavana.admin.entity.UserEntity;
import com.raavana.admin.model.UserDTO;
import com.raavana.admin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String authEnroll(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "User already exists with this email";
        }
        else {
            UserEntity userEntity = UserEntity.builder()
                    .name(userDTO.getName())
                    .email(userDTO.getEmail())
                    .type(userDTO.getType())
                    .build();
            UserEntity savedEntity = userRepository.save(userEntity);
            return "User Registered Successfully";
        }
    }

}
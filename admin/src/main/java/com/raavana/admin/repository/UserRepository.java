package com.raavana.admin.repository;

import com.raavana.admin.entity.UserEntity;
import com.raavana.admin.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserDTO> findByEmail(String email);
}

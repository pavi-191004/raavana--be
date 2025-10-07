package com.raavana.admin.repository;

import com.raavana.admin.entity.PersonalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonalRepository extends MongoRepository<PersonalEntity, String> {
    Optional<PersonalEntity> findPersonalEntityByFullName(String fullName);
}


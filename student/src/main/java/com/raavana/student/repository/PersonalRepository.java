package com.raavana.student.repository;

import com.raavana.student.entity.PersonalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalRepository extends MongoRepository<PersonalEntity, String> {
}
